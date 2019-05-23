package ast.types;

import ast.Type;
import errorHandler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType implements Type {

	private String message;

	public ErrorType(int line, int column, String message) {
		super(line, column);
		this.message = message;
		ErrorHandler.getInstance().addError(this);
	}

	public String getMessage() {
		return message;
	}

	@Override
	public <TP, TR> TR accept(Visitor<TP, TR> visitor, TR param) {
		return visitor.visit(this, param);
	}

	@Override
	public int getNumberOfBytes() {
		return 4;
	}

	@Override
	public boolean isEquivalent(Type type) {
		return false;
	}

	@Override
	public String getSuffix() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
