package ast.expressions;

import visitor.Visitor;

public class CharLiteralExpression extends AbstractExpression {

	private char value;

	public CharLiteralExpression(int line, int column, char value) {
		super(line, column);
		this.value = value;
	}

	@Override
	public String toString() {
		return ""+value;
	}

	@Override
	public boolean getLValue() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public char getValue() {
		return value;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	
}
