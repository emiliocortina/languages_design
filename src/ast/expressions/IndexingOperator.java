package ast.expressions;

import ast.Expression;
import visitor.Visitor;

public class IndexingOperator extends AbstractExpression {

	private Expression leftExpression;
	private Expression index;

	public IndexingOperator(int line, int column, Expression leftExpression, Expression index) {
		super(line, column);
		this.leftExpression = leftExpression;
		this.index = index;
	}

	@Override
	public String toString() {
		return leftExpression.toString() + "[" + index.toString() + "]";
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Expression getLeftExpression() {
		return leftExpression;
	}

	public Expression getIndex() {
		return index;
	}
	
	

}
