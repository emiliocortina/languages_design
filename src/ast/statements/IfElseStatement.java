package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Statement;
import visitor.Visitor;

public class IfElseStatement extends AbstractASTNode implements Statement {

	private Expression expression;
	private List<Statement> ifBlock;
	private List<Statement> elseBlock=new ArrayList<Statement>();

	public IfElseStatement(int line, int column, Expression e, List<Statement> ifBlock) {
		super(line, column);
		this.expression = e;
		this.ifBlock = ifBlock;
	}

	public void addElse(List<Statement> elseBlock) {
		this.elseBlock = elseBlock;
	}

	@Override
	public String toString() {
		String s = "if (" + expression.toString() + ") {\n";
		for(Statement statement : ifBlock)
			s += statement.toString()+"\n";
		
		if(elseBlock.size()>0) {
			s+= "} else {\n";
			for(Statement statement : elseBlock)
				s += statement.toString() + "\n";
		}
		
		s+= "} ";
		
		return s;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Expression getExpression() {
		return expression;
	}

	public List<Statement> getIfBlock() {
		return ifBlock;
	}

	public List<Statement> getElseBlock() {
		return elseBlock;
	}
	
	
}
