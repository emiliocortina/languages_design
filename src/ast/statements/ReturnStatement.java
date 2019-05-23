package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

public class ReturnStatement extends AbstractASTNode implements Statement {

	private Expression returnExpression;

	public ReturnStatement(int line, int column, Expression e) {
		super(line, column);
		this.returnExpression = e;
	}

	@Override
	public String toString() {
		return "return " + returnExpression;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Expression getReturnExpression() {
		return returnExpression;
	}

}
