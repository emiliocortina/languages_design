package errorHandler;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ast.types.ErrorType;

public class ErrorHandler {
	
	private static ErrorHandler errorHandler;
	private List<ErrorType> errors;
	
	private ErrorHandler() {
		errors = new ArrayList<ErrorType>();
	}
	

	public static ErrorHandler getInstance() {
		if(errorHandler==null) {
			errorHandler = new ErrorHandler();
			return errorHandler;
		}
		return errorHandler;
	}
	
	public boolean anyError() {
		return errors.isEmpty();
	}
	
	public void addError(ErrorType err) {
		errors.add(err);
	}
	
	public void showErrors(PrintStream stream) {
		for(ErrorType er : errors) {
			stream.println(er.getMessage()+" at "+er.getLine()+":"+er.getColumn());
		}
	}
	
}
