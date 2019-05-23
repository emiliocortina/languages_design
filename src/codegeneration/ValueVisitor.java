package codegeneration;

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
import ast.expressions.Variable;
import ast.statements.FuncInvStatement;

public class ValueVisitor extends AbstractCGVisitor<Void, Void> {

	private CodeGenerator cg;
	private AddressVisitor addressVisitor;

	public ValueVisitor(CodeGenerator cg) {
		this.cg = cg;
	}

	public void setAddressVisitor(AddressVisitor addressvisitor) {
		this.addressVisitor = addressvisitor;
	}

	@Override
	public Void visit(CharLiteralExpression charLiteralExpression, Void param) {
		cg.push("b", charLiteralExpression.getValue());
		return null;
	}

	@Override
	public Void visit(IntLiteralExpression intLiteralExpression, Void param) {
		cg.push("i", intLiteralExpression.getValue());
		return null;
	}

	@Override
	public Void visit(RealLiteralExpression realLiteralExpression, Void param) {
		cg.push("f", realLiteralExpression.getValue());
		return null;
	}

	@Override
	public Void visit(Variable variable, Void param) {
		variable.accept(addressVisitor, param);
		cg.load(variable.getType().getSuffix());
		return null;
	}

	@Override
	public Void visit(ArithmeticExpression arithmeticExpression, Void param) {
		arithmeticExpression.getLeftExpression().accept(this, param);
		if(!arithmeticExpression.getLeftExpression().getType().isEquivalent(arithmeticExpression.getType())) {
			cg.convert(arithmeticExpression.getLeftExpression().getType().getSuffix(), arithmeticExpression.getType().getSuffix());
		}
		arithmeticExpression.getRightExpression().accept(this, param);
		if(!arithmeticExpression.getRightExpression().getType().isEquivalent(arithmeticExpression.getType())) {
			cg.convert(arithmeticExpression.getRightExpression().getType().getSuffix(), arithmeticExpression.getType().getSuffix());
		}
		switch (arithmeticExpression.getOperator()) {
		case "+":
			cg.add(arithmeticExpression.getType().getSuffix());
			break;
		case "-":
			cg.sub(arithmeticExpression.getType().getSuffix());
			break;
		case "*":
			cg.mul(arithmeticExpression.getType().getSuffix());
			break;
		case "/":
			cg.div(arithmeticExpression.getType().getSuffix());
			break;
		case "%":
			cg.mod(arithmeticExpression.getType().getSuffix());
			break;
		default:
			assert(false);
			throw new IllegalStateException();
		}

		return null;
	}
	
	@Override
	public Void visit(ComparissonExpression comparissonExpression, Void param) {
		comparissonExpression.getLeftExpression().accept(this, param);
		comparissonExpression.getRightExpression().accept(this, param);
		switch (comparissonExpression.getOperator()) { //'>'|'>='|'<'|'<='|'!='|'=='
		case ">":
			cg.gt(comparissonExpression.getType().getSuffix());
			break;
		case "<":
			cg.lt(comparissonExpression.getType().getSuffix());
			break;
		case ">=":
			cg.ge(comparissonExpression.getType().getSuffix());
			break;
		case "<=":
			cg.le(comparissonExpression.getType().getSuffix());
			break;
		case "==":
			cg.eq(comparissonExpression.getType().getSuffix());
			break;
		case "!=":
			cg.ne(comparissonExpression.getType().getSuffix());
			break;
		default:
			assert(false);
			throw new IllegalStateException();
		}
		
		return null;
	}
	
	@Override
	public Void visit(LogicalExpression logicalExpression, Void param) {
		logicalExpression.getLeftExpression().accept(this, param);
		logicalExpression.getRightExpression().accept(this, param);
		switch (logicalExpression.getOperator()) {
		case "&&":
			cg.and(logicalExpression.getType().getSuffix());
			break;
		case "||":
			cg.or(logicalExpression.getType().getSuffix());
			break;
		default:
			assert(false);
			throw new IllegalStateException();
		}
		return null;
	}

	@Override
	public Void visit(LogicalNotExpression logicalNotExpression, Void param) {
		logicalNotExpression.getExpression().accept(this, param);
		cg.not();
		return null;
	}


	@Override
	public Void visit(IndexingOperator indexingOperator, Void param) {
		indexingOperator.accept(addressVisitor, param);
		cg.load(indexingOperator.getType().getSuffix());
		return null;
	}

	@Override
	public Void visit(FieldAccess fieldAccess, Void param) {
		fieldAccess.accept(addressVisitor, param);
		cg.load(fieldAccess.getType().getSuffix());
		return null;
	}
	
	@Override
	public Void visit(FuncInvStatement funcInvStatement, Void param) {
		funcInvStatement.getArguments().forEach(e -> e.accept(this, param));
		cg.call(funcInvStatement.getVariable().getName());
		return null;
	}
	
	@Override
	public Void visit(CastExpression castExpression, Void param) {
		castExpression.getCastedExpression().accept(this, param);
		cg.convert(castExpression.getCastedExpression().getType().getSuffix(), castExpression.getType().getSuffix());
		return null;
	}

}
