package codegeneration;

import ast.definitions.VarDefinition;
import ast.expressions.FieldAccess;
import ast.expressions.IndexingOperator;
import ast.expressions.Variable;
import ast.types.StructType;

public class AddressVisitor extends AbstractCGVisitor<Void, Void>{

	CodeGenerator cg;
	ValueVisitor valuevisitor;
	
	public AddressVisitor(CodeGenerator cg) {
		this.cg = cg;
	}
	
	public void setValueVisitor(ValueVisitor valuevisitor) {
		this.valuevisitor = valuevisitor;
	}
	
	//TODO CHECK THIS DIFFERENCE BETWEEN PARAMETERS AND LOCAL VARIABLES
	@Override
	public Void visit(Variable variable, Void param) {
		if(variable.getDefinition().getScope() == 0) { //Global variable
			cg.push("a", ((VarDefinition)variable.getDefinition()).getOffset());
		} else {
			cg.bp();
			cg.push("i", ((VarDefinition)variable.getDefinition()).getOffset());
			cg.add("i");
		}
		return null;
	}
	
	@Override
	public Void visit(IndexingOperator indexingOperator, Void param) {
		indexingOperator.getLeftExpression().accept(this, param);
		indexingOperator.getIndex().accept(valuevisitor, param);
		cg.push("i", indexingOperator.getType().getNumberOfBytes());
		cg.mul("i");
		cg.add("i");
		return null;
	}
	
	@Override
	public Void visit(FieldAccess fieldAccess, Void param) {
		fieldAccess.getExpression().accept(this, param);
		cg.push("i", ((StructType)fieldAccess.getExpression().getType()).getField(fieldAccess.getField()).getOffset());
		cg.add("i");
		return null;
	}


}
