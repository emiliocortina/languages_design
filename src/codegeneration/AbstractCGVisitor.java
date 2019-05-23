package codegeneration;

import ast.Program;
import ast.RecordField;
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
import visitor.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

	@Override
	public TR visit(Program program, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(RecordField recordField, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(FuncDefinition funcDefinition, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(VarDefinition varDefinition, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(ArithmeticExpression arithmeticExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(CastExpression castExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(CharLiteralExpression charLiteralExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(FieldAccess fieldAccess, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(IndexingOperator indexingOperator, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(IntLiteralExpression intLiteralExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(LogicalExpression logicalExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(LogicalNotExpression logicalNotExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(RealLiteralExpression realLiteralExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(UnaryMinusExpression unaryMinusExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(Variable variable, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(ComparissonExpression comparissonExpression, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(AssignmentStatement assignmentStatement, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(FuncInvStatement funcInvStatement, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(IfElseStatement ifElseStatement, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(ReadStatement readStatement, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(ReturnStatement returnStatement, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(WhileStatement whileStatement, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(WriteStatement writeStatement, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(ArrayType arrayType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(CharType charType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(DoubleType doubleType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(ErrorType errorType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(FunctionType functionType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(IntType intType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(StructType structType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

	@Override
	public TR visit(VoidType voidType, TR param) {
		assert(false);
		throw new IllegalStateException();
	}

}
