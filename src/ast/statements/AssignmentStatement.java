package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

public class AssignmentStatement extends AbstractASTNode implements Statement {

	private Expression leftExpression;
	private Expression rightExpression;

	public AssignmentStatement(int line, int column, Expression e1, Expression e2) {
		super(line, column);
		this.leftExpression=e1;
		this.rightExpression=e2;
	}

	@Override
	public String toString() {
		return leftExpression.toString() + " = " + rightExpression.toString();
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
	
}
