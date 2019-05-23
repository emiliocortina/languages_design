package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class ArithmeticExpression extends AbstractExpression {

	private Expression leftExpression;
	private Expression rightExpression;
	private String operator;

	public ArithmeticExpression(int line, int column, Expression leftExpression, String operator, Expression rightExpression) {
		super(line, column);
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
		this.operator = operator;
		}

	@Override
	public String toString() {
		return leftExpression.toString() + " " + operator + " " + rightExpression.toString();
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Expression getLeftExpression() {
		return leftExpression;
	}

	public Expression getRightExpression() {
		return rightExpression;
	}

	public String getOperator() {
		return operator;
	}


}
