package ast.expressions;

import ast.Definition;
import visitor.Visitor;

public class Variable extends AbstractExpression {

	private String name;
	private Definition definition;

	public Variable(int line, int column, String name) {
		super(line, column);
		this.name = name;
	}
	
	@Override
	public String toString() {
		return  name;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public String getName() {
		return name;
	}

	public void setDefinition(Definition d) {
		this.definition=d;
	}
	
	public Definition getDefinition() {
		return definition;
	}

}
