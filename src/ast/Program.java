package ast;

import java.util.List;

import visitor.Visitor;

public class Program extends AbstractASTNode {

	private List<Definition> definitions;

	public Program(int line, int column, List<Definition> definitions) {
		super(line, column);
		this.definitions = definitions;
	}

	//TODO RETURNING MUTABLE OBJECT. CHANGE
	public List<Definition> getDefinitions() {
		return definitions;
	}
	
	@Override
	public String toString() {
		return "Number of definitions: "+definitions.size();
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}
	
}
