package ast.types;

import java.util.List;

import ast.Type;
import ast.definitions.VarDefinition;
import parser.CmmParser.ArgumentsContext;
import visitor.Visitor;

public class FunctionType extends AbstractType implements Type {

	private List<VarDefinition> parameters;
	private Type returnType;

	public FunctionType(int line, int column, Type returnType, List<VarDefinition> arguments) {
		super(line, column);
		this.returnType = returnType;
		this.parameters = arguments;
	}

	@Override
	public String toString() {
		String s = returnType + "(";
		
		for(int i=0; i<parameters.size(); i++) {
			s += parameters.get(i);
			if(i+1<parameters.size()) {
				s +=", ";
			}
		}
		s+=")";
		return s;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	public List<VarDefinition> getParameters() {
		return parameters;
	}

	public Type getReturnType() {
		return returnType;
	}

	@Override
	public int getNumberOfBytes() {
		return 4;
	}

	@Override
	public Type parenthesis(int line, int column, List<Type> argTypes) {
		if(checkArguments(argTypes)) {
			return this;
		}
		return new ErrorType(line, column, "Wrong arguments when invoking function "+this);
	}

	private boolean checkArguments(List<Type> argTypes) {
		if(argTypes.size()!=this.parameters.size()) {
			return false;
		}
		for(int i=0; i<parameters.size(); i++) {
			if(!(parameters.get(i).getType().isEquivalent(argTypes.get(i)))){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEquivalent(Type type) {
		//TODO
		return false;
	}

	@Override
	public String getSuffix() {
		return this.returnType.getSuffix();
	}

}
