grammar Cmm;
@header {
import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
}	

program returns [Program ast]: 
		definitions {$ast = new Program(0, 0, $definitions.ast);}
       ;

definitions returns [List<Definition> ast = new ArrayList<Definition>()]:	
			(vd=var_definition {for(VarDefinition v : $vd.ast) {$ast.add(v);}} | fd=func_definition {$ast.add($fd.ast);})* m=main {$ast.add($m.ast);}
			;
				
main returns [FuncDefinition ast]: 	
		t='void' 'main' '(' ')' fb=func_body {FunctionType type = new FunctionType( $fb.start.getLine(),
																				$fb.start.getCharPositionInLine()+1,
																				new VoidType($t.getLine(), $t.getCharPositionInLine()),
																				new ArrayList<VarDefinition>());
			
					$ast = new FuncDefinition($fb.start.getLine(), $fb.start.getCharPositionInLine()+1, "main", type,  $fb.ast);}
		;
       
var_definition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]: 
				t=type v0=ID { $ast.add(new VarDefinition($v0.getLine(), $v0.getCharPositionInLine(), $v0.text, $t.ast));} 
				(',' v1=ID {$ast.add(new VarDefinition($v1.getLine(), $v1.getCharPositionInLine(), $v1.text, $t.ast));})* ';'
				;
  		
func_definition returns [FuncDefinition ast]: 
			{Type t;}
			(ty=type {t=$ty.ast;} | v='void' {t=new VoidType($v.getLine(), $v.getCharPositionInLine());}) 
			name=ID '(' param=parameters ')'  body=func_body 
			{FunctionType ftype = new FunctionType( $body.start.getLine(), $body.start.getCharPositionInLine()+1, t, $param.ast);
			$ast = new FuncDefinition($name.getLine(), $name.getCharPositionInLine()+1, $name.text, ftype, $body.ast);}
			;

parameters returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]: 
			| t0=type n0=ID {$ast.add(new VarDefinition($n0.getLine(), $n0.getCharPositionInLine()+1, $n0.text, $t0.ast));}
				(',' t1=type n1=ID {$ast.add(new VarDefinition($n1.getLine(), $n1.getCharPositionInLine()+1, $n1.text, $t1.ast));})*
			;

func_body returns [List<Statement> ast = new ArrayList<Statement>()]:
		 	'{' (vd=var_definition {for(VarDefinition v:$vd.ast) {$ast.add(v);}})* (s=statement {$ast.addAll($s.ast);})* '}'
			;
			
statement returns [List<Statement> ast = new ArrayList<Statement>()]:	 
			e1=expression '=' e2=expression ';' 
				{$ast.add(new AssignmentStatement($e1.start.getLine(),$e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast));}
			| fi=func_invocation ';' {$ast.add($fi.ast);}
			
			| r='return' e=expression ';' {$ast.add(new ReturnStatement($r.getLine(), $r.getCharPositionInLine()+1, $e.ast));}
			
			| i='if' '(' e=expression ')' b=block  {$ast.add(new IfElseStatement($i.getLine(), $i.getCharPositionInLine()+1,
				$e.ast, $b.ast));}
				('else' b2=block {((IfElseStatement)$ast.get(0)).addElse($b2.ast);})?
			
			| w='while' '(' e=expression ')' b=block {$ast.add(new WhileStatement($w.getLine(), $w.getCharPositionInLine()+1, $e.ast, $b.ast));}
			
			| r='read' e0=expression {$ast.add(new ReadStatement($r.getLine(), $r.getCharPositionInLine()+1, $e0.ast));}
				(',' e1=expression {$ast.add(new ReadStatement($r.getLine(), $r.getCharPositionInLine()+1, $e1.ast));})* ';'	
			
			| w='write' e0=expression {$ast.add(new WriteStatement($w.getLine(), $w.getCharPositionInLine()+1, $e0.ast));}
				(',' e1=expression {$ast.add(new WriteStatement($w.getLine(), $w.getCharPositionInLine()+1, $e1.ast));})* ';'
			;
				
arguments returns [List<Expression> ast = new ArrayList<Expression>()]: 
			| e0=expression {$ast.add($e0.ast);}
				(',' e1=expression {$ast.add($e1.ast);})*
			;		
					
block returns [List<Statement> ast = new ArrayList<Statement>()]:
	 	s0=statement {$ast.addAll($s0.ast);}
		| '{' (s1=statement {$ast.addAll($s1.ast);})* '}'
		;	
										

expression returns [Expression ast]:	 
			'(' t=type ')' e=expression {$ast = new CastExpression($t.start.getLine(), $t.start.getCharPositionInLine()+1, $t.ast, $e.ast);}
			| (i=INT_CONSTANT {$ast = new IntLiteralExpression($i.getLine(), $i.getCharPositionInLine()+1, LexerHelper.lexemeToInt($i.text));} 
				| r=REAL_CONSTANT {$ast = new RealLiteralExpression($r.getLine(), $r.getCharPositionInLine()+1, LexerHelper.lexemeToReal($r.text));}
				| c=CHAR_CONSTANT {$ast = new CharLiteralExpression($c.getLine(), $c.getCharPositionInLine()+1, LexerHelper.lexemeToChar($c.text));})
			| name=ID {$ast = new Variable($name.getLine(), $name.getCharPositionInLine()+1, $name.text);}
			| '(' e=expression ')' {$ast = $e.ast;}
			| e1=expression '[' e2=expression ']' {$ast = new IndexingOperator($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $e2.ast);}
			| e1=expression '.' field=ID {$ast = new FieldAccess($e1.start.getLine(), $e1.start.getCharPositionInLine()+1, $e1.ast, $field.text);}
			| m='-' e=expression {$ast = new UnaryMinusExpression($m.getLine(), $m.getCharPositionInLine()+1, $e.ast);}
			| e1=expression op=('*'|'/'|'%') e2=expression {$ast = new ArithmeticExpression($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast);}
			| e1=expression op=('+'|'-') e2=expression{$ast = new ArithmeticExpression($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast);}
			| not='!' e=expression {$ast = new LogicalNotExpression($not.getLine(), $not.getCharPositionInLine()+1, $e.ast);}
			| e1=expression op=('>'|'>='|'<'|'<='|'!='|'==') e2=expression {$ast = new ComparissonExpression($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast);}
			| e1=expression op=('&&' | '||') e2=expression {$ast = new LogicalExpression($op.getLine(), $op.getCharPositionInLine()+1, $e1.ast, $op.text, $e2.ast);}			
			| fi=func_invocation {$ast = $fi.ast;}
			;
			
func_invocation returns [FuncInvStatement ast]: 
				name=ID '(' arg=arguments ')' 
					{$ast = new FuncInvStatement($name.getLine(), $name.getCharPositionInLine()+1, 
						new Variable($name.getLine(), $name.getCharPositionInLine()+1, $name.text), $arg.ast);}
				;
			
type returns [Type ast]:
	 	b = built_in_type {$ast = $b.ast;}
		| t=type '[' n=INT_CONSTANT ']' {$ast = ArrayType.getArrayType($n.getLine(), $n.getCharPositionInLine()+1, $t.ast, LexerHelper.lexemeToInt($n.text));}
		| s='struct' {$ast = new StructType($s.getLine(), $s.getCharPositionInLine()+1);} '{' (vd=var_definition  {((StructType)$ast).addDef($vd.ast);})+ '}' 
		;
		
built_in_type returns [Type ast]:
			 	i='int' {$ast = new IntType($i.getLine(), $i.getCharPositionInLine()+1);}
				| i='char' {$ast = new CharType($i.getLine(), $i.getCharPositionInLine()+1);}
				| i='double' {$ast = new DoubleType($i.getLine(), $i.getCharPositionInLine()+1);}
				;

  		
fragment
LETTER: [a-zA-Z] 
		;

fragment
DIGIT:	[0-9]
		;
		

ID:	(LETTER|'_') (LETTER|'_'|DIGIT)*
	;
  		 
INT_CONSTANT: 	'0'
				| [1-9][0-9]* 
            	;

REAL_CONSTANT: 	INT_CONSTANT? '.' DIGIT+
				| INT_CONSTANT '.' DIGIT*
				| INT_CONSTANT ('.' DIGIT*)? ('e'|'E') ('-')? INT_CONSTANT
				;
	
CHAR_CONSTANT: 	'\'' . '\''
				| '\'' '\\' INT_CONSTANT '\''
				| '\'' '\\' ('n'|'t') '\''
				;
		
WS: ('\r'|'\n'|' '|'\t')+ -> skip
	;
		
SINGLE_LINE_COMMENT:	'//' .*? ('\r'|'\n'|EOF) -> skip
						;

MULTIPLE_LINE_COMMENT: 	'/*' .*? '*/' -> skip
						;
            
            