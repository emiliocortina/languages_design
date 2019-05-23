package ast.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ast.RecordField;
import ast.Type;
import ast.definitions.VarDefinition;
import visitor.Visitor;

public class StructType extends AbstractType implements Type {

	private List<RecordField> fields;

	public StructType(int line, int column) {
		super(line, column);
		this.fields = new ArrayList<RecordField>();
	}

	public void addDef(List<VarDefinition> definitions) {
		for (VarDefinition d : definitions) {
			RecordField f = new RecordField(d.getLine(), d.getColumn(), d.getName(), d.getType());
			fields.add(f);
		}
		checkUniqueness();
	}

	@Override
	public String toString() {
		/*String s = "struct {\n";
		for (RecordField field : fields)
			s += "\t" + field.toString() + ";\n";
		s += "}";*/
		String s = "record(";
		for (RecordField field : fields)
			s += field.toString()+"x";
		s = s.substring(0, s.length()-1);
		s += ")";
		return s;
	}

	private void checkUniqueness() {
		Set<String> set = new HashSet<String>();
		for (RecordField field : fields) {
			if (!set.contains(field.getName()))
				set.add(field.getName());
			else {
				String message = "Duplicated variable definition '" + field.getName() + "' in type Struct.";
				ErrorType error = new ErrorType(field.getLine(), field.getColumn(), message);
			}

		}

	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public List<RecordField> getFields() {
		return fields;
	}

	@Override
	public int getNumberOfBytes() {
		int bytes = 0;
		for(RecordField rf : this.fields) {
			bytes += rf.getType().getNumberOfBytes();
		}
		return bytes;
	}
	
	@Override
	public Type dot(int line, int column, String fieldName) {
		Type fieldType = existsField(fieldName);
		if(fieldType!=null) {
			return fieldType;
		}
		return new ErrorType(line, column,
				"Field '"+ fieldName +"' does not exist in type "+ this.toString());
	}

	private Type existsField(String field) {
		for(RecordField rf : this.fields) {
			if(rf.getName().equals(field))
				return rf.getType();
		}
		return null;
	}

	@Override
	public boolean isEquivalent(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	public RecordField getField(String field) {
		for(RecordField rf : this.fields) {
			if(rf.getName().equals(field))
				return rf;
		}
		return null;
	}

	@Override
	public String getSuffix() {
		// TODO Auto-generated method stub
		return null;
	}
}
