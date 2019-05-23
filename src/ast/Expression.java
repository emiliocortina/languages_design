package ast;

public interface Expression extends ASTNode {

	public boolean getLValue();
	public void setLValue(boolean lValue);
	public Type getType();
	public void setType(Type t);
}
