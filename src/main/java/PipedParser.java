// Generated from /home/christopher/IdeaProjects/piped2/src/main/resources/Piped.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PipedParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, DEC_INT=15, HEX_INT=16, 
		BIN_INT=17, STRING_=18, BOOL_OPERATOR=19, ADD_SUB_OPERATOR=20, MUL_DIV_OPERATOR=21, 
		BOOLEAN=22, VARIABLE_NAME=23, RETURN_OPERATOR=24, PIPE_OPERATOR=25, ASSIGN_OPERATOR=26, 
		END_STATEMENT=27, ID=28, NEWLINE=29, Space=30, COMMENT=31;
	public static final int
		RULE_program = 0, RULE_bundleDefinition = 1, RULE_import_ = 2, RULE_pipeDefinition = 3, 
		RULE_scope = 4, RULE_statement = 5, RULE_argumentsDefinitionList = 6, 
		RULE_expr = 7, RULE_pipeline = 8, RULE_pipelineElement = 9, RULE_pipelineTuple = 10, 
		RULE_placeholder = 11, RULE_guardedPipe = 12, RULE_tuple = 13, RULE_guard = 14, 
		RULE_untypedArgumentList = 15, RULE_elseGuard = 16, RULE_bundleInit = 17, 
		RULE_var = 18, RULE_assign = 19, RULE_return = 20, RULE_value = 21, RULE_typedName = 22, 
		RULE_type = 23, RULE_tupleType = 24, RULE_int = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "bundleDefinition", "import_", "pipeDefinition", "scope", 
			"statement", "argumentsDefinitionList", "expr", "pipeline", "pipelineElement", 
			"pipelineTuple", "placeholder", "guardedPipe", "tuple", "guard", "untypedArgumentList", 
			"elseGuard", "bundleInit", "var", "assign", "return", "value", "typedName", 
			"type", "tupleType", "int"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bundle'", "'{'", "','", "'}'", "'.'", "'pi'", "':'", "'('", "')'", 
			"'#'", "'['", "']'", "'->'", "'else'", null, null, null, null, null, 
			null, null, null, "'let'", "'>>'", "'|>'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "DEC_INT", "HEX_INT", "BIN_INT", "STRING_", "BOOL_OPERATOR", 
			"ADD_SUB_OPERATOR", "MUL_DIV_OPERATOR", "BOOLEAN", "VARIABLE_NAME", "RETURN_OPERATOR", 
			"PIPE_OPERATOR", "ASSIGN_OPERATOR", "END_STATEMENT", "ID", "NEWLINE", 
			"Space", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Piped.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  @Override
	  public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException ex)
	  {
	    throw new RuntimeException(msg);
	  }

	public PipedParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<Import_Context> import_() {
			return getRuleContexts(Import_Context.class);
		}
		public Import_Context import_(int i) {
			return getRuleContext(Import_Context.class,i);
		}
		public List<BundleDefinitionContext> bundleDefinition() {
			return getRuleContexts(BundleDefinitionContext.class);
		}
		public BundleDefinitionContext bundleDefinition(int i) {
			return getRuleContext(BundleDefinitionContext.class,i);
		}
		public List<PipeDefinitionContext> pipeDefinition() {
			return getRuleContexts(PipeDefinitionContext.class);
		}
		public PipeDefinitionContext pipeDefinition(int i) {
			return getRuleContext(PipeDefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RETURN_OPERATOR) {
				{
				{
				setState(52);
				import_();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(60);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(58);
					bundleDefinition();
					}
					break;
				case T__5:
					{
					setState(59);
					pipeDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==T__5 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class BundleDefinitionContext extends ParserRuleContext {
		public Token name;
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(PipedParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(PipedParser.VARIABLE_NAME, i);
		}
		public List<TypedNameContext> typedName() {
			return getRuleContexts(TypedNameContext.class);
		}
		public TypedNameContext typedName(int i) {
			return getRuleContext(TypedNameContext.class,i);
		}
		public BundleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bundleDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterBundleDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitBundleDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitBundleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BundleDefinitionContext bundleDefinition() throws RecognitionException {
		BundleDefinitionContext _localctx = new BundleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bundleDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__0);
			setState(65);
			((BundleDefinitionContext)_localctx).name = match(ID);
			setState(66);
			match(T__1);
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					match(VARIABLE_NAME);
					setState(68);
					typedName();
					setState(69);
					match(T__2);
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABLE_NAME) {
				{
				setState(76);
				match(VARIABLE_NAME);
				setState(77);
				typedName();
				}
			}

			setState(80);
			match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Import_Context extends ParserRuleContext {
		public TerminalNode RETURN_OPERATOR() { return getToken(PipedParser.RETURN_OPERATOR, 0); }
		public List<TerminalNode> ID() { return getTokens(PipedParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PipedParser.ID, i);
		}
		public TerminalNode END_STATEMENT() { return getToken(PipedParser.END_STATEMENT, 0); }
		public Import_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterImport_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitImport_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitImport_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_Context import_() throws RecognitionException {
		Import_Context _localctx = new Import_Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_import_);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(RETURN_OPERATOR);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					match(ID);
					setState(84);
					match(T__4);
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(90);
			match(ID);
			setState(91);
			match(END_STATEMENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PipeDefinitionContext extends ParserRuleContext {
		public Token name;
		public ArgumentsDefinitionListContext argumentsDefinitionList() {
			return getRuleContext(ArgumentsDefinitionListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public PipeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPipeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPipeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPipeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeDefinitionContext pipeDefinition() throws RecognitionException {
		PipeDefinitionContext _localctx = new PipeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pipeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__5);
			setState(94);
			((PipeDefinitionContext)_localctx).name = match(ID);
			setState(95);
			argumentsDefinitionList();
			setState(96);
			match(T__6);
			setState(97);
			type();
			setState(98);
			scope();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScopeContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> END_STATEMENT() { return getTokens(PipedParser.END_STATEMENT); }
		public TerminalNode END_STATEMENT(int i) {
			return getToken(PipedParser.END_STATEMENT, i);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__1);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 298289412L) != 0)) {
				{
				{
				setState(101);
				statement();
				setState(102);
				match(END_STATEMENT);
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				assign();
				}
				break;
			case T__1:
			case T__7:
			case T__10:
			case DEC_INT:
			case HEX_INT:
			case BIN_INT:
			case STRING_:
			case BOOLEAN:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				expr(0);
				}
				break;
			case RETURN_OPERATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				return_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsDefinitionListContext extends ParserRuleContext {
		public List<TypedNameContext> typedName() {
			return getRuleContexts(TypedNameContext.class);
		}
		public TypedNameContext typedName(int i) {
			return getRuleContext(TypedNameContext.class,i);
		}
		public ArgumentsDefinitionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentsDefinitionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterArgumentsDefinitionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitArgumentsDefinitionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitArgumentsDefinitionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsDefinitionListContext argumentsDefinitionList() throws RecognitionException {
		ArgumentsDefinitionListContext _localctx = new ArgumentsDefinitionListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argumentsDefinitionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__7);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					typedName();
					setState(118);
					match(T__2);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(125);
				typedName();
				}
			}

			setState(128);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolOpContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BOOL_OPERATOR() { return getToken(PipedParser.BOOL_OPERATOR, 0); }
		public BoolOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitBoolOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitBoolOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Pass1Context extends ExprContext {
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
		}
		public Pass1Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPass1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPass1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPass1(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Pass2Context extends ExprContext {
		public BundleInitContext bundleInit() {
			return getRuleContext(BundleInitContext.class,0);
		}
		public Pass2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPass2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPass2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPass2(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Pass3Context extends ExprContext {
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public Pass3Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPass3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPass3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPass3(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivOpContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL_DIV_OPERATOR() { return getToken(PipedParser.MUL_DIV_OPERATOR, 0); }
		public MulDivOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterMulDivOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitMulDivOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitMulDivOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Pass4Context extends ExprContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public Pass4Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPass4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPass4(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPass4(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Pass5Context extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Pass5Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPass5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPass5(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPass5(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Pass6Context extends ExprContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public Pass6Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPass6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPass6(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPass6(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubOpContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD_SUB_OPERATOR() { return getToken(PipedParser.ADD_SUB_OPERATOR, 0); }
		public AddSubOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterAddSubOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitAddSubOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitAddSubOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new Pass6Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(131);
				scope();
				}
				break;
			case 2:
				{
				_localctx = new Pass5Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				value();
				}
				break;
			case 3:
				{
				_localctx = new Pass4Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				var();
				}
				break;
			case 4:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(T__7);
				setState(135);
				expr(0);
				setState(136);
				match(T__8);
				}
				break;
			case 5:
				{
				_localctx = new Pass3Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				tuple();
				}
				break;
			case 6:
				{
				_localctx = new Pass2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				bundleInit();
				}
				break;
			case 7:
				{
				_localctx = new Pass1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				pipeline();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(152);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new BoolOpContext(new ExprContext(_parentctx, _parentState));
						((BoolOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(144);
						((BoolOpContext)_localctx).op = match(BOOL_OPERATOR);
						setState(145);
						((BoolOpContext)_localctx).right = expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MulDivOpContext(new ExprContext(_parentctx, _parentState));
						((MulDivOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(147);
						((MulDivOpContext)_localctx).op = match(MUL_DIV_OPERATOR);
						setState(148);
						((MulDivOpContext)_localctx).right = expr(10);
						}
						break;
					case 3:
						{
						_localctx = new AddSubOpContext(new ExprContext(_parentctx, _parentState));
						((AddSubOpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(150);
						((AddSubOpContext)_localctx).op = match(ADD_SUB_OPERATOR);
						setState(151);
						((AddSubOpContext)_localctx).right = expr(9);
						}
						break;
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PipelineContext extends ParserRuleContext {
		public List<PipelineElementContext> pipelineElement() {
			return getRuleContexts(PipelineElementContext.class);
		}
		public PipelineElementContext pipelineElement(int i) {
			return getRuleContext(PipelineElementContext.class,i);
		}
		public List<TerminalNode> PIPE_OPERATOR() { return getTokens(PipedParser.PIPE_OPERATOR); }
		public TerminalNode PIPE_OPERATOR(int i) {
			return getToken(PipedParser.PIPE_OPERATOR, i);
		}
		public PipelineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPipeline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPipeline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPipeline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineContext pipeline() throws RecognitionException {
		PipelineContext _localctx = new PipelineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pipeline);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(157);
					pipelineElement();
					setState(158);
					match(PIPE_OPERATOR);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(162); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			{
			setState(164);
			pipelineElement();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class PipelineElementContext extends ParserRuleContext {
		public PipelineTupleContext pipelineTuple() {
			return getRuleContext(PipelineTupleContext.class,0);
		}
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public GuardedPipeContext guardedPipe() {
			return getRuleContext(GuardedPipeContext.class,0);
		}
		public PipelineElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipelineElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPipelineElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPipelineElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPipelineElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineElementContext pipelineElement() throws RecognitionException {
		PipelineElementContext _localctx = new PipelineElementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pipelineElement);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				pipelineTuple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(ID);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				guardedPipe();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PipelineTupleContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<PlaceholderContext> placeholder() {
			return getRuleContexts(PlaceholderContext.class);
		}
		public PlaceholderContext placeholder(int i) {
			return getRuleContext(PlaceholderContext.class,i);
		}
		public PipelineTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipelineTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPipelineTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPipelineTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPipelineTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineTupleContext pipelineTuple() throws RecognitionException {
		PipelineTupleContext _localctx = new PipelineTupleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pipelineTuple);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__7);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(174);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__1:
					case T__7:
					case T__10:
					case DEC_INT:
					case HEX_INT:
					case BIN_INT:
					case STRING_:
					case BOOLEAN:
					case ID:
						{
						setState(172);
						expr(0);
						}
						break;
					case T__9:
						{
						setState(173);
						placeholder();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(176);
					match(T__2);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__7:
			case T__10:
			case DEC_INT:
			case HEX_INT:
			case BIN_INT:
			case STRING_:
			case BOOLEAN:
			case ID:
				{
				setState(183);
				expr(0);
				}
				break;
			case T__9:
				{
				setState(184);
				placeholder();
				}
				break;
			case T__8:
				break;
			default:
				break;
			}
			setState(187);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PlaceholderContext extends ParserRuleContext {
		public TerminalNode DEC_INT() { return getToken(PipedParser.DEC_INT, 0); }
		public PlaceholderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_placeholder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPlaceholder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPlaceholder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPlaceholder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlaceholderContext placeholder() throws RecognitionException {
		PlaceholderContext _localctx = new PlaceholderContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_placeholder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__9);
			setState(190);
			match(DEC_INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GuardedPipeContext extends ParserRuleContext {
		public UntypedArgumentListContext args;
		public TerminalNode PIPE_OPERATOR() { return getToken(PipedParser.PIPE_OPERATOR, 0); }
		public ElseGuardContext elseGuard() {
			return getRuleContext(ElseGuardContext.class,0);
		}
		public UntypedArgumentListContext untypedArgumentList() {
			return getRuleContext(UntypedArgumentListContext.class,0);
		}
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
		}
		public GuardedPipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardedPipe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterGuardedPipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitGuardedPipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitGuardedPipe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardedPipeContext guardedPipe() throws RecognitionException {
		GuardedPipeContext _localctx = new GuardedPipeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_guardedPipe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__10);
			setState(193);
			((GuardedPipeContext)_localctx).args = untypedArgumentList();
			setState(194);
			match(PIPE_OPERATOR);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(195);
				guard();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			elseGuard();
			setState(202);
			match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tuple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__7);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(205);
					expr(0);
					setState(206);
					match(T__2);
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 273123588L) != 0)) {
				{
				setState(213);
				expr(0);
				}
			}

			setState(216);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GuardContext extends ParserRuleContext {
		public ExprContext condition;
		public ExprContext body;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitGuard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__7);
			setState(219);
			((GuardContext)_localctx).condition = expr(0);
			setState(220);
			match(T__8);
			setState(221);
			match(T__12);
			setState(222);
			((GuardContext)_localctx).body = expr(0);
			setState(223);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UntypedArgumentListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PipedParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PipedParser.ID, i);
		}
		public UntypedArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_untypedArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterUntypedArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitUntypedArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitUntypedArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UntypedArgumentListContext untypedArgumentList() throws RecognitionException {
		UntypedArgumentListContext _localctx = new UntypedArgumentListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_untypedArgumentList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__7);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(226);
					match(ID);
					setState(227);
					match(T__2);
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(233);
			match(ID);
			setState(234);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseGuardContext extends ParserRuleContext {
		public ExprContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ElseGuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseGuard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterElseGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitElseGuard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitElseGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseGuardContext elseGuard() throws RecognitionException {
		ElseGuardContext _localctx = new ElseGuardContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseGuard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__13);
			setState(237);
			match(T__12);
			setState(238);
			((ElseGuardContext)_localctx).body = expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BundleInitContext extends ParserRuleContext {
		public Token name;
		public Token args;
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BundleInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bundleInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterBundleInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitBundleInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitBundleInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BundleInitContext bundleInit() throws RecognitionException {
		BundleInitContext _localctx = new BundleInitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bundleInit);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			((BundleInitContext)_localctx).name = match(ID);
			setState(241);
			((BundleInitContext)_localctx).args = match(T__7);
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(242);
					expr(0);
					setState(243);
					match(T__2);
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 273123588L) != 0)) {
				{
				setState(250);
				expr(0);
				}
			}

			setState(253);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PipedParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PipedParser.ID, i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_var);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(ID);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(256);
					match(T__4);
					setState(257);
					match(ID);
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode VARIABLE_NAME() { return getToken(PipedParser.VARIABLE_NAME, 0); }
		public TypedNameContext typedName() {
			return getRuleContext(TypedNameContext.class,0);
		}
		public TerminalNode ASSIGN_OPERATOR() { return getToken(PipedParser.ASSIGN_OPERATOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(VARIABLE_NAME);
			setState(264);
			typedName();
			setState(265);
			match(ASSIGN_OPERATOR);
			setState(266);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN_OPERATOR() { return getToken(PipedParser.RETURN_OPERATOR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(RETURN_OPERATOR);
			setState(269);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public IntContext int_() {
			return getRuleContext(IntContext.class,0);
		}
		public TerminalNode STRING_() { return getToken(PipedParser.STRING_, 0); }
		public TerminalNode BOOLEAN() { return getToken(PipedParser.BOOLEAN, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_value);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEC_INT:
			case HEX_INT:
			case BIN_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				int_();
				}
				break;
			case STRING_:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(STRING_);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				match(BOOLEAN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypedNameContext extends ParserRuleContext {
		public Token name;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public TypedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterTypedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitTypedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitTypedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedNameContext typedName() throws RecognitionException {
		TypedNameContext _localctx = new TypedNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			((TypedNameContext)_localctx).name = match(ID);
			setState(277);
			match(T__6);
			setState(278);
			type();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public TupleTypeContext tupleType() {
			return getRuleContext(TupleTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_type);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(ID);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				tupleType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TupleTypeContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TupleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterTupleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitTupleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitTupleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleTypeContext tupleType() throws RecognitionException {
		TupleTypeContext _localctx = new TupleTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tupleType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__7);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(285);
					type();
					setState(286);
					match(T__2);
					}
					} 
				}
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==ID) {
				{
				setState(293);
				type();
				}
			}

			setState(296);
			match(T__8);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ParserRuleContext {
		public TerminalNode DEC_INT() { return getToken(PipedParser.DEC_INT, 0); }
		public TerminalNode HEX_INT() { return getToken(PipedParser.HEX_INT, 0); }
		public TerminalNode BIN_INT() { return getToken(PipedParser.BIN_INT, 0); }
		public IntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntContext int_() throws RecognitionException {
		IntContext _localctx = new IntContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_int);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u012d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0005\u00006\b\u0000\n\u0000"+
		"\f\u00009\t\u0000\u0001\u0000\u0001\u0000\u0004\u0000=\b\u0000\u000b\u0000"+
		"\f\u0000>\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001H\b\u0001\n\u0001\f\u0001K\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001O\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002V\b\u0002\n\u0002\f\u0002"+
		"Y\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004i\b\u0004\n\u0004\f\u0004"+
		"l\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005s\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006y\b\u0006\n\u0006\f\u0006|\t\u0006\u0001\u0006\u0003\u0006"+
		"\u007f\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u008e\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u0099\b\u0007\n\u0007\f\u0007\u009c\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0004\b\u00a1\b\b\u000b\b\f\b\u00a2\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u00aa\b\t\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00af\b\n\u0001\n\u0001\n\u0005\n\u00b3\b\n\n\n\f\n\u00b6\t\n\u0001"+
		"\n\u0001\n\u0003\n\u00ba\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00c5\b\f\n\f\f\f\u00c8"+
		"\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00d1"+
		"\b\r\n\r\f\r\u00d4\t\r\u0001\r\u0003\r\u00d7\b\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00e5\b\u000f\n"+
		"\u000f\f\u000f\u00e8\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00f6\b\u0011\n\u0011\f\u0011"+
		"\u00f9\t\u0011\u0001\u0011\u0003\u0011\u00fc\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0103\b\u0012\n"+
		"\u0012\f\u0012\u0106\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0113\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u011b\b\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0121\b\u0018\n"+
		"\u0018\f\u0018\u0124\t\u0018\u0001\u0018\u0003\u0018\u0127\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0001\u000e"+
		"\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02\u0000\u0001\u0001\u0000\u000f\u0011\u0139"+
		"\u00007\u0001\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004R"+
		"\u0001\u0000\u0000\u0000\u0006]\u0001\u0000\u0000\u0000\bd\u0001\u0000"+
		"\u0000\u0000\nr\u0001\u0000\u0000\u0000\ft\u0001\u0000\u0000\u0000\u000e"+
		"\u008d\u0001\u0000\u0000\u0000\u0010\u00a0\u0001\u0000\u0000\u0000\u0012"+
		"\u00a9\u0001\u0000\u0000\u0000\u0014\u00ab\u0001\u0000\u0000\u0000\u0016"+
		"\u00bd\u0001\u0000\u0000\u0000\u0018\u00c0\u0001\u0000\u0000\u0000\u001a"+
		"\u00cc\u0001\u0000\u0000\u0000\u001c\u00da\u0001\u0000\u0000\u0000\u001e"+
		"\u00e1\u0001\u0000\u0000\u0000 \u00ec\u0001\u0000\u0000\u0000\"\u00f0"+
		"\u0001\u0000\u0000\u0000$\u00ff\u0001\u0000\u0000\u0000&\u0107\u0001\u0000"+
		"\u0000\u0000(\u010c\u0001\u0000\u0000\u0000*\u0112\u0001\u0000\u0000\u0000"+
		",\u0114\u0001\u0000\u0000\u0000.\u011a\u0001\u0000\u0000\u00000\u011c"+
		"\u0001\u0000\u0000\u00002\u012a\u0001\u0000\u0000\u000046\u0003\u0004"+
		"\u0002\u000054\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008<\u0001\u0000\u0000\u0000"+
		"97\u0001\u0000\u0000\u0000:=\u0003\u0002\u0001\u0000;=\u0003\u0006\u0003"+
		"\u0000<:\u0001\u0000\u0000\u0000<;\u0001\u0000\u0000\u0000=>\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?\u0001"+
		"\u0001\u0000\u0000\u0000@A\u0005\u0001\u0000\u0000AB\u0005\u001c\u0000"+
		"\u0000BI\u0005\u0002\u0000\u0000CD\u0005\u0017\u0000\u0000DE\u0003,\u0016"+
		"\u0000EF\u0005\u0003\u0000\u0000FH\u0001\u0000\u0000\u0000GC\u0001\u0000"+
		"\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JN\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"LM\u0005\u0017\u0000\u0000MO\u0003,\u0016\u0000NL\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0005\u0004\u0000"+
		"\u0000Q\u0003\u0001\u0000\u0000\u0000RW\u0005\u0018\u0000\u0000ST\u0005"+
		"\u001c\u0000\u0000TV\u0005\u0005\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005\u001c"+
		"\u0000\u0000[\\\u0005\u001b\u0000\u0000\\\u0005\u0001\u0000\u0000\u0000"+
		"]^\u0005\u0006\u0000\u0000^_\u0005\u001c\u0000\u0000_`\u0003\f\u0006\u0000"+
		"`a\u0005\u0007\u0000\u0000ab\u0003.\u0017\u0000bc\u0003\b\u0004\u0000"+
		"c\u0007\u0001\u0000\u0000\u0000dj\u0005\u0002\u0000\u0000ef\u0003\n\u0005"+
		"\u0000fg\u0005\u001b\u0000\u0000gi\u0001\u0000\u0000\u0000he\u0001\u0000"+
		"\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000"+
		"mn\u0005\u0004\u0000\u0000n\t\u0001\u0000\u0000\u0000os\u0003&\u0013\u0000"+
		"ps\u0003\u000e\u0007\u0000qs\u0003(\u0014\u0000ro\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000s\u000b\u0001\u0000"+
		"\u0000\u0000tz\u0005\b\u0000\u0000uv\u0003,\u0016\u0000vw\u0005\u0003"+
		"\u0000\u0000wy\u0001\u0000\u0000\u0000xu\u0001\u0000\u0000\u0000y|\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f\u0003,\u0016"+
		"\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\t\u0000\u0000\u0081\r"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0006\u0007\uffff\uffff\u0000\u0083"+
		"\u008e\u0003\b\u0004\u0000\u0084\u008e\u0003*\u0015\u0000\u0085\u008e"+
		"\u0003$\u0012\u0000\u0086\u0087\u0005\b\u0000\u0000\u0087\u0088\u0003"+
		"\u000e\u0007\u0000\u0088\u0089\u0005\t\u0000\u0000\u0089\u008e\u0001\u0000"+
		"\u0000\u0000\u008a\u008e\u0003\u001a\r\u0000\u008b\u008e\u0003\"\u0011"+
		"\u0000\u008c\u008e\u0003\u0010\b\u0000\u008d\u0082\u0001\u0000\u0000\u0000"+
		"\u008d\u0084\u0001\u0000\u0000\u0000\u008d\u0085\u0001\u0000\u0000\u0000"+
		"\u008d\u0086\u0001\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u009a\u0001\u0000\u0000\u0000\u008f\u0090\n\n\u0000\u0000\u0090"+
		"\u0091\u0005\u0013\u0000\u0000\u0091\u0099\u0003\u000e\u0007\u000b\u0092"+
		"\u0093\n\t\u0000\u0000\u0093\u0094\u0005\u0015\u0000\u0000\u0094\u0099"+
		"\u0003\u000e\u0007\n\u0095\u0096\n\b\u0000\u0000\u0096\u0097\u0005\u0014"+
		"\u0000\u0000\u0097\u0099\u0003\u000e\u0007\t\u0098\u008f\u0001\u0000\u0000"+
		"\u0000\u0098\u0092\u0001\u0000\u0000\u0000\u0098\u0095\u0001\u0000\u0000"+
		"\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u000f\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0003\u0012\t\u0000"+
		"\u009e\u009f\u0005\u0019\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a0\u009d\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003\u0012\t\u0000\u00a5"+
		"\u0011\u0001\u0000\u0000\u0000\u00a6\u00aa\u0003\u0014\n\u0000\u00a7\u00aa"+
		"\u0005\u001c\u0000\u0000\u00a8\u00aa\u0003\u0018\f\u0000\u00a9\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u0013\u0001\u0000\u0000\u0000\u00ab\u00b4\u0005"+
		"\b\u0000\u0000\u00ac\u00af\u0003\u000e\u0007\u0000\u00ad\u00af\u0003\u0016"+
		"\u000b\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00ad\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0003"+
		"\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00ba\u0003\u000e"+
		"\u0007\u0000\u00b8\u00ba\u0003\u0016\u000b\u0000\u00b9\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\t\u0000"+
		"\u0000\u00bc\u0015\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\n\u0000\u0000"+
		"\u00be\u00bf\u0005\u000f\u0000\u0000\u00bf\u0017\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0005\u000b\u0000\u0000\u00c1\u00c2\u0003\u001e\u000f\u0000"+
		"\u00c2\u00c6\u0005\u0019\u0000\u0000\u00c3\u00c5\u0003\u001c\u000e\u0000"+
		"\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0003 \u0010\u0000\u00ca\u00cb\u0005\f\u0000\u0000\u00cb"+
		"\u0019\u0001\u0000\u0000\u0000\u00cc\u00d2\u0005\b\u0000\u0000\u00cd\u00ce"+
		"\u0003\u000e\u0007\u0000\u00ce\u00cf\u0005\u0003\u0000\u0000\u00cf\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000\u00d1\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d7\u0003\u000e\u0007\u0000\u00d6\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\t\u0000\u0000\u00d9\u001b\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0005\b\u0000\u0000\u00db\u00dc\u0003\u000e"+
		"\u0007\u0000\u00dc\u00dd\u0005\t\u0000\u0000\u00dd\u00de\u0005\r\u0000"+
		"\u0000\u00de\u00df\u0003\u000e\u0007\u0000\u00df\u00e0\u0005\u0003\u0000"+
		"\u0000\u00e0\u001d\u0001\u0000\u0000\u0000\u00e1\u00e6\u0005\b\u0000\u0000"+
		"\u00e2\u00e3\u0005\u001c\u0000\u0000\u00e3\u00e5\u0005\u0003\u0000\u0000"+
		"\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0005\u001c\u0000\u0000\u00ea\u00eb\u0005\t\u0000\u0000\u00eb"+
		"\u001f\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u000e\u0000\u0000\u00ed"+
		"\u00ee\u0005\r\u0000\u0000\u00ee\u00ef\u0003\u000e\u0007\u0000\u00ef!"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u001c\u0000\u0000\u00f1\u00f7"+
		"\u0005\b\u0000\u0000\u00f2\u00f3\u0003\u000e\u0007\u0000\u00f3\u00f4\u0005"+
		"\u0003\u0000\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001"+
		"\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fc\u0003"+
		"\u000e\u0007\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005"+
		"\t\u0000\u0000\u00fe#\u0001\u0000\u0000\u0000\u00ff\u0104\u0005\u001c"+
		"\u0000\u0000\u0100\u0101\u0005\u0005\u0000\u0000\u0101\u0103\u0005\u001c"+
		"\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000"+
		"\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000"+
		"\u0000\u0000\u0105%\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0005\u0017\u0000\u0000\u0108\u0109\u0003,\u0016\u0000"+
		"\u0109\u010a\u0005\u001a\u0000\u0000\u010a\u010b\u0003\u000e\u0007\u0000"+
		"\u010b\'\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u0018\u0000\u0000\u010d"+
		"\u010e\u0003\u000e\u0007\u0000\u010e)\u0001\u0000\u0000\u0000\u010f\u0113"+
		"\u00032\u0019\u0000\u0110\u0113\u0005\u0012\u0000\u0000\u0111\u0113\u0005"+
		"\u0016\u0000\u0000\u0112\u010f\u0001\u0000\u0000\u0000\u0112\u0110\u0001"+
		"\u0000\u0000\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113+\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0005\u001c\u0000\u0000\u0115\u0116\u0005\u0007"+
		"\u0000\u0000\u0116\u0117\u0003.\u0017\u0000\u0117-\u0001\u0000\u0000\u0000"+
		"\u0118\u011b\u0005\u001c\u0000\u0000\u0119\u011b\u00030\u0018\u0000\u011a"+
		"\u0118\u0001\u0000\u0000\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011b"+
		"/\u0001\u0000\u0000\u0000\u011c\u0122\u0005\b\u0000\u0000\u011d\u011e"+
		"\u0003.\u0017\u0000\u011e\u011f\u0005\u0003\u0000\u0000\u011f\u0121\u0001"+
		"\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121\u0124\u0001"+
		"\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001"+
		"\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000\u0000\u0124\u0122\u0001"+
		"\u0000\u0000\u0000\u0125\u0127\u0003.\u0017\u0000\u0126\u0125\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0005\t\u0000\u0000\u01291\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0007\u0000\u0000\u0000\u012b3\u0001\u0000\u0000\u0000"+
		"\u001d7<>INWjrz~\u008d\u0098\u009a\u00a2\u00a9\u00ae\u00b4\u00b9\u00c6"+
		"\u00d2\u00d6\u00e6\u00f7\u00fb\u0104\u0112\u011a\u0122\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}