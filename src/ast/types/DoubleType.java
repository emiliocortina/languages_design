package ast.types;

import ast.Expression;
import ast.Type;
import visitor.Visitor;

public class DoubleType extends AbstractType implements Type{

	public DoubleType(int line, int column) {
		super(line, column);
	}

	@Override
	public String toString() {
		return "real";
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}
	
	@Override
	public Type arithmetic(int line, int column, Type type) {
		if(type.isArithmetic())
			return new DoubleType(line, column);
		return super.arithmetic(line, column, type);
	}
	
	@Override
	public boolean isArithmetic() {
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
	public int getNumberOfBytes() {
		return 4;
	}

	@Override
	public boolean isEquivalent(Type type) {
		return type instanceof DoubleType;
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
		return "f";
	}
	
	@Override
	public boolean isBuiltIn() {
		return true;
	}

}
