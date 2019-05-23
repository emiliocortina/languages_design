package visitor;

import ast.Expression;
import ast.RecordField;
import ast.Statement;
import ast.Type;
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
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.ErrorType;
import ast.types.FunctionType;
import ast.types.IntType;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {
	
	Type returnType;

	@Override
	public Void visit(ArithmeticExpression expression, Void param) {
		expression.getLeftExpression().accept(this, param);
		expression.getRightExpression().accept(this, param);
		expression.setLValue(false);
		expression.setType(expression.getLeftExpression().getType().arithmetic(expression.getLine(), expression.getColumn(), expression.getRightExpression().getType()));
		return null;
	}

	@Override
	public Void visit(CastExpression expression, Void param) {
		expression.getCastedExpression().accept(this, param);
		expression.setLValue(false);
		if(!(expression.getCastedExpression().getType().isBuiltIn() && expression.getType().isBuiltIn()))
			expression.setType(new ErrorType(expression.getLine(), expression.getColumn(), "Casts Must be between built in types"));
		return null;
	}

	@Override
	public Void visit(CharLiteralExpression expression, Void param) {
		expression.setLValue(false);
		expression.setType(new CharType(expression.getLine(), expression.getColumn()));
		return null;
	}

	@Override
	public Void visit(FieldAccess expression, Void param) {
		expression.getExpression().accept(this, param);
		expression.setLValue(true);
		expression.setType(expression.getExpression().getType().dot(expression.getLine(), expression.getColumn(),
				expression.getField()));
		return null;
	}

	@Override
	public Void visit(IndexingOperator expression, Void param) {
		expression.getLeftExpression().accept(this, param);
		expression.getIndex().accept(this, param);
		expression.setLValue(true);
		expression.setType(expression.getLeftExpression().getType().squareBrackets(expression.getLine(),
				expression.getColumn(), expression.getIndex()));
		return null;
	}

	@Override
	public Void visit(IntLiteralExpression expression, Void param) {
		expression.setLValue(false);
		expression.setType(new IntType(expression.getLine(), expression.getColumn()));
		return null;
	}

	@Override
	public Void visit(LogicalExpression expression, Void param) {
		expression.getLeftExpression().accept(this, param);
		expression.getRightExpression().accept(this, param);
		expression.setLValue(false);
		expression.setType(expression.getLeftExpression().getType().logical(expression.getLine(),
				expression.getColumn(), expression.getRightExpression().getType()));
		return null;
	}

	@Override
	public Void visit(ComparissonExpression comparissonExpression, Void param) {
		comparissonExpression.getLeftExpression().accept(this, param);
		comparissonExpression.getRightExpression().accept(this, param);
		comparissonExpression.setLValue(false);
		comparissonExpression.setType(
				comparissonExpression.getLeftExpression().getType().comparisson(comparissonExpression.getLine(),
						comparissonExpression.getColumn(), comparissonExpression.getRightExpression().getType()));
		return param;
	}

	@Override
	public Void visit(LogicalNotExpression expression, Void param) {
		expression.getExpression().accept(this, param);
		expression.setLValue(false);
		expression.setType(expression.getExpression().getType().logicalNot(expression.getLine(), expression.getColumn()));
		return null;
	}

	@Override
	public Void visit(RealLiteralExpression expression, Void param) {
		expression.setLValue(false);
		expression.setType(new DoubleType(expression.getLine(), expression.getColumn()));
		return null;
	}

	@Override
	public Void visit(UnaryMinusExpression expression, Void param) {
		expression.getExpression().accept(this, param);
		expression.setLValue(false);
		expression
				.setType(expression.getExpression().getType().unaryMinus(expression.getLine(), expression.getColumn()));
		return null;
	}

	@Override
	public Void visit(Variable expression, Void param) {
		expression.setLValue(true);
		Type t;
		if (expression.getDefinition() == null) {
			t = new ErrorType(expression.getLine(), expression.getColumn(),
					"Variable '" + expression.getName() + "' is not defined");
		} else {
			t = expression.getDefinition().getType();
		}
		expression.setType(t);
		return null;
	}

	@Override
	public Void visit(FuncInvStatement funcInvStatement, Void param) {
		funcInvStatement.getVariable().accept(this, param);
		for (Expression e : funcInvStatement.getArguments())
			e.accept(this, param);
		funcInvStatement.setType(funcInvStatement.getVariable().getType().parenthesis(funcInvStatement.getLine(),
				funcInvStatement.getColumn(), funcInvStatement.getArgumentsTypes()));
		return param;
	}
	
	@Override
	public Void visit(ReturnStatement returnStatement, Void param) {
		returnStatement.getReturnExpression().accept(this, param);
		returnStatement.getReturnExpression().getType().ret(returnStatement.getLine(), returnStatement.getColumn(), returnType);
		return param;
	}

	@Override
	public Void visit(FunctionType functionType, Void param) {
		functionType.getReturnType().accept(this, param);
		for(VarDefinition d : functionType.getParameters())
			d.accept(this, param);
		this.returnType = functionType.getReturnType();
		return param;
	}
	
	@Override
	public Void visit(AssignmentStatement assignmentStatement, Void param) {
		assignmentStatement.getLeftExpression().accept(this, param);
		assignmentStatement.getRightExpression().accept(this, param);
		if (!assignmentStatement.getLeftExpression().getLValue())
			new ErrorType(assignmentStatement.getLine(), assignmentStatement.getColumn(),
					"Assignment expression is not a valid expression (left value)");
		assignmentStatement.getLeftExpression().getType().assignment(assignmentStatement.getLine(), assignmentStatement.getColumn(), assignmentStatement.getRightExpression().getType());
		return param;
	}

	@Override
	public Void visit(ReadStatement readStatement, Void param) {
		readStatement.getExpression().accept(this, param);
		if (!readStatement.getExpression().getType().isBuiltIn())
			new ErrorType(readStatement.getLine(), readStatement.getColumn(),
					"Read expression is not a valid expression (left value)");
		return param;
	}
	
	@Override
	public Void visit(WriteStatement writeStatement, Void param) {
		writeStatement.getExpression().accept(this, param);
//		if (!writeStatement.getExpression().getLValue())
//			new ErrorType(writeStatement.getLine(), writeStatement.getColumn(),
//					"Write expression is not a valid expression (left value)");
		return param;
	}

	@Override
	public Void visit(WhileStatement whileStatement, Void param) {
		whileStatement.getExpression().accept(this, param);
		for (Statement s : whileStatement.getBlock())
			s.accept(this, param);
		if (!whileStatement.getExpression().getType().isLogical()) {
			new ErrorType(whileStatement.getLine(), whileStatement.getColumn(),
					"While expression is not a logical expression");
		}
		return param;
	}
	
	@Override
	public Void visit(IfElseStatement statement, Void param) {
		statement.getExpression().accept(this, param);
		for(Statement s : statement.getIfBlock())
			s.accept(this, param);
		for(Statement s : statement.getElseBlock())
			s.accept(this, param);
		if (!statement.getExpression().getType().isLogical()) {
			new ErrorType(statement.getLine(), statement.getColumn(),
					"If/Else expression is not a logical expression");
		}
		return param;
	}
	
}
