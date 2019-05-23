package ast.types;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public class CharType extends AbstractType implements Type{

	public CharType(int line, int column) {
		super(line, column);
	}

	@Override
	public String toString() {
		return "char";
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}
	
	@Override
	public Type arithmetic(int line, int column, Type type) {
		if(type.isArithmetic())
			return new IntType(line, column);
		return super.arithmetic(line, column, type);
	}

	@Override
	public boolean isArithmetic() {
		return true;
	}

	@Override
	public int getNumberOfBytes() {
		return 1;
	}

	@Override
	public boolean isEquivalent(Type type) {
		return type instanceof CharType;
	}
	
	@Override
	public Type assignment(int line, int column, Type type) {
		if(this.isEquivalent(type)) {
			return this;
		}
		return new ErrorType(line, column,
				"Cannot assign " + type.toString() + " to " +  this.toString());
	}

	@Override
	public String getSuffix() {
		return "b";
	}
	
	@Override
	public boolean isBuiltIn() {
		return true;
	}
}
