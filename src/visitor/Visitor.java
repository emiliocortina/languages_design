package visitor;

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

public interface Visitor<TP, TR> {
	
	TR visit(Program program, TR param);
	TR visit(RecordField recordField, TR param);

	// Definitions
	TR visit(FuncDefinition funcDefinition, TR param);
	TR visit(VarDefinition varDefinition, TR param);

	// Expressions
	TR visit(ArithmeticExpression arithmeticExpression, TR param);
	TR visit(CastExpression castExpression, TR param);
	TR visit(CharLiteralExpression charLiteralExpression, TR param);
	TR visit(FieldAccess fieldAccess, TR param);
	TR visit(IndexingOperator indexingOperator, TR param);
	TR visit(IntLiteralExpression intLiteralExpression, TR param);
	TR visit(LogicalExpression logicalExpression, TR param);
	TR visit(LogicalNotExpression logicalNotExpression, TR param);
	TR visit(RealLiteralExpression realLiteralExpression, TR param);
	TR visit(UnaryMinusExpression unaryMinusExpression, TR param);
	TR visit(Variable variable, TR param);
	TR visit(ComparissonExpression comparissonExpression, TR param);
	
	// Statements
	TR visit(AssignmentStatement assignmentStatement, TR param);
	TR visit(FuncInvStatement funcInvStatement, TR param);
	TR visit(IfElseStatement ifElseStatement, TR param);
	TR visit(ReadStatement readStatement, TR param);
	TR visit(ReturnStatement returnStatement, TR param);
	TR visit(WhileStatement whileStatement, TR param);
	TR visit(WriteStatement writeStatement, TR param);
	
	// Types
	TR visit(ArrayType arrayType, TR param);
	TR visit(CharType charType, TR param);
	TR visit(DoubleType doubleType, TR param);
	TR visit(ErrorType errorType, TR param);
	TR visit(FunctionType functionType, TR param);
	TR visit(IntType intType, TR param);
	TR visit(StructType structType, TR param);
	TR visit(VoidType voidType, TR param);
	
	
}
