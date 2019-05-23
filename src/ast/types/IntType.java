package ast.types;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public class IntType extends AbstractType implements Type{

	public IntType(int line, int column) {
		super(line, column);
	}

	
	@Override
	public String toString() {
		return "int";
	}


	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}
	
	// Better with instanceof?? Because if the exp is double we are returning int
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
	public boolean isLogical() {
		return true;
	}
	
	@Override
	public Type unaryMinus(int line, int column) {
		return this;
	}
	
	@Override
	public Type comparisson(int line, int column, Type t) {
		if(t instanceof IntType || t instanceof DoubleType)
			return new IntType(line, column);
		return super.comparisson(line, column, t);
	}
	
	@Override
	public Type logical(int line, int column, Type t) {
		if(t instanceof IntType) {
			return this;
		}
		return  new ErrorType(line, column, "Cannot compare " + this.toString() + " and " + t.toString());
	}


	@Override
	public int getNumberOfBytes() {
		return 2;
	}


	@Override
	public boolean isEquivalent(Type type) {
		return type instanceof IntType;
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
		return "i";
	}
	
	@Override
	public boolean isBuiltIn() {
		return true;
	}
	
	@Override
	public Type logicalNot(int line, int column) {
		return this;
	}
}
