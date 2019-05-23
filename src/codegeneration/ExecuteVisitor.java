package codegeneration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ast.Program;
import ast.Type;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.AssignmentStatement;
import ast.statements.FuncInvStatement;
import ast.statements.IfElseStatement;
import ast.statements.ReadStatement;
import ast.statements.ReturnStatement;
import ast.statements.WhileStatement;
import ast.statements.WriteStatement;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteVisitor extends AbstractCGVisitor<Void, Void> {

	CodeGenerator cg;
	ValueVisitor valuevisitor;
	AddressVisitor addressvisitor;

	private int localVariablesSize;
	private int parametersSize;

	public ExecuteVisitor() throws IOException {
		cg = new CodeGenerator();
		valuevisitor = new ValueVisitor(cg);
		addressvisitor = new AddressVisitor(cg);

		valuevisitor.setAddressVisitor(addressvisitor);
		addressvisitor.setValueVisitor(valuevisitor);
	}

	@Override
	public Void visit(Program program, Void param) {
		program.getDefinitions().forEach(d -> {
			if (d instanceof VarDefinition)
				d.accept(this, param);
		});
		cg.callMain();
		program.getDefinitions().forEach(d -> {
			if (d instanceof FuncDefinition)
				d.accept(this, param);
		});
		cg.close();
		return null;
	}

	@Override
	public Void visit(FuncDefinition funcDefinition, Void param) {
		cg.line(funcDefinition.getLine());
		this.localVariablesSize = 0;
		this.parametersSize = 0;

		cg.id(funcDefinition.getName());

		// Parameters
		cg.comment("Parameters");
		((FunctionType) funcDefinition.getType()).getParameters().forEach(vd -> {
			vd.accept(this, param);
			parametersSize += vd.getType().getNumberOfBytes();
		});

		// Local Variables
		cg.comment("Local variables");
		List<VarDefinition> localVariables = new ArrayList<VarDefinition>();
		funcDefinition.getBody().forEach(vd -> {
			if (vd instanceof VarDefinition) {
				((VarDefinition) vd).accept(this, param);
				localVariables.add((VarDefinition) vd);
			}
		});

		// Enter
		if (localVariables.size() > 0) {
			this.localVariablesSize = -localVariables.get(localVariables.size() - 1).getOffset();
		} else {
			this.localVariablesSize = 0;
		}
		cg.enter(localVariablesSize);

		// Statements
		funcDefinition.getBody().forEach(s -> {
			if (!(s instanceof VarDefinition))
				s.accept(this, param);
		});

		if ((((FunctionType) funcDefinition.getType()).getReturnType() instanceof VoidType)) {
			cg.ret(0, this.localVariablesSize, this.parametersSize);
		}
		return null;
	}

	@Override
	public Void visit(ReadStatement readStatement, Void param) {
		cg.line(readStatement.getLine());
		cg.comment("Read");
		readStatement.getExpression().accept(addressvisitor, param);
		cg.in(readStatement.getExpression().getType().getSuffix());
		cg.store(readStatement.getExpression().getType().getSuffix());
		return null;
	}

	@Override
	public Void visit(WriteStatement writeStatement, Void param) {
		cg.line(writeStatement.getLine());
		cg.comment("Write");
		writeStatement.getExpression().accept(valuevisitor, param);
		cg.out(writeStatement.getExpression().getType().getSuffix());
		return null;
	}

	@Override
	public Void visit(AssignmentStatement assignmentStatement, Void param) {
		cg.line(assignmentStatement.getLine());
		assignmentStatement.getLeftExpression().accept(addressvisitor, param);
		assignmentStatement.getRightExpression().accept(valuevisitor, param);
		cg.store(assignmentStatement.getLeftExpression().getType().getSuffix());
		return null;
	}

	@Override
	public Void visit(VarDefinition varDefinition, Void param) {
		cg.comment(varDefinition.getType().toString() + " " + varDefinition.getName() + " (offset "
				+ varDefinition.getOffset() + ")");
		return null;
	}

	@Override
	public Void visit(WhileStatement whileStatement, Void param) {
		cg.comment("While");
		cg.line(whileStatement.getLine());
		int labelNumber = cg.getLabels(2);
		cg.label(labelNumber);
		whileStatement.getExpression().accept(valuevisitor, param);
		cg.jz(labelNumber + 1);
		cg.comment("Body of the while statement");
		whileStatement.getBlock().forEach(s -> s.accept(this, param));
		cg.jmp(labelNumber);
		cg.label(labelNumber + 1);
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement, Void param) {
		cg.comment("If statement");
		cg.line(ifElseStatement.getLine());
		int labelNumber = cg.getLabels(2);
		ifElseStatement.getExpression().accept(valuevisitor, param);
		// cg.label(labelNumber);
		cg.jz(labelNumber);
		cg.comment("Body of the if branch");
		ifElseStatement.getIfBlock().forEach(s -> s.accept(this, param));
		cg.jmp(labelNumber + 1);
		cg.label(labelNumber);
		cg.comment("Body of the else branch");
		ifElseStatement.getElseBlock().forEach(s -> s.accept(this, param));
		cg.label(labelNumber + 1);

		return null;
	}

	@Override
	public Void visit(ReturnStatement returnStatement, Void param) {
		cg.line(returnStatement.getLine());
		cg.comment("Return");
		returnStatement.getReturnExpression().accept(valuevisitor, param);
		cg.ret(returnStatement.getReturnExpression().getType().getNumberOfBytes(), this.localVariablesSize,
				this.parametersSize);
		return null;
	}

	@Override
	public Void visit(FuncInvStatement funcInvStatement, Void param) {
		cg.line(funcInvStatement.getLine());
		funcInvStatement.getArguments().forEach(e -> e.accept(valuevisitor, param));
		cg.call(funcInvStatement.getVariable().getName());
		Type returnType = ((FunctionType) funcInvStatement.getVariable().getType()).getReturnType();
		if (!(returnType instanceof VoidType))
			cg.pop(returnType.getSuffix());
		return null;
	}

}
