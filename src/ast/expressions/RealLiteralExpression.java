package ast.expressions;

import visitor.Visitor;

public class RealLiteralExpression extends AbstractExpression {

	private double value;

	public RealLiteralExpression(int line, int column, double value) {
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
	
	public double getValue() {
		return value;
	}
}
