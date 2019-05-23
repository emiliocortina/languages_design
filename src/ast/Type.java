package ast;

import java.util.List;

public interface Type extends ASTNode{

	Type arithmetic(int line, int column, Type type);
	Type unaryMinus(int line, int column);
	Type comparisson(int line, int column, Type t);
	Type logical(int line, int column, Type t);
	Type dot(int line, int column, String fieldName);
	Type squareBrackets(int line, int column, Expression exp);
	Type parenthesis(int line, int column, List<Type> argTypes);
	Type assignment(int line, int column, Type type);
	Type logicalNot(int line, int column);
	Type ret(int line, int column, Type returnType);
	
	boolean isLogical();
	boolean isArithmetic();
	int getNumberOfBytes();
	boolean isEquivalent(Type type);
	String getSuffix();
	boolean isBuiltIn();
	
	
}
