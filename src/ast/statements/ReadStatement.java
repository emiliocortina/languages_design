package ast.statements;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

public class ReadStatement extends AbstractASTNode implements Statement {

	private Expression expression;
	
	public ReadStatement(int line, int column, Expression e0) {
		super(line, column);
		this.expression = e0;
	}
	

	@Override
	public String toString() {
		return "read "+expression;
	}


	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}


	public Expression getExpression() {
		return expression;
	}

	
	
}
