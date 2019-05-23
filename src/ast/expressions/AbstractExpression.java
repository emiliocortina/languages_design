package ast.expressions;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression {

	boolean lValue;
	private Type type;
	
	public AbstractExpression(int line, int column) {
		super(line, column);
	}

	@Override
	public boolean getLValue() {
		return lValue;
	}
	
	@Override
	public void setLValue(boolean lValue) {
		this.lValue = lValue;
	}
	
	@Override
	public Type getType() {
		return type;
	}
	
	@Override
	public void setType(Type t) {
		type = t;
	}

}
