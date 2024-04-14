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
		T__9=10, T__10=11, T__11=12, T__12=13, DEC_INT=14, HEX_INT=15, BIN_INT=16, 
		STRING_=17, BOOL_OPERATOR=18, ADD_SUB_OPERATOR=19, MUL_DIV_OPERATOR=20, 
		BOOLEAN=21, VARIABLE_NAME=22, RETURN_OPERATOR=23, PIPE_OPERATOR=24, ASSIGN_OPERATOR=25, 
		END_STATEMENT=26, ID=27, NEWLINE=28, Space=29;
	public static final int
		RULE_program = 0, RULE_bundleDefinition = 1, RULE_import_ = 2, RULE_pipeDefinition = 3, 
		RULE_scope = 4, RULE_argumentsDefinitionList = 5, RULE_expr = 6, RULE_pipeline = 7, 
		RULE_pipelineTuple = 8, RULE_guardedPipe = 9, RULE_tuple = 10, RULE_guard = 11, 
		RULE_untypedArgumentList = 12, RULE_elseGuard = 13, RULE_var = 14, RULE_assign = 15, 
		RULE_return = 16, RULE_value = 17, RULE_typedName = 18, RULE_int = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "bundleDefinition", "import_", "pipeDefinition", "scope", 
			"argumentsDefinitionList", "expr", "pipeline", "pipelineTuple", "guardedPipe", 
			"tuple", "guard", "untypedArgumentList", "elseGuard", "var", "assign", 
			"return", "value", "typedName", "int"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bundle'", "'{'", "','", "'}'", "'.'", "'pi'", "':'", "'('", "')'", 
			"'#'", "'['", "']'", "'else'", null, null, null, null, null, null, null, 
			null, "'let'", "'>>'", "'|>'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "DEC_INT", "HEX_INT", "BIN_INT", "STRING_", "BOOL_OPERATOR", 
			"ADD_SUB_OPERATOR", "MUL_DIV_OPERATOR", "BOOLEAN", "VARIABLE_NAME", "RETURN_OPERATOR", 
			"PIPE_OPERATOR", "ASSIGN_OPERATOR", "END_STATEMENT", "ID", "NEWLINE", 
			"Space"
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RETURN_OPERATOR) {
				{
				{
				setState(40);
				import_();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(48);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(46);
					bundleDefinition();
					}
					break;
				case T__5:
					{
					setState(47);
					pipeDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(50); 
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
			setState(52);
			match(T__0);
			setState(53);
			match(ID);
			setState(54);
			match(T__1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(55);
					match(VARIABLE_NAME);
					setState(56);
					typedName();
					setState(57);
					match(T__2);
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABLE_NAME) {
				{
				setState(64);
				match(VARIABLE_NAME);
				setState(65);
				typedName();
				}
			}

			setState(68);
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
			setState(70);
			match(RETURN_OPERATOR);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(71);
					match(ID);
					setState(72);
					match(T__4);
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(78);
			match(ID);
			setState(79);
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
		public Token type;
		public ArgumentsDefinitionListContext argumentsDefinitionList() {
			return getRuleContext(ArgumentsDefinitionListContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PipedParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PipedParser.ID, i);
		}
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
			setState(81);
			match(T__5);
			setState(82);
			((PipeDefinitionContext)_localctx).name = match(ID);
			setState(83);
			argumentsDefinitionList();
			setState(84);
			match(T__6);
			setState(85);
			((PipeDefinitionContext)_localctx).type = match(ID);
			setState(86);
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
		public List<TerminalNode> END_STATEMENT() { return getTokens(PipedParser.END_STATEMENT); }
		public TerminalNode END_STATEMENT(int i) {
			return getToken(PipedParser.END_STATEMENT, i);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ReturnContext> return_() {
			return getRuleContexts(ReturnContext.class);
		}
		public ReturnContext return_(int i) {
			return getRuleContext(ReturnContext.class,i);
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
			setState(88);
			match(T__1);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 149143812L) != 0)) {
				{
				{
				setState(92);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARIABLE_NAME:
					{
					setState(89);
					assign();
					}
					break;
				case T__1:
				case T__7:
				case DEC_INT:
				case HEX_INT:
				case BIN_INT:
				case STRING_:
				case BOOLEAN:
				case ID:
					{
					setState(90);
					expr(0);
					}
					break;
				case RETURN_OPERATOR:
					{
					setState(91);
					return_();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94);
				match(END_STATEMENT);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
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
		enterRule(_localctx, 10, RULE_argumentsDefinitionList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__7);
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					typedName();
					setState(105);
					match(T__2);
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(112);
				typedName();
				}
			}

			setState(115);
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
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
		}
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD_SUB_OPERATOR() { return getToken(PipedParser.ADD_SUB_OPERATOR, 0); }
		public TerminalNode MUL_DIV_OPERATOR() { return getToken(PipedParser.MUL_DIV_OPERATOR, 0); }
		public TerminalNode BOOL_OPERATOR() { return getToken(PipedParser.BOOL_OPERATOR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(118);
				pipeline();
				}
				break;
			case 2:
				{
				setState(119);
				tuple();
				}
				break;
			case 3:
				{
				setState(120);
				scope();
				}
				break;
			case 4:
				{
				setState(121);
				value();
				}
				break;
			case 5:
				{
				setState(122);
				var();
				}
				break;
			case 6:
				{
				setState(123);
				match(T__7);
				setState(124);
				expr(0);
				setState(125);
				match(T__8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(130);
						((ExprContext)_localctx).op = match(ADD_SUB_OPERATOR);
						setState(131);
						((ExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(132);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(133);
						((ExprContext)_localctx).op = match(MUL_DIV_OPERATOR);
						setState(134);
						((ExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(136);
						((ExprContext)_localctx).op = match(BOOL_OPERATOR);
						setState(137);
						((ExprContext)_localctx).right = expr(8);
						}
						break;
					}
					} 
				}
				setState(142);
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
		public List<PipelineTupleContext> pipelineTuple() {
			return getRuleContexts(PipelineTupleContext.class);
		}
		public PipelineTupleContext pipelineTuple(int i) {
			return getRuleContext(PipelineTupleContext.class,i);
		}
		public List<TerminalNode> PIPE_OPERATOR() { return getTokens(PipedParser.PIPE_OPERATOR); }
		public TerminalNode PIPE_OPERATOR(int i) {
			return getToken(PipedParser.PIPE_OPERATOR, i);
		}
		public List<TerminalNode> ID() { return getTokens(PipedParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PipedParser.ID, i);
		}
		public List<GuardedPipeContext> guardedPipe() {
			return getRuleContexts(GuardedPipeContext.class);
		}
		public GuardedPipeContext guardedPipe(int i) {
			return getRuleContext(GuardedPipeContext.class,i);
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
		enterRule(_localctx, 14, RULE_pipeline);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__7:
						{
						setState(143);
						pipelineTuple();
						}
						break;
					case ID:
						{
						setState(144);
						match(ID);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__10) {
						{
						setState(147);
						guardedPipe();
						}
					}

					setState(150);
					match(PIPE_OPERATOR);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(156);
				pipelineTuple();
				}
				break;
			case ID:
				{
				{
				setState(157);
				match(ID);
				setState(159);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(158);
					guardedPipe();
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class PipelineTupleContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> DEC_INT() { return getTokens(PipedParser.DEC_INT); }
		public TerminalNode DEC_INT(int i) {
			return getToken(PipedParser.DEC_INT, i);
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
		enterRule(_localctx, 16, RULE_pipelineTuple);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__7);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__1:
					case T__7:
					case DEC_INT:
					case HEX_INT:
					case BIN_INT:
					case STRING_:
					case BOOLEAN:
					case ID:
						{
						setState(164);
						expr(0);
						}
						break;
					case T__9:
						{
						setState(165);
						match(T__9);
						setState(166);
						match(DEC_INT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(169);
					match(T__2);
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__7:
			case DEC_INT:
			case HEX_INT:
			case BIN_INT:
			case STRING_:
			case BOOLEAN:
			case ID:
				{
				setState(175);
				expr(0);
				}
				break;
			case T__9:
				{
				setState(176);
				match(T__9);
				setState(177);
				match(DEC_INT);
				}
				break;
			case T__8:
				break;
			default:
				break;
			}
			setState(180);
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
	public static class GuardedPipeContext extends ParserRuleContext {
		public UntypedArgumentListContext untypedArgumentList() {
			return getRuleContext(UntypedArgumentListContext.class,0);
		}
		public TerminalNode PIPE_OPERATOR() { return getToken(PipedParser.PIPE_OPERATOR, 0); }
		public ElseGuardContext elseGuard() {
			return getRuleContext(ElseGuardContext.class,0);
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
		enterRule(_localctx, 18, RULE_guardedPipe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__10);
			setState(183);
			untypedArgumentList();
			setState(184);
			match(PIPE_OPERATOR);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(185);
				guard();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			elseGuard();
			setState(192);
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
		enterRule(_localctx, 20, RULE_tuple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__7);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(195);
					expr(0);
					setState(196);
					match(T__2);
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 136560900L) != 0)) {
				{
				setState(203);
				expr(0);
				}
			}

			setState(206);
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
		enterRule(_localctx, 22, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__7);
			setState(209);
			((GuardContext)_localctx).condition = expr(0);
			setState(210);
			match(T__8);
			setState(211);
			((GuardContext)_localctx).body = expr(0);
			setState(212);
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
		enterRule(_localctx, 24, RULE_untypedArgumentList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__7);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(215);
					match(ID);
					setState(216);
					match(T__2);
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(222);
			match(ID);
			setState(223);
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
		enterRule(_localctx, 26, RULE_elseGuard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__12);
			setState(226);
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
		enterRule(_localctx, 28, RULE_var);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(ID);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(229);
					match(T__4);
					setState(230);
					match(ID);
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
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
		enterRule(_localctx, 30, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(VARIABLE_NAME);
			setState(237);
			match(ID);
			setState(238);
			match(ASSIGN_OPERATOR);
			setState(239);
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
		enterRule(_localctx, 32, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(RETURN_OPERATOR);
			setState(242);
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
		enterRule(_localctx, 34, RULE_value);
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEC_INT:
			case HEX_INT:
			case BIN_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				int_();
				}
				break;
			case STRING_:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(STRING_);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
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
		public Token type;
		public List<TerminalNode> ID() { return getTokens(PipedParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PipedParser.ID, i);
		}
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
		enterRule(_localctx, 36, RULE_typedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			((TypedNameContext)_localctx).name = match(ID);
			setState(250);
			match(T__6);
			setState(251);
			((TypedNameContext)_localctx).type = match(ID);
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
		enterRule(_localctx, 38, RULE_int);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u0100\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000"+
		"\f\u0000-\t\u0000\u0001\u0000\u0001\u0000\u0004\u00001\b\u0000\u000b\u0000"+
		"\f\u00002\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001<\b\u0001\n\u0001\f\u0001?\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001C\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002J\b\u0002\n\u0002\f\u0002"+
		"M\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004]\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004a\b\u0004\n\u0004\f\u0004d\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"l\b\u0005\n\u0005\f\u0005o\t\u0005\u0001\u0005\u0003\u0005r\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u0080\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u008b"+
		"\b\u0006\n\u0006\f\u0006\u008e\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u0092\b\u0007\u0001\u0007\u0003\u0007\u0095\b\u0007\u0001\u0007\u0005"+
		"\u0007\u0098\b\u0007\n\u0007\f\u0007\u009b\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00a0\b\u0007\u0003\u0007\u00a2\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a8\b\b\u0001\b\u0005\b\u00ab\b\b"+
		"\n\b\f\b\u00ae\t\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b3\b\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00bb\b\t\n\t\f\t\u00be\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00c7"+
		"\b\n\n\n\f\n\u00ca\t\n\u0001\n\u0003\n\u00cd\b\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00da\b\f\n\f\f\f\u00dd\t\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00e8\b\u000e\n\u000e\f\u000e\u00eb\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00f8\b\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0000\u0001\f\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0001\u0001\u0000\u000e\u0010"+
		"\u010e\u0000+\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0004"+
		"F\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\bX\u0001\u0000"+
		"\u0000\u0000\ng\u0001\u0000\u0000\u0000\f\u007f\u0001\u0000\u0000\u0000"+
		"\u000e\u0099\u0001\u0000\u0000\u0000\u0010\u00a3\u0001\u0000\u0000\u0000"+
		"\u0012\u00b6\u0001\u0000\u0000\u0000\u0014\u00c2\u0001\u0000\u0000\u0000"+
		"\u0016\u00d0\u0001\u0000\u0000\u0000\u0018\u00d6\u0001\u0000\u0000\u0000"+
		"\u001a\u00e1\u0001\u0000\u0000\u0000\u001c\u00e4\u0001\u0000\u0000\u0000"+
		"\u001e\u00ec\u0001\u0000\u0000\u0000 \u00f1\u0001\u0000\u0000\u0000\""+
		"\u00f7\u0001\u0000\u0000\u0000$\u00f9\u0001\u0000\u0000\u0000&\u00fd\u0001"+
		"\u0000\u0000\u0000(*\u0003\u0004\u0002\u0000)(\u0001\u0000\u0000\u0000"+
		"*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,0\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.1\u0003\u0002"+
		"\u0001\u0000/1\u0003\u0006\u0003\u00000.\u0001\u0000\u0000\u00000/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u00003\u0001\u0001\u0000\u0000\u000045\u0005\u0001"+
		"\u0000\u000056\u0005\u001b\u0000\u00006=\u0005\u0002\u0000\u000078\u0005"+
		"\u0016\u0000\u000089\u0003$\u0012\u00009:\u0005\u0003\u0000\u0000:<\u0001"+
		"\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>B\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000@A\u0005\u0016\u0000\u0000AC\u0003$\u0012"+
		"\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DE\u0005\u0004\u0000\u0000E\u0003\u0001\u0000\u0000\u0000"+
		"FK\u0005\u0017\u0000\u0000GH\u0005\u001b\u0000\u0000HJ\u0005\u0005\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000NO\u0005\u001b\u0000\u0000OP\u0005\u001a\u0000\u0000"+
		"P\u0005\u0001\u0000\u0000\u0000QR\u0005\u0006\u0000\u0000RS\u0005\u001b"+
		"\u0000\u0000ST\u0003\n\u0005\u0000TU\u0005\u0007\u0000\u0000UV\u0005\u001b"+
		"\u0000\u0000VW\u0003\b\u0004\u0000W\u0007\u0001\u0000\u0000\u0000Xb\u0005"+
		"\u0002\u0000\u0000Y]\u0003\u001e\u000f\u0000Z]\u0003\f\u0006\u0000[]\u0003"+
		" \u0010\u0000\\Y\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\"+
		"[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0005\u001a\u0000"+
		"\u0000_a\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000ad\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0005\u0004\u0000\u0000"+
		"f\t\u0001\u0000\u0000\u0000gm\u0005\b\u0000\u0000hi\u0003$\u0012\u0000"+
		"ij\u0005\u0003\u0000\u0000jl\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000"+
		"\u0000lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pr\u0003"+
		"$\u0012\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000st\u0005\t\u0000\u0000t\u000b\u0001\u0000\u0000\u0000"+
		"uv\u0006\u0006\uffff\uffff\u0000v\u0080\u0003\u000e\u0007\u0000w\u0080"+
		"\u0003\u0014\n\u0000x\u0080\u0003\b\u0004\u0000y\u0080\u0003\"\u0011\u0000"+
		"z\u0080\u0003\u001c\u000e\u0000{|\u0005\b\u0000\u0000|}\u0003\f\u0006"+
		"\u0000}~\u0005\t\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007fu\u0001"+
		"\u0000\u0000\u0000\u007fw\u0001\u0000\u0000\u0000\u007fx\u0001\u0000\u0000"+
		"\u0000\u007fy\u0001\u0000\u0000\u0000\u007fz\u0001\u0000\u0000\u0000\u007f"+
		"{\u0001\u0000\u0000\u0000\u0080\u008c\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\n\t\u0000\u0000\u0082\u0083\u0005\u0013\u0000\u0000\u0083\u008b\u0003"+
		"\f\u0006\n\u0084\u0085\n\b\u0000\u0000\u0085\u0086\u0005\u0014\u0000\u0000"+
		"\u0086\u008b\u0003\f\u0006\t\u0087\u0088\n\u0007\u0000\u0000\u0088\u0089"+
		"\u0005\u0012\u0000\u0000\u0089\u008b\u0003\f\u0006\b\u008a\u0081\u0001"+
		"\u0000\u0000\u0000\u008a\u0084\u0001\u0000\u0000\u0000\u008a\u0087\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\r\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0092\u0003\u0010"+
		"\b\u0000\u0090\u0092\u0005\u001b\u0000\u0000\u0091\u008f\u0001\u0000\u0000"+
		"\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000"+
		"\u0000\u0093\u0095\u0003\u0012\t\u0000\u0094\u0093\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0098\u0005\u0018\u0000\u0000\u0097\u0091\u0001\u0000\u0000\u0000"+
		"\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u00a1\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u00a2\u0003\u0010\b\u0000\u009d"+
		"\u009f\u0005\u001b\u0000\u0000\u009e\u00a0\u0003\u0012\t\u0000\u009f\u009e"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a1\u009c\u0001\u0000\u0000\u0000\u00a1\u009d"+
		"\u0001\u0000\u0000\u0000\u00a2\u000f\u0001\u0000\u0000\u0000\u00a3\u00ac"+
		"\u0005\b\u0000\u0000\u00a4\u00a8\u0003\f\u0006\u0000\u00a5\u00a6\u0005"+
		"\n\u0000\u0000\u00a6\u00a8\u0005\u000e\u0000\u0000\u00a7\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00ab\u0005\u0003\u0000\u0000\u00aa\u00a7\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00b2\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b3\u0003\f\u0006"+
		"\u0000\u00b0\u00b1\u0005\n\u0000\u0000\u00b1\u00b3\u0005\u000e\u0000\u0000"+
		"\u00b2\u00af\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0005\t\u0000\u0000\u00b5\u0011\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0005\u000b\u0000\u0000\u00b7\u00b8\u0003\u0018\f\u0000\u00b8\u00bc"+
		"\u0005\u0018\u0000\u0000\u00b9\u00bb\u0003\u0016\u000b\u0000\u00ba\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf"+
		"\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0003\u001a\r\u0000\u00c0\u00c1\u0005\f\u0000\u0000\u00c1\u0013\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c8\u0005\b\u0000\u0000\u00c3\u00c4\u0003\f"+
		"\u0006\u0000\u00c4\u00c5\u0005\u0003\u0000\u0000\u00c5\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c3\u0001\u0000\u0000\u0000\u00c7\u00ca\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000"+
		"\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cd\u0003\f\u0006\u0000\u00cc\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005\t\u0000\u0000\u00cf\u0015\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0005\b\u0000\u0000\u00d1\u00d2\u0003\f\u0006\u0000\u00d2"+
		"\u00d3\u0005\t\u0000\u0000\u00d3\u00d4\u0003\f\u0006\u0000\u00d4\u00d5"+
		"\u0005\u0003\u0000\u0000\u00d5\u0017\u0001\u0000\u0000\u0000\u00d6\u00db"+
		"\u0005\b\u0000\u0000\u00d7\u00d8\u0005\u001b\u0000\u0000\u00d8\u00da\u0005"+
		"\u0003\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00dd\u0001"+
		"\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001"+
		"\u0000\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0005\u001b\u0000\u0000\u00df\u00e0\u0005"+
		"\t\u0000\u0000\u00e0\u0019\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\r"+
		"\u0000\u0000\u00e2\u00e3\u0003\f\u0006\u0000\u00e3\u001b\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e9\u0005\u001b\u0000\u0000\u00e5\u00e6\u0005\u0005\u0000"+
		"\u0000\u00e6\u00e8\u0005\u001b\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u001d\u0001\u0000\u0000"+
		"\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0016\u0000"+
		"\u0000\u00ed\u00ee\u0005\u001b\u0000\u0000\u00ee\u00ef\u0005\u0019\u0000"+
		"\u0000\u00ef\u00f0\u0003\f\u0006\u0000\u00f0\u001f\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f2\u0005\u0017\u0000\u0000\u00f2\u00f3\u0003\f\u0006\u0000\u00f3"+
		"!\u0001\u0000\u0000\u0000\u00f4\u00f8\u0003&\u0013\u0000\u00f5\u00f8\u0005"+
		"\u0011\u0000\u0000\u00f6\u00f8\u0005\u0015\u0000\u0000\u00f7\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8#\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\u001b"+
		"\u0000\u0000\u00fa\u00fb\u0005\u0007\u0000\u0000\u00fb\u00fc\u0005\u001b"+
		"\u0000\u0000\u00fc%\u0001\u0000\u0000\u0000\u00fd\u00fe\u0007\u0000\u0000"+
		"\u0000\u00fe\'\u0001\u0000\u0000\u0000\u001b+02=BK\\bmq\u007f\u008a\u008c"+
		"\u0091\u0094\u0099\u009f\u00a1\u00a7\u00ac\u00b2\u00bc\u00c8\u00cc\u00db"+
		"\u00e9\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}