package ast.statements;

import java.util.List;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

public class WhileStatement extends AbstractASTNode implements Statement {

	private Expression expression;
	private List<Statement> block;

	public WhileStatement(int line, int column, Expression e, List<Statement> block) {
		super(line, column);
		this.expression = e;
		this.block = block;
	}

	@Override
	public String toString() {
		String s = "while (" + expression.toString() + ") {\n";
		for(Statement statement : block)
			s += "\t" + statement.toString()+"\n";
		s += "}";
		return s;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Expression getExpression() {
		return expression;
	}

	public List<Statement> getBlock() {
		return block;
	}
	
	

}
