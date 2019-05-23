package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class FieldAccess extends AbstractExpression {

	private Expression expression;
	private String fieldName;

	public FieldAccess(int line, int column, Expression e, String field) {
		super(line, column);
		this.expression=e;
		this.fieldName = field;
	}

	@Override
	public String toString() {
		return expression.toString()+"."+fieldName;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Expression getExpression() {
		return expression;
	}

	public String getField() {
		return fieldName;
	}

	
}
