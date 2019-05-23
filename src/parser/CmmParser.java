// Generated from src/parser/Cmm.g4 by ANTLR 4.7
package parser;

import ast.*;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, ID=37, INT_CONSTANT=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, WS=41, SINGLE_LINE_COMMENT=42, MULTIPLE_LINE_COMMENT=43;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_main = 2, RULE_var_definition = 3, 
		RULE_func_definition = 4, RULE_parameters = 5, RULE_func_body = 6, RULE_statement = 7, 
		RULE_arguments = 8, RULE_block = 9, RULE_expression = 10, RULE_func_invocation = 11, 
		RULE_type = 12, RULE_built_in_type = 13;
	public static final String[] ruleNames = {
		"program", "definitions", "main", "var_definition", "func_definition", 
		"parameters", "func_body", "statement", "arguments", "block", "expression", 
		"func_invocation", "type", "built_in_type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'void'", "'main'", "'('", "')'", "','", "';'", "'{'", "'}'", "'='", 
		"'return'", "'if'", "'else'", "'while'", "'read'", "'write'", "'['", "']'", 
		"'.'", "'-'", "'*'", "'/'", "'%'", "'+'", "'!'", "'>'", "'>='", "'<'", 
		"'<='", "'!='", "'=='", "'&&'", "'||'", "'struct'", "'int'", "'char'", 
		"'double'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "ID", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "WS", "SINGLE_LINE_COMMENT", 
		"MULTIPLE_LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((ProgramContext)_localctx).definitions = definitions();
			((ProgramContext)_localctx).ast =  new Program(0, 0, ((ProgramContext)_localctx).definitions.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Var_definitionContext vd;
		public Func_definitionContext fd;
		public MainContext m;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<Func_definitionContext> func_definition() {
			return getRuleContexts(Func_definitionContext.class);
		}
		public Func_definitionContext func_definition(int i) {
			return getRuleContext(Func_definitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(37);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(31);
						((DefinitionsContext)_localctx).vd = var_definition();
						for(VarDefinition v : ((DefinitionsContext)_localctx).vd.ast) {_localctx.ast.add(v);}
						}
						break;
					case 2:
						{
						setState(34);
						((DefinitionsContext)_localctx).fd = func_definition();
						_localctx.ast.add(((DefinitionsContext)_localctx).fd.ast);
						}
						break;
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(42);
			((DefinitionsContext)_localctx).m = main();
			_localctx.ast.add(((DefinitionsContext)_localctx).m.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public FuncDefinition ast;
		public Token t;
		public Func_bodyContext fb;
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			((MainContext)_localctx).t = match(T__0);
			setState(46);
			match(T__1);
			setState(47);
			match(T__2);
			setState(48);
			match(T__3);
			setState(49);
			((MainContext)_localctx).fb = func_body();
			FunctionType type = new FunctionType( (((MainContext)_localctx).fb!=null?(((MainContext)_localctx).fb.start):null).getLine(),
																							(((MainContext)_localctx).fb!=null?(((MainContext)_localctx).fb.start):null).getCharPositionInLine()+1,
																							new VoidType(((MainContext)_localctx).t.getLine(), ((MainContext)_localctx).t.getCharPositionInLine()),
																							new ArrayList<VarDefinition>());
						
								((MainContext)_localctx).ast =  new FuncDefinition((((MainContext)_localctx).fb!=null?(((MainContext)_localctx).fb.start):null).getLine(), (((MainContext)_localctx).fb!=null?(((MainContext)_localctx).fb.start):null).getCharPositionInLine()+1, "main", type,  ((MainContext)_localctx).fb.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_definitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext t;
		public Token v0;
		public Token v1;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			((Var_definitionContext)_localctx).t = type(0);
			setState(53);
			((Var_definitionContext)_localctx).v0 = match(ID);
			 _localctx.ast.add(new VarDefinition(((Var_definitionContext)_localctx).v0.getLine(), ((Var_definitionContext)_localctx).v0.getCharPositionInLine(), (((Var_definitionContext)_localctx).v0!=null?((Var_definitionContext)_localctx).v0.getText():null), ((Var_definitionContext)_localctx).t.ast));
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(55);
				match(T__4);
				setState(56);
				((Var_definitionContext)_localctx).v1 = match(ID);
				_localctx.ast.add(new VarDefinition(((Var_definitionContext)_localctx).v1.getLine(), ((Var_definitionContext)_localctx).v1.getCharPositionInLine(), (((Var_definitionContext)_localctx).v1!=null?((Var_definitionContext)_localctx).v1.getText():null), ((Var_definitionContext)_localctx).t.ast));
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_definitionContext extends ParserRuleContext {
		public FuncDefinition ast;
		public TypeContext ty;
		public Token v;
		public Token name;
		public ParametersContext param;
		public Func_bodyContext body;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			Type t;
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
			case T__33:
			case T__34:
			case T__35:
				{
				setState(66);
				((Func_definitionContext)_localctx).ty = type(0);
				t=((Func_definitionContext)_localctx).ty.ast;
				}
				break;
			case T__0:
				{
				setState(69);
				((Func_definitionContext)_localctx).v = match(T__0);
				t=new VoidType(((Func_definitionContext)_localctx).v.getLine(), ((Func_definitionContext)_localctx).v.getCharPositionInLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(73);
			((Func_definitionContext)_localctx).name = match(ID);
			setState(74);
			match(T__2);
			setState(75);
			((Func_definitionContext)_localctx).param = parameters();
			setState(76);
			match(T__3);
			setState(77);
			((Func_definitionContext)_localctx).body = func_body();
			FunctionType ftype = new FunctionType( (((Func_definitionContext)_localctx).body!=null?(((Func_definitionContext)_localctx).body.start):null).getLine(), (((Func_definitionContext)_localctx).body!=null?(((Func_definitionContext)_localctx).body.start):null).getCharPositionInLine()+1, t, ((Func_definitionContext)_localctx).param.ast);
						((Func_definitionContext)_localctx).ast =  new FuncDefinition(((Func_definitionContext)_localctx).name.getLine(), ((Func_definitionContext)_localctx).name.getCharPositionInLine()+1, (((Func_definitionContext)_localctx).name!=null?((Func_definitionContext)_localctx).name.getText():null), ftype, ((Func_definitionContext)_localctx).body.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext t0;
		public Token n0;
		public TypeContext t1;
		public Token n1;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameters);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__32:
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				((ParametersContext)_localctx).t0 = type(0);
				setState(82);
				((ParametersContext)_localctx).n0 = match(ID);
				_localctx.ast.add(new VarDefinition(((ParametersContext)_localctx).n0.getLine(), ((ParametersContext)_localctx).n0.getCharPositionInLine()+1, (((ParametersContext)_localctx).n0!=null?((ParametersContext)_localctx).n0.getText():null), ((ParametersContext)_localctx).t0.ast));
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(84);
					match(T__4);
					setState(85);
					((ParametersContext)_localctx).t1 = type(0);
					setState(86);
					((ParametersContext)_localctx).n1 = match(ID);
					_localctx.ast.add(new VarDefinition(((ParametersContext)_localctx).n1.getLine(), ((ParametersContext)_localctx).n1.getCharPositionInLine()+1, (((ParametersContext)_localctx).n1!=null?((ParametersContext)_localctx).n1.getText():null), ((ParametersContext)_localctx).t1.ast));
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Var_definitionContext vd;
		public StatementContext s;
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_func_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__6);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
				{
				{
				setState(97);
				((Func_bodyContext)_localctx).vd = var_definition();
				for(VarDefinition v:((Func_bodyContext)_localctx).vd.ast) {_localctx.ast.add(v);}
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__18) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(105);
				((Func_bodyContext)_localctx).s = statement();
				_localctx.ast.addAll(((Func_bodyContext)_localctx).s.ast);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Func_invocationContext fi;
		public Token r;
		public ExpressionContext e;
		public Token i;
		public BlockContext b;
		public BlockContext b2;
		public Token w;
		public ExpressionContext e0;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Func_invocationContext func_invocation() {
			return getRuleContext(Func_invocationContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				((StatementContext)_localctx).e1 = expression(0);
				setState(116);
				match(T__8);
				setState(117);
				((StatementContext)_localctx).e2 = expression(0);
				setState(118);
				match(T__5);
				_localctx.ast.add(new AssignmentStatement((((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getLine(),(((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((StatementContext)_localctx).fi = func_invocation();
				setState(122);
				match(T__5);
				_localctx.ast.add(((StatementContext)_localctx).fi.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				((StatementContext)_localctx).r = match(T__9);
				setState(126);
				((StatementContext)_localctx).e = expression(0);
				setState(127);
				match(T__5);
				_localctx.ast.add(new ReturnStatement(((StatementContext)_localctx).r.getLine(), ((StatementContext)_localctx).r.getCharPositionInLine()+1, ((StatementContext)_localctx).e.ast));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				((StatementContext)_localctx).i = match(T__10);
				setState(131);
				match(T__2);
				setState(132);
				((StatementContext)_localctx).e = expression(0);
				setState(133);
				match(T__3);
				setState(134);
				((StatementContext)_localctx).b = block();
				_localctx.ast.add(new IfElseStatement(((StatementContext)_localctx).i.getLine(), ((StatementContext)_localctx).i.getCharPositionInLine()+1,
								((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b.ast));
				setState(140);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(136);
					match(T__11);
					setState(137);
					((StatementContext)_localctx).b2 = block();
					((IfElseStatement)_localctx.ast.get(0)).addElse(((StatementContext)_localctx).b2.ast);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
				((StatementContext)_localctx).w = match(T__12);
				setState(143);
				match(T__2);
				setState(144);
				((StatementContext)_localctx).e = expression(0);
				setState(145);
				match(T__3);
				setState(146);
				((StatementContext)_localctx).b = block();
				_localctx.ast.add(new WhileStatement(((StatementContext)_localctx).w.getLine(), ((StatementContext)_localctx).w.getCharPositionInLine()+1, ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b.ast));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				((StatementContext)_localctx).r = match(T__13);
				setState(150);
				((StatementContext)_localctx).e0 = expression(0);
				_localctx.ast.add(new ReadStatement(((StatementContext)_localctx).r.getLine(), ((StatementContext)_localctx).r.getCharPositionInLine()+1, ((StatementContext)_localctx).e0.ast));
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(152);
					match(T__4);
					setState(153);
					((StatementContext)_localctx).e1 = expression(0);
					_localctx.ast.add(new ReadStatement(((StatementContext)_localctx).r.getLine(), ((StatementContext)_localctx).r.getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast));
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(T__5);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(163);
				((StatementContext)_localctx).w = match(T__14);
				setState(164);
				((StatementContext)_localctx).e0 = expression(0);
				_localctx.ast.add(new WriteStatement(((StatementContext)_localctx).w.getLine(), ((StatementContext)_localctx).w.getCharPositionInLine()+1, ((StatementContext)_localctx).e0.ast));
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(166);
					match(T__4);
					setState(167);
					((StatementContext)_localctx).e1 = expression(0);
					_localctx.ast.add(new WriteStatement(((StatementContext)_localctx).w.getLine(), ((StatementContext)_localctx).w.getCharPositionInLine()+1, ((StatementContext)_localctx).e1.ast));
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e0;
		public ExpressionContext e1;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arguments);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__2:
			case T__18:
			case T__23:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				((ArgumentsContext)_localctx).e0 = expression(0);
				_localctx.ast.add(((ArgumentsContext)_localctx).e0.ast);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(182);
					match(T__4);
					setState(183);
					((ArgumentsContext)_localctx).e1 = expression(0);
					_localctx.ast.add(((ArgumentsContext)_localctx).e1.ast);
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext s0;
		public StatementContext s1;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case T__18:
			case T__23:
			case ID:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				((BlockContext)_localctx).s0 = statement();
				_localctx.ast.addAll(((BlockContext)_localctx).s0.ast);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(T__6);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__18) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(197);
					((BlockContext)_localctx).s1 = statement();
					_localctx.ast.addAll(((BlockContext)_localctx).s1.ast);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public TypeContext t;
		public ExpressionContext e;
		public Token i;
		public Token r;
		public Token c;
		public Token name;
		public Token m;
		public Token not;
		public Func_invocationContext fi;
		public Token op;
		public ExpressionContext e2;
		public Token field;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public Func_invocationContext func_invocation() {
			return getRuleContext(Func_invocationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(209);
				match(T__2);
				setState(210);
				((ExpressionContext)_localctx).t = type(0);
				setState(211);
				match(T__3);
				setState(212);
				((ExpressionContext)_localctx).e = expression(13);
				((ExpressionContext)_localctx).ast =  new CastExpression((((ExpressionContext)_localctx).t!=null?(((ExpressionContext)_localctx).t.start):null).getLine(), (((ExpressionContext)_localctx).t!=null?(((ExpressionContext)_localctx).t.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).t.ast, ((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 2:
				{
				setState(221);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_CONSTANT:
					{
					setState(215);
					((ExpressionContext)_localctx).i = match(INT_CONSTANT);
					((ExpressionContext)_localctx).ast =  new IntLiteralExpression(((ExpressionContext)_localctx).i.getLine(), ((ExpressionContext)_localctx).i.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).i!=null?((ExpressionContext)_localctx).i.getText():null)));
					}
					break;
				case REAL_CONSTANT:
					{
					setState(217);
					((ExpressionContext)_localctx).r = match(REAL_CONSTANT);
					((ExpressionContext)_localctx).ast =  new RealLiteralExpression(((ExpressionContext)_localctx).r.getLine(), ((ExpressionContext)_localctx).r.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).r!=null?((ExpressionContext)_localctx).r.getText():null)));
					}
					break;
				case CHAR_CONSTANT:
					{
					setState(219);
					((ExpressionContext)_localctx).c = match(CHAR_CONSTANT);
					((ExpressionContext)_localctx).ast =  new CharLiteralExpression(((ExpressionContext)_localctx).c.getLine(), ((ExpressionContext)_localctx).c.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).c!=null?((ExpressionContext)_localctx).c.getText():null)));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				setState(223);
				((ExpressionContext)_localctx).name = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).name.getLine(), ((ExpressionContext)_localctx).name.getCharPositionInLine()+1, (((ExpressionContext)_localctx).name!=null?((ExpressionContext)_localctx).name.getText():null));
				}
				break;
			case 4:
				{
				setState(225);
				match(T__2);
				setState(226);
				((ExpressionContext)_localctx).e = expression(0);
				setState(227);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e.ast;
				}
				break;
			case 5:
				{
				setState(230);
				((ExpressionContext)_localctx).m = match(T__18);
				setState(231);
				((ExpressionContext)_localctx).e = expression(7);
				((ExpressionContext)_localctx).ast =  new UnaryMinusExpression(((ExpressionContext)_localctx).m.getLine(), ((ExpressionContext)_localctx).m.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 6:
				{
				setState(234);
				((ExpressionContext)_localctx).not = match(T__23);
				setState(235);
				((ExpressionContext)_localctx).e = expression(4);
				((ExpressionContext)_localctx).ast =  new LogicalNotExpression(((ExpressionContext)_localctx).not.getLine(), ((ExpressionContext)_localctx).not.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 7:
				{
				setState(238);
				((ExpressionContext)_localctx).fi = func_invocation();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).fi.ast;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(273);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(244);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						((ExpressionContext)_localctx).e2 = expression(7);
						((ExpressionContext)_localctx).ast =  new ArithmeticExpression(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(248);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(249);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__22) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						((ExpressionContext)_localctx).e2 = expression(6);
						((ExpressionContext)_localctx).ast =  new ArithmeticExpression(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(254);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						((ExpressionContext)_localctx).e2 = expression(4);
						((ExpressionContext)_localctx).ast =  new ComparissonExpression(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(259);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(260);
						((ExpressionContext)_localctx).e2 = expression(3);
						((ExpressionContext)_localctx).ast =  new LogicalExpression(((ExpressionContext)_localctx).op.getLine(), ((ExpressionContext)_localctx).op.getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(263);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(264);
						match(T__15);
						setState(265);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(266);
						match(T__16);
						((ExpressionContext)_localctx).ast =  new IndexingOperator((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(), (((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(269);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(270);
						match(T__17);
						setState(271);
						((ExpressionContext)_localctx).field = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(), (((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).field!=null?((ExpressionContext)_localctx).field.getText():null));
						}
						break;
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Func_invocationContext extends ParserRuleContext {
		public FuncInvStatement ast;
		public Token name;
		public ArgumentsContext arg;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Func_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_invocation; }
	}

	public final Func_invocationContext func_invocation() throws RecognitionException {
		Func_invocationContext _localctx = new Func_invocationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			((Func_invocationContext)_localctx).name = match(ID);
			setState(279);
			match(T__2);
			setState(280);
			((Func_invocationContext)_localctx).arg = arguments();
			setState(281);
			match(T__3);
			((Func_invocationContext)_localctx).ast =  new FuncInvStatement(((Func_invocationContext)_localctx).name.getLine(), ((Func_invocationContext)_localctx).name.getCharPositionInLine()+1, 
									new Variable(((Func_invocationContext)_localctx).name.getLine(), ((Func_invocationContext)_localctx).name.getCharPositionInLine()+1, (((Func_invocationContext)_localctx).name!=null?((Func_invocationContext)_localctx).name.getText():null)), ((Func_invocationContext)_localctx).arg.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t;
		public Built_in_typeContext b;
		public Token s;
		public Var_definitionContext vd;
		public Token n;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				{
				setState(285);
				((TypeContext)_localctx).b = built_in_type();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).b.ast;
				}
				break;
			case T__32:
				{
				setState(288);
				((TypeContext)_localctx).s = match(T__32);
				((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).s.getLine(), ((TypeContext)_localctx).s.getCharPositionInLine()+1);
				setState(290);
				match(T__6);
				setState(294); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(291);
					((TypeContext)_localctx).vd = var_definition();
					((StructType)_localctx.ast).addDef(((TypeContext)_localctx).vd.ast);
					}
					}
					setState(296); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0) );
				setState(298);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(302);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(303);
					match(T__15);
					setState(304);
					((TypeContext)_localctx).n = match(INT_CONSTANT);
					setState(305);
					match(T__16);
					((TypeContext)_localctx).ast =  ArrayType.getArrayType(((TypeContext)_localctx).n.getLine(), ((TypeContext)_localctx).n.getCharPositionInLine()+1, ((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).n!=null?((TypeContext)_localctx).n.getText():null)));
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Built_in_typeContext extends ParserRuleContext {
		public Type ast;
		public Token i;
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_built_in_type);
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				((Built_in_typeContext)_localctx).i = match(T__33);
				((Built_in_typeContext)_localctx).ast =  new IntType(((Built_in_typeContext)_localctx).i.getLine(), ((Built_in_typeContext)_localctx).i.getCharPositionInLine()+1);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				((Built_in_typeContext)_localctx).i = match(T__34);
				((Built_in_typeContext)_localctx).ast =  new CharType(((Built_in_typeContext)_localctx).i.getLine(), ((Built_in_typeContext)_localctx).i.getCharPositionInLine()+1);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				((Built_in_typeContext)_localctx).i = match(T__35);
				((Built_in_typeContext)_localctx).ast =  new DoubleType(((Built_in_typeContext)_localctx).i.getLine(), ((Built_in_typeContext)_localctx).i.getCharPositionInLine()+1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 12:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0143\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6J\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\5\7a\n\7\3\b\3\b\3\b\3\b\7\bg"+
		"\n\b\f\b\16\bj\13\b\3\b\3\b\3\b\7\bo\n\b\f\b\16\br\13\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008f\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009f\n\t\f\t\16\t\u00a2\13\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ad\n\t\f\t\16\t\u00b0\13\t\3\t\3\t\5\t"+
		"\u00b4\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00bd\n\n\f\n\16\n\u00c0\13"+
		"\n\5\n\u00c2\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00cb\n\13\f"+
		"\13\16\13\u00ce\13\13\3\13\5\13\u00d1\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e0\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f4\n\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0114\n\f\f\f\16\f\u0117\13\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\6\16\u0129\n\16\r\16\16\16\u012a\3\16\3\16\5\16\u012f\n\16\3\16\3"+
		"\16\3\16\3\16\3\16\7\16\u0136\n\16\f\16\16\16\u0139\13\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\5\17\u0141\n\17\3\17\2\4\26\32\20\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\2\6\3\2\26\30\4\2\25\25\31\31\3\2\33 \3\2!\"\2\u015c"+
		"\2\36\3\2\2\2\4)\3\2\2\2\6/\3\2\2\2\b\66\3\2\2\2\nC\3\2\2\2\f`\3\2\2\2"+
		"\16b\3\2\2\2\20\u00b3\3\2\2\2\22\u00c1\3\2\2\2\24\u00d0\3\2\2\2\26\u00f3"+
		"\3\2\2\2\30\u0118\3\2\2\2\32\u012e\3\2\2\2\34\u0140\3\2\2\2\36\37\5\4"+
		"\3\2\37 \b\2\1\2 \3\3\2\2\2!\"\5\b\5\2\"#\b\3\1\2#(\3\2\2\2$%\5\n\6\2"+
		"%&\b\3\1\2&(\3\2\2\2\'!\3\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2"+
		"\2\2*,\3\2\2\2+)\3\2\2\2,-\5\6\4\2-.\b\3\1\2.\5\3\2\2\2/\60\7\3\2\2\60"+
		"\61\7\4\2\2\61\62\7\5\2\2\62\63\7\6\2\2\63\64\5\16\b\2\64\65\b\4\1\2\65"+
		"\7\3\2\2\2\66\67\5\32\16\2\678\7\'\2\28>\b\5\1\29:\7\7\2\2:;\7\'\2\2;"+
		"=\b\5\1\2<9\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2"+
		"AB\7\b\2\2B\t\3\2\2\2CI\b\6\1\2DE\5\32\16\2EF\b\6\1\2FJ\3\2\2\2GH\7\3"+
		"\2\2HJ\b\6\1\2ID\3\2\2\2IG\3\2\2\2JK\3\2\2\2KL\7\'\2\2LM\7\5\2\2MN\5\f"+
		"\7\2NO\7\6\2\2OP\5\16\b\2PQ\b\6\1\2Q\13\3\2\2\2Ra\3\2\2\2ST\5\32\16\2"+
		"TU\7\'\2\2U]\b\7\1\2VW\7\7\2\2WX\5\32\16\2XY\7\'\2\2YZ\b\7\1\2Z\\\3\2"+
		"\2\2[V\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^a\3\2\2\2_]\3\2\2\2`R\3"+
		"\2\2\2`S\3\2\2\2a\r\3\2\2\2bh\7\t\2\2cd\5\b\5\2de\b\b\1\2eg\3\2\2\2fc"+
		"\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ip\3\2\2\2jh\3\2\2\2kl\5\20\t\2"+
		"lm\b\b\1\2mo\3\2\2\2nk\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2"+
		"rp\3\2\2\2st\7\n\2\2t\17\3\2\2\2uv\5\26\f\2vw\7\13\2\2wx\5\26\f\2xy\7"+
		"\b\2\2yz\b\t\1\2z\u00b4\3\2\2\2{|\5\30\r\2|}\7\b\2\2}~\b\t\1\2~\u00b4"+
		"\3\2\2\2\177\u0080\7\f\2\2\u0080\u0081\5\26\f\2\u0081\u0082\7\b\2\2\u0082"+
		"\u0083\b\t\1\2\u0083\u00b4\3\2\2\2\u0084\u0085\7\r\2\2\u0085\u0086\7\5"+
		"\2\2\u0086\u0087\5\26\f\2\u0087\u0088\7\6\2\2\u0088\u0089\5\24\13\2\u0089"+
		"\u008e\b\t\1\2\u008a\u008b\7\16\2\2\u008b\u008c\5\24\13\2\u008c\u008d"+
		"\b\t\1\2\u008d\u008f\3\2\2\2\u008e\u008a\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u00b4\3\2\2\2\u0090\u0091\7\17\2\2\u0091\u0092\7\5\2\2\u0092\u0093\5"+
		"\26\f\2\u0093\u0094\7\6\2\2\u0094\u0095\5\24\13\2\u0095\u0096\b\t\1\2"+
		"\u0096\u00b4\3\2\2\2\u0097\u0098\7\20\2\2\u0098\u0099\5\26\f\2\u0099\u00a0"+
		"\b\t\1\2\u009a\u009b\7\7\2\2\u009b\u009c\5\26\f\2\u009c\u009d\b\t\1\2"+
		"\u009d\u009f\3\2\2\2\u009e\u009a\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\u00a4\7\b\2\2\u00a4\u00b4\3\2\2\2\u00a5\u00a6\7\21\2\2\u00a6\u00a7\5"+
		"\26\f\2\u00a7\u00ae\b\t\1\2\u00a8\u00a9\7\7\2\2\u00a9\u00aa\5\26\f\2\u00aa"+
		"\u00ab\b\t\1\2\u00ab\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\7\b\2\2\u00b2\u00b4\3\2\2\2\u00b3u\3\2\2\2"+
		"\u00b3{\3\2\2\2\u00b3\177\3\2\2\2\u00b3\u0084\3\2\2\2\u00b3\u0090\3\2"+
		"\2\2\u00b3\u0097\3\2\2\2\u00b3\u00a5\3\2\2\2\u00b4\21\3\2\2\2\u00b5\u00c2"+
		"\3\2\2\2\u00b6\u00b7\5\26\f\2\u00b7\u00be\b\n\1\2\u00b8\u00b9\7\7\2\2"+
		"\u00b9\u00ba\5\26\f\2\u00ba\u00bb\b\n\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00b8"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c1\u00b6\3\2"+
		"\2\2\u00c2\23\3\2\2\2\u00c3\u00c4\5\20\t\2\u00c4\u00c5\b\13\1\2\u00c5"+
		"\u00d1\3\2\2\2\u00c6\u00cc\7\t\2\2\u00c7\u00c8\5\20\t\2\u00c8\u00c9\b"+
		"\13\1\2\u00c9\u00cb\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00d1\7\n\2\2\u00d0\u00c3\3\2\2\2\u00d0\u00c6\3\2\2\2\u00d1"+
		"\25\3\2\2\2\u00d2\u00d3\b\f\1\2\u00d3\u00d4\7\5\2\2\u00d4\u00d5\5\32\16"+
		"\2\u00d5\u00d6\7\6\2\2\u00d6\u00d7\5\26\f\17\u00d7\u00d8\b\f\1\2\u00d8"+
		"\u00f4\3\2\2\2\u00d9\u00da\7(\2\2\u00da\u00e0\b\f\1\2\u00db\u00dc\7)\2"+
		"\2\u00dc\u00e0\b\f\1\2\u00dd\u00de\7*\2\2\u00de\u00e0\b\f\1\2\u00df\u00d9"+
		"\3\2\2\2\u00df\u00db\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00f4\3\2\2\2\u00e1"+
		"\u00e2\7\'\2\2\u00e2\u00f4\b\f\1\2\u00e3\u00e4\7\5\2\2\u00e4\u00e5\5\26"+
		"\f\2\u00e5\u00e6\7\6\2\2\u00e6\u00e7\b\f\1\2\u00e7\u00f4\3\2\2\2\u00e8"+
		"\u00e9\7\25\2\2\u00e9\u00ea\5\26\f\t\u00ea\u00eb\b\f\1\2\u00eb\u00f4\3"+
		"\2\2\2\u00ec\u00ed\7\32\2\2\u00ed\u00ee\5\26\f\6\u00ee\u00ef\b\f\1\2\u00ef"+
		"\u00f4\3\2\2\2\u00f0\u00f1\5\30\r\2\u00f1\u00f2\b\f\1\2\u00f2\u00f4\3"+
		"\2\2\2\u00f3\u00d2\3\2\2\2\u00f3\u00df\3\2\2\2\u00f3\u00e1\3\2\2\2\u00f3"+
		"\u00e3\3\2\2\2\u00f3\u00e8\3\2\2\2\u00f3\u00ec\3\2\2\2\u00f3\u00f0\3\2"+
		"\2\2\u00f4\u0115\3\2\2\2\u00f5\u00f6\f\b\2\2\u00f6\u00f7\t\2\2\2\u00f7"+
		"\u00f8\5\26\f\t\u00f8\u00f9\b\f\1\2\u00f9\u0114\3\2\2\2\u00fa\u00fb\f"+
		"\7\2\2\u00fb\u00fc\t\3\2\2\u00fc\u00fd\5\26\f\b\u00fd\u00fe\b\f\1\2\u00fe"+
		"\u0114\3\2\2\2\u00ff\u0100\f\5\2\2\u0100\u0101\t\4\2\2\u0101\u0102\5\26"+
		"\f\6\u0102\u0103\b\f\1\2\u0103\u0114\3\2\2\2\u0104\u0105\f\4\2\2\u0105"+
		"\u0106\t\5\2\2\u0106\u0107\5\26\f\5\u0107\u0108\b\f\1\2\u0108\u0114\3"+
		"\2\2\2\u0109\u010a\f\13\2\2\u010a\u010b\7\22\2\2\u010b\u010c\5\26\f\2"+
		"\u010c\u010d\7\23\2\2\u010d\u010e\b\f\1\2\u010e\u0114\3\2\2\2\u010f\u0110"+
		"\f\n\2\2\u0110\u0111\7\24\2\2\u0111\u0112\7\'\2\2\u0112\u0114\b\f\1\2"+
		"\u0113\u00f5\3\2\2\2\u0113\u00fa\3\2\2\2\u0113\u00ff\3\2\2\2\u0113\u0104"+
		"\3\2\2\2\u0113\u0109\3\2\2\2\u0113\u010f\3\2\2\2\u0114\u0117\3\2\2\2\u0115"+
		"\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\27\3\2\2\2\u0117\u0115\3\2\2"+
		"\2\u0118\u0119\7\'\2\2\u0119\u011a\7\5\2\2\u011a\u011b\5\22\n\2\u011b"+
		"\u011c\7\6\2\2\u011c\u011d\b\r\1\2\u011d\31\3\2\2\2\u011e\u011f\b\16\1"+
		"\2\u011f\u0120\5\34\17\2\u0120\u0121\b\16\1\2\u0121\u012f\3\2\2\2\u0122"+
		"\u0123\7#\2\2\u0123\u0124\b\16\1\2\u0124\u0128\7\t\2\2\u0125\u0126\5\b"+
		"\5\2\u0126\u0127\b\16\1\2\u0127\u0129\3\2\2\2\u0128\u0125\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012d\7\n\2\2\u012d\u012f\3\2\2\2\u012e\u011e\3\2\2\2\u012e"+
		"\u0122\3\2\2\2\u012f\u0137\3\2\2\2\u0130\u0131\f\4\2\2\u0131\u0132\7\22"+
		"\2\2\u0132\u0133\7(\2\2\u0133\u0134\7\23\2\2\u0134\u0136\b\16\1\2\u0135"+
		"\u0130\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2"+
		"\2\2\u0138\33\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7$\2\2\u013b\u0141"+
		"\b\17\1\2\u013c\u013d\7%\2\2\u013d\u0141\b\17\1\2\u013e\u013f\7&\2\2\u013f"+
		"\u0141\b\17\1\2\u0140\u013a\3\2\2\2\u0140\u013c\3\2\2\2\u0140\u013e\3"+
		"\2\2\2\u0141\35\3\2\2\2\32\')>I]`hp\u008e\u00a0\u00ae\u00b3\u00be\u00c1"+
		"\u00cc\u00d0\u00df\u00f3\u0113\u0115\u012a\u012e\u0137\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}