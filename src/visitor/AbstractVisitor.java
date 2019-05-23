package visitor;

import ast.Definition;
import ast.Expression;
import ast.Program;
import ast.RecordField;
import ast.Statement;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.ArithmeticExpression;
import ast.expressions.CastExpression;
import ast.expressions.CharLiteralExpression;
import ast.expressions.ComparissonExpression;
import ast.expressions.FieldAccess;
import ast.expressions.IndexingOperator;
import ast.expressions.IntLiteralExpression;
import ast.expressions.LogicalExpression;
import ast.expressions.LogicalNotExpression;
import ast.expressions.RealLiteralExpression;
import ast.expressions.UnaryMinusExpression;
import ast.expressions.Variable;
import ast.statements.AssignmentStatement;
import ast.statements.FuncInvStatement;
import ast.statements.IfElseStatement;
import ast.statements.ReadStatement;
import ast.statements.ReturnStatement;
import ast.statements.WhileStatement;
import ast.statements.WriteStatement;
import ast.types.ArrayType;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.StructType;
import ast.types.VoidType;

public class AbstractVisitor<T, R> implements Visitor<T, R>{

	@Override
	public R visit(Program program, R param) {
		for(Definition d : program.getDefinitions()) {
			d.accept(this, param);
		}
		return param;
	}

	@Override
	public R visit(RecordField recordField, R param) {
		recordField.getType().accept(this, param);
		return param;
	}

	@Override
	public R visit(FuncDefinition funcDefinition, R param) {
		funcDefinition.getType().accept(this, param);
		for(Statement s : funcDefinition.getBody())
			s.accept(this, param);
		return param;
	}

	@Override
	public R visit(VarDefinition varDefinition, R param) {
		varDefinition.getType().accept(this, param);
		return param;
	}

	@Override
	public R visit(ArithmeticExpression expression, R param) {
		expression.getLeftExpression().accept(this, param);
		expression.getRightExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(CastExpression expression, R param) {
		expression.getCastedExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(CharLiteralExpression charLiteralExpression, R param) {
		return param;
	}

	@Override
	public R visit(FieldAccess fieldAccess, R param) {
		fieldAccess.getExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(IndexingOperator indexingOperator, R param) {
		indexingOperator.getLeftExpression().accept(this, param);
		indexingOperator.getIndex().accept(this, param);
		return param;
	}

	@Override
	public R visit(IntLiteralExpression intLiteralExpression, R param) {
		return param;
	}

	@Override
	public R visit(LogicalExpression logicalExpression, R param) {
		logicalExpression.getLeftExpression().accept(this, param);
		logicalExpression.getRightExpression().accept(this, param);
		return param;
	}
	
	@Override
	public R visit(ComparissonExpression comparissonExpression, R param) {
		comparissonExpression.getLeftExpression().accept(this, param);
		comparissonExpression.getRightExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(LogicalNotExpression logicalNotExpression, R param) {
		logicalNotExpression.getExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(RealLiteralExpression realLiteralExpression, R param) {
		return param;
	}

	@Override
	public R visit(UnaryMinusExpression unaryMinusExpression, R param) {
		unaryMinusExpression.getExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(Variable variable, R param) {
		return param;
	}

	@Override
	public R visit(AssignmentStatement assignmentStatement, R param) {
		assignmentStatement.getLeftExpression().accept(this, param);
		assignmentStatement.getRightExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(FuncInvStatement funcInvStatement, R param) {
		funcInvStatement.getVariable().accept(this, param);
		for(Expression e : funcInvStatement.getArguments())
			e.accept(this, param);
		return param;
	}

	@Override
	public R visit(IfElseStatement statement, R param) {
		statement.getExpression().accept(this, param);
		for(Statement s : statement.getIfBlock())
			s.accept(this, param);
		for(Statement s : statement.getElseBlock())
			s.accept(this, param);
		return param;
	}

	@Override
	public R visit(ReadStatement readStatement, R param) {
		readStatement.getExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(ReturnStatement returnStatement, R param) {
		returnStatement.getReturnExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(WhileStatement whileStatement, R param) {
		whileStatement.getExpression().accept(this, param);
		for(Statement s : whileStatement.getBlock())
			s.accept(this, param);
		return param;
	}

	@Override
	public R visit(WriteStatement writeStatement, R param) {
		writeStatement.getExpression().accept(this, param);
		return param;
	}

	@Override
	public R visit(ArrayType arrayType, R param) {
		arrayType.getType().accept(this, param);
		return param;
	}

	@Override
	public R visit(CharType charType, R param) {
		return param;
	}

	@Override
	public R visit(DoubleType doubleType, R param) {
		return param;
	}

	@Override
	public R visit(ErrorType errorType, R param) {
		return param;
	}

	@Override
	public R visit(FunctionType functionType, R param) {
		functionType.getReturnType().accept(this, param);
		for(VarDefinition d : functionType.getParameters())
			d.accept(this, param);
		return param;
	}

	@Override
	public R visit(IntType intType, R param) {
		return param;
	}

	@Override
	public R visit(StructType structType, R param) {
		for(RecordField r : structType.getFields())
			r.accept(this, param);
		return param;
	}

	@Override
	public R visit(VoidType voidType, R param) {
		return param;
	}

	

}
