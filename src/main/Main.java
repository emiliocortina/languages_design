package main;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ast.Program;
import codegeneration.ExecuteVisitor;
import codegeneration.OffsetVisitor;
import errorHandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import parser.CmmLexer;
import parser.CmmParser;
import visitor.IdentificationVisitor;
import visitor.TypeCheckingVisitor;
import visitor.Visitor;


public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		CmmParser parser = new CmmParser(tokens);	
		Program programAST = parser.program().ast;		
		
		Visitor<Void,Void> v = new IdentificationVisitor();
		v.visit(programAST, null);
		
		Visitor<Void,Void> v2 = new TypeCheckingVisitor();
		v2.visit(programAST, null);
		
		Visitor<Void, Boolean> v3 = new OffsetVisitor();
		v3.visit(programAST, false);
		
		ExecuteVisitor executeVisitor = new ExecuteVisitor();
		executeVisitor.visit(programAST, null);
		
		IntrospectorModel model=new IntrospectorModel("program", programAST);
		new IntrospectorTree("Introspector", model);
		
		ErrorHandler.getInstance().showErrors(System.err);
	}
	

}
