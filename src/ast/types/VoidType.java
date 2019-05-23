package ast.types;

import ast.Type;
import visitor.Visitor;

public class VoidType extends AbstractType implements Type{

	public VoidType(int line, int column) {
		super(line, column);
	}
	
	@Override
	public String toString() {
		return "void";
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	@Override
	public int getNumberOfBytes() {
		return 0;
	}

	@Override
	public boolean isEquivalent(Type type) {
		return type instanceof VoidType;
	}

	@Override
	public String getSuffix() {
		// TODO Auto-generated method stub
		return null;
	}

}
