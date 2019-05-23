package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class ComparissonExpression extends AbstractExpression {


	private Expression leftExpression;
	private Expression rightExpression;
	private String operator;

	public ComparissonExpression(int line, int column, Expression e1, String op, Expression e2) {
		super(line, column);
		this.leftExpression=e1;
		this.rightExpression=e2;
		this.operator=op;
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
