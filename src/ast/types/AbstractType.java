package ast.types;

import java.util.List;

import ast.AbstractASTNode;
import ast.Expression;
import ast.Type;

public abstract class AbstractType extends AbstractASTNode implements Type {

	public AbstractType(int line, int column) {
		super(line, column);
	}

	@Override
	public Type arithmetic(int line, int column, Type type) {
		return new ErrorType(line, column,
				"Cannot perform arithmetic operation with types " + this.toString() + " and " + type.toString());
	}

	@Override
	public Type unaryMinus(int line, int column) {
		return new ErrorType(line, column, "Cannot perform unary minus over type " + this.toString());
	}

	@Override
	public Type comparisson(int line, int column, Type t) {
		return new ErrorType(line, column,
				"Cannot perform logical operation with types " + this.toString() + " and " + t.toString());
	}

	@Override
	public Type logical(int line, int column, Type t) {
		return new ErrorType(line, column, "Cannot compare " + this.toString() + " and " + t.toString());
	}

	@Override
	public Type dot(int line, int column, String fieldName) {
		return new ErrorType(line, column, "Cannot perform field access to type " + this.toString());
	}

	@Override
	public Type squareBrackets(int line, int column, Expression exp) {
		return new ErrorType(line, column, "Cannot perform indexing to type " + this.toString());
	}

	@Override
	public Type parenthesis(int line, int column, List<Type> argTypes) {
		return new ErrorType(line, column, "Cannot perform function invocation to type " + this.toString());
	}

	@Override
	public Type assignment(int line, int column, Type type) {
		return new ErrorType(line, column, "Cannot assign " + type.toString() + " to " + this.toString());
	}

	@Override
	public boolean isLogical() {
		return false;
	}

	@Override
	public boolean isArithmetic() {
		return false;
	}

	@Override
	public Type ret(int line, int column, Type returnType) {
		if (!this.isEquivalent(returnType)) {
			return new ErrorType(line, column, "Cannot return " + this + ", expected " + returnType);
		}
		return null;
	}
	
	@Override
	public boolean isBuiltIn() {
		return false;
	}
	
	@Override
	public Type logicalNot(int line, int column) {
		return new ErrorType(line, column, "Cannot perform logical not" );
	}

}
