package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class LogicalNotExpression extends AbstractExpression {

	private Expression expression;

	public LogicalNotExpression(int line, int column, Expression e) {
		super(line, column);
		this.expression = e;
	}

	@Override
	public String toString() {
		return "!" + expression.toString();
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Expression getExpression() {
		return expression;
	}

	
}
