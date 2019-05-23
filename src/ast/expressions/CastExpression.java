package ast.expressions;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public class CastExpression extends AbstractExpression {

	private Type type;
	private Expression castedExpression;

	public CastExpression(int line, int column, Type t, Expression e) {
		super(line, column);
		this.type=t;
		this.castedExpression=e;
	}

	@Override
	public String toString() {
		return "("+ type.toString() + ")" + castedExpression.toString();
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Type getType() {
		return type;
	}

	public Expression getCastedExpression() {
		return castedExpression;
	}

}
