package ast;

import visitor.Visitor;

public interface ASTNode {

	int getLine();
	int getColumn();
	
	//TODO CHANGE PARAMETER TYPE TO TP
	public <TP, TR> TR accept(Visitor<TP,TR> visitor, TR param);
	
}
