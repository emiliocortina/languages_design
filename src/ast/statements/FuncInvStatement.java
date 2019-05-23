package ast.statements;

import java.util.List;
import java.util.stream.Collectors;

import ast.Expression;
import ast.Statement;
import ast.Type;
import ast.expressions.AbstractExpression;
import ast.expressions.Variable;
import visitor.Visitor;

public class FuncInvStatement extends AbstractExpression implements Statement {

	private Variable variable;
	private List<Expression> arguments;

	public FuncInvStatement(int line, int column, Variable name, List<Expression> arguments) {
		super(line, column);
		this.variable = name;
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		String s =  variable.toString() + "(";
		int i = 0;
		for(Expression e : arguments) {
			s += e;
			i++;
			if(i<arguments.size()) {
				s += ", ";
			}
			
		}
		s+=")";
		
		return s;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public Variable getVariable() {
		return variable;
	}

	public List<Expression> getArguments() {
		return arguments;
	}

	public List<Type> getArgumentsTypes() {
		return this.arguments.stream().map(a -> a.getType()).collect(Collectors.toList());
	}
	
	

}
