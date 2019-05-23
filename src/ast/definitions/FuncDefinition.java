package ast.definitions;

import java.util.List;

import ast.Statement;
import ast.Type;
import visitor.Visitor;

public class FuncDefinition extends AbstractDefinition{

	private List<Statement> body;

	public FuncDefinition(int line, int column, String name, Type type, List<Statement> body) {
		super(line, column, name, type);
		this.body = body;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += type.toString() + " " + name +" {\n";
		
		for(Statement statement : body)
			s += "\t" + statement.toString()+"\n";
		s += "}";
		
		return s;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public List<Statement> getBody() {
		return body;
	}
}
