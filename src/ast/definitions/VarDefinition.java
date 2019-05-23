package ast.definitions;

import ast.Definition;
import ast.Statement;
import ast.Type;
import visitor.Visitor;

public class VarDefinition extends AbstractDefinition implements Definition, Statement {


	private int offset;

	public VarDefinition(int line, int column, String name, Type type) {
		super(line, column, name, type);
	}

	@Override
	public String toString() {
		return type.toString() + " " + name;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	

	

}
