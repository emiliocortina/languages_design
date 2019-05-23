package ast.types;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public class ArrayType extends AbstractType implements Type {

	private Type type;
	private int size;

	public ArrayType(int line, int column, Type t, int size) {
		super(line, column);
		this.type = t;
		this.size = size;

	}

	@Override
	public String toString() {
		return "[" + size + "," + type.toString() +"]";
	}

	public static ArrayType getArrayType(int line, int column, Type type, int size) {
		if (type instanceof ArrayType) {
			ArrayType outerType = (ArrayType) type;
			ArrayType divingType = (ArrayType) type;
			// If the diving type is still an ArrayType we keep diving the array.
			while (divingType.type instanceof ArrayType) {
				divingType = (ArrayType) divingType.type;
			}
			divingType.type = new ArrayType(line, column, divingType.type, size);
			return outerType;
		} else
			return new ArrayType(line, column, type, size);

	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Type getType() {
		return type;
	}

	@Override
	public Type squareBrackets(int line, int column, Expression exp) {
		if (exp.getType() instanceof IntType)
			return this.type;
		return super.squareBrackets(line, column, exp);
	}

	@Override
	public int getNumberOfBytes() {
		return this.type.getNumberOfBytes() * this.size;
	}

	@Override
	public boolean isEquivalent(Type type) {
		if (type instanceof ArrayType) {
			return this.type.isEquivalent(((ArrayType) type).getType());
		}
		return false;
	}
	
	@Override
	public Type assignment(int line, int column, Type type) {
		if(this.isEquivalent(type)) {
			return this;
		}
		return new ErrorType(line, column,
				"Cannot assign " + type.toString() + " to " +  this.toString());
	}

	@Override
	public String getSuffix() {
		// TODO Auto-generated method stub
		return null;
	}



}
