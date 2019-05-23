package ast.expressions;

import visitor.Visitor;

public class IntLiteralExpression extends AbstractExpression {

	private int value;

	public IntLiteralExpression(int line, int column, int value) {
		super(line, column);
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}
	
	public int getValue() {
		return value;
	}

}
