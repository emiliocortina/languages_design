package visitor;

import ast.Definition;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.types.ErrorType;
import ast.types.FunctionType;
import symbolTable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

	SymbolTable symbolTable;

	public IdentificationVisitor() {
		symbolTable = new SymbolTable();
	}

	@Override
	public Void visit(VarDefinition definition, Void param) {
		if (!symbolTable.insert(definition))
			new ErrorType(definition.getLine(), definition.getColumn(),
					"Variable '" + definition.getName() + "' was alread defined");
		return param;
	}


	@Override
	public Void visit(FuncDefinition definition, Void param) {
		//TODO CHECK IF IT COULD INSERT
		symbolTable.insert(definition);
		symbolTable.set();
		definition.getType().accept(this, param);
		for (Statement s : definition.getBody())
			s.accept(this, param);
		symbolTable.reset();
		return param;
	}

	@Override
	public Void visit(Variable variable, Void param) {
		Definition d = symbolTable.find(variable.getName());
		if (d != null) {
			variable.setDefinition(d);
		} else {
			new ErrorType(variable.getLine(), variable.getColumn(),
					"Variable '" + variable.getName() + "' is not defined");
		}
		return param;
	}
}
