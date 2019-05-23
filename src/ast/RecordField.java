package ast;

import visitor.Visitor;

public class RecordField extends AbstractASTNode {


	private Type type;
	private String name;
	private int offset;

	public RecordField(int line, int column, String name, Type type) {
		super(line, column);
		this.type = type;
		this.name = name;
	}

	@Override
	public String toString() {
		//return type.toString() + " " + name;
		return "(" + name + " x " + type.toString() + ")";
	}

	public String getName() {
		return name;
	}

	public Type getType(){
		return type;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public void setType(Type t) {
		this.type = t;
	}

	public int getOffset() {
		return offset;
	}
	

	

}
