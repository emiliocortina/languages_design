package codegeneration;

import ast.RecordField;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.types.FunctionType;
import ast.types.StructType;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Void, Boolean> {
	
	private int globalBytesSum = 0;
	private int localBytesSum = 0;
	private int parametersBytesSum = 0;

	@Override
	public Boolean visit(VarDefinition varDefinition, Boolean isLocalVariable) {
		varDefinition.getType().accept(this, isLocalVariable); 
		int scope = varDefinition.getScope();
		if(scope == 0) {
			varDefinition.setOffset(globalBytesSum);
			globalBytesSum += varDefinition.getType().getNumberOfBytes();
		}else {
			if(isLocalVariable) {
				localBytesSum += varDefinition.getType().getNumberOfBytes();
				varDefinition.setOffset(-localBytesSum);
			}else {
				varDefinition.setOffset(parametersBytesSum);
				parametersBytesSum += varDefinition.getType().getNumberOfBytes();
			}
		}
		return false;
	}
	
	@Override
	public Boolean visit(StructType structType, Boolean param) {
		int fieldsBytesSum = 0;
		for(RecordField r : structType.getFields()) {
			r.setOffset(fieldsBytesSum);
			fieldsBytesSum += r.getType().getNumberOfBytes();
			r.accept(this, param);
		}
		return param;
	}
	
	@Override
	public Boolean visit(FunctionType functionType, Boolean param) {
		parametersBytesSum = 4;
		functionType.getReturnType().accept(this, param);
		for(int i=functionType.getParameters().size()-1; i>=0; i--) {
			VarDefinition d = functionType.getParameters().get(i);
			d.accept(this, false);
		}
		return param;
	}
	
	@Override
	public Boolean visit(FuncDefinition funcDefinition, Boolean param) {
		localBytesSum = 0;
		funcDefinition.getType().accept(this, param);
		for(Statement s : funcDefinition.getBody())
			s.accept(this, true);
		return param;
	}
}
