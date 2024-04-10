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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, ValueDefinition=17, 
		INT=18, DEC_INT=19, HEX_INT=20, BIN_INT=21, STRING_=22, BOOL_OPERATOR=23, 
		BOOLEAN=24, RETURN_OPERATOR=25, PIPE_OPERATOR=26, ASSIGN_OPERATOR=27, 
		END_STATEMENT=28, ID=29, NEWLINE=30, Space=31;
	public static final int
		RULE_programm = 0, RULE_imports = 1, RULE_import_ = 2, RULE_globalScope = 3, 
		RULE_localScope = 4, RULE_pipeDefinition = 5, RULE_argumentsDefinition = 6, 
		RULE_bundleDefinition = 7, RULE_typedName = 8, RULE_return = 9, RULE_assign = 10, 
		RULE_reassign = 11, RULE_expression = 12, RULE_var = 13, RULE_typeName = 14, 
		RULE_pipeline = 15, RULE_guardedPipe = 16, RULE_nextPipe = 17, RULE_untypedArgumentList = 18, 
		RULE_guard = 19, RULE_tuple = 20, RULE_tupleType = 21, RULE_value = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"programm", "imports", "import_", "globalScope", "localScope", "pipeDefinition", 
			"argumentsDefinition", "bundleDefinition", "typedName", "return", "assign", 
			"reassign", "expression", "var", "typeName", "pipeline", "guardedPipe", 
			"nextPipe", "untypedArgumentList", "guard", "tuple", "tupleType", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'{'", "'}'", "'pi'", "'('", "')'", "':'", "','", "'Bundle'", 
			"'*'", "'/'", "'+'", "'-'", "'['", "'else'", "']'", null, null, null, 
			null, null, null, null, null, "'>>'", "'|>'", "'<|'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "ValueDefinition", "INT", "DEC_INT", "HEX_INT", 
			"BIN_INT", "STRING_", "BOOL_OPERATOR", "BOOLEAN", "RETURN_OPERATOR", 
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
	public static class ProgrammContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public GlobalScopeContext globalScope() {
			return getRuleContext(GlobalScopeContext.class,0);
		}
		public ProgrammContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterProgramm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitProgramm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitProgramm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgrammContext programm() throws RecognitionException {
		ProgrammContext _localctx = new ProgrammContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			imports();
			setState(47);
			globalScope();
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
	public static class ImportsContext extends ParserRuleContext {
		public List<Import_Context> import_() {
			return getRuleContexts(Import_Context.class);
		}
		public Import_Context import_(int i) {
			return getRuleContext(Import_Context.class,i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RETURN_OPERATOR) {
				{
				{
				setState(49);
				import_();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			setState(55);
			match(RETURN_OPERATOR);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56);
					match(ID);
					setState(57);
					match(T__0);
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(63);
			match(ID);
			setState(64);
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
	public static class GlobalScopeContext extends ParserRuleContext {
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
		public GlobalScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterGlobalScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitGlobalScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitGlobalScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalScopeContext globalScope() throws RecognitionException {
		GlobalScopeContext _localctx = new GlobalScopeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_globalScope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__8) {
				{
				setState(68);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(66);
					bundleDefinition();
					}
					break;
				case T__3:
					{
					setState(67);
					pipeDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class LocalScopeContext extends ParserRuleContext {
		public List<TerminalNode> END_STATEMENT() { return getTokens(PipedParser.END_STATEMENT); }
		public TerminalNode END_STATEMENT(int i) {
			return getToken(PipedParser.END_STATEMENT, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<ReturnContext> return_() {
			return getRuleContexts(ReturnContext.class);
		}
		public ReturnContext return_(int i) {
			return getRuleContext(ReturnContext.class,i);
		}
		public LocalScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterLocalScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitLocalScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitLocalScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalScopeContext localScope() throws RecognitionException {
		LocalScopeContext _localctx = new LocalScopeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_localScope);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(77);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(74);
						expression(0);
						}
						break;
					case 2:
						{
						setState(75);
						assign();
						}
						break;
					case 3:
						{
						setState(76);
						return_();
						}
						break;
					}
					setState(79);
					match(END_STATEMENT);
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(86);
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
	public static class PipeDefinitionContext extends ParserRuleContext {
		public Token name;
		public ArgumentsDefinitionContext args;
		public TypeNameContext returnType;
		public LocalScopeContext block;
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public ArgumentsDefinitionContext argumentsDefinition() {
			return getRuleContext(ArgumentsDefinitionContext.class,0);
		}
		public LocalScopeContext localScope() {
			return getRuleContext(LocalScopeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
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
		enterRule(_localctx, 10, RULE_pipeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__3);
			setState(89);
			((PipeDefinitionContext)_localctx).name = match(ID);
			setState(90);
			match(T__4);
			setState(91);
			((PipeDefinitionContext)_localctx).args = argumentsDefinition();
			setState(92);
			match(T__5);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(93);
				match(T__6);
				setState(94);
				((PipeDefinitionContext)_localctx).returnType = typeName();
				}
			}

			setState(97);
			((PipeDefinitionContext)_localctx).block = localScope();
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
	public static class ArgumentsDefinitionContext extends ParserRuleContext {
		public List<TypedNameContext> typedName() {
			return getRuleContexts(TypedNameContext.class);
		}
		public TypedNameContext typedName(int i) {
			return getRuleContext(TypedNameContext.class,i);
		}
		public ArgumentsDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentsDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterArgumentsDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitArgumentsDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitArgumentsDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsDefinitionContext argumentsDefinition() throws RecognitionException {
		ArgumentsDefinitionContext _localctx = new ArgumentsDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argumentsDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(99);
						typedName();
						setState(100);
						match(T__7);
						}
						} 
					}
					setState(106);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(107);
				typedName();
				}
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
	public static class BundleDefinitionContext extends ParserRuleContext {
		public Token name;
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public List<TerminalNode> ValueDefinition() { return getTokens(PipedParser.ValueDefinition); }
		public TerminalNode ValueDefinition(int i) {
			return getToken(PipedParser.ValueDefinition, i);
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
		enterRule(_localctx, 14, RULE_bundleDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__8);
			setState(111);
			((BundleDefinitionContext)_localctx).name = match(ID);
			setState(112);
			match(T__1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113);
					match(ValueDefinition);
					setState(114);
					typedName();
					setState(115);
					match(T__7);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ValueDefinition) {
				{
				setState(122);
				match(ValueDefinition);
				setState(123);
				typedName();
				}
			}

			setState(126);
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
	public static class TypedNameContext extends ParserRuleContext {
		public Token name;
		public TypeNameContext type;
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
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
		enterRule(_localctx, 16, RULE_typedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((TypedNameContext)_localctx).name = match(ID);
			setState(129);
			match(T__6);
			setState(130);
			((TypedNameContext)_localctx).type = typeName();
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 18, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(RETURN_OPERATOR);
			setState(133);
			expression(0);
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
		public ExpressionContext right;
		public TerminalNode ValueDefinition() { return getToken(PipedParser.ValueDefinition, 0); }
		public TypedNameContext typedName() {
			return getRuleContext(TypedNameContext.class,0);
		}
		public TerminalNode ASSIGN_OPERATOR() { return getToken(PipedParser.ASSIGN_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 20, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(ValueDefinition);
			setState(136);
			typedName();
			setState(137);
			match(ASSIGN_OPERATOR);
			setState(138);
			((AssignContext)_localctx).right = expression(0);
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
	public static class ReassignContext extends ParserRuleContext {
		public Token name;
		public ExpressionContext right;
		public TerminalNode ASSIGN_OPERATOR() { return getToken(PipedParser.ASSIGN_OPERATOR, 0); }
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterReassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitReassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitReassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReassignContext reassign() throws RecognitionException {
		ReassignContext _localctx = new ReassignContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_reassign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((ReassignContext)_localctx).name = match(ID);
			setState(141);
			match(ASSIGN_OPERATOR);
			setState(142);
			((ReassignContext)_localctx).right = expression(0);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Var_Context extends ExpressionContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public Var_Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterVar_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitVar_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitVar_(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BOOL_OPContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOL_OPERATOR() { return getToken(PipedParser.BOOL_OPERATOR, 0); }
		public BOOL_OPContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterBOOL_OP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitBOOL_OP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitBOOL_OP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScopeContext extends ExpressionContext {
		public LocalScopeContext localScope() {
			return getRuleContext(LocalScopeContext.class,0);
		}
		public ScopeContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class Value_Context extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Value_Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterValue_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitValue_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitValue_(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MulDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParensContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PIPELINEContext extends ExpressionContext {
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
		}
		public PIPELINEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterPIPELINE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitPIPELINE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitPIPELINE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentList_Context extends ExpressionContext {
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public ArgumentList_Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterArgumentList_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitArgumentList_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitArgumentList_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new PIPELINEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(145);
				pipeline();
				}
				break;
			case 2:
				{
				_localctx = new ScopeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				localScope();
				}
				break;
			case 3:
				{
				_localctx = new ArgumentList_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				tuple();
				}
				break;
			case 4:
				{
				_localctx = new Value_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				value();
				}
				break;
			case 5:
				{
				_localctx = new Var_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				var();
				}
				break;
			case 6:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(T__4);
				setState(151);
				expression(0);
				setState(152);
				match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(165);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new BOOL_OPContext(new ExpressionContext(_parentctx, _parentState));
						((BOOL_OPContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(156);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(157);
						((BOOL_OPContext)_localctx).op = match(BOOL_OPERATOR);
						setState(158);
						((BOOL_OPContext)_localctx).right = expression(7);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new ExpressionContext(_parentctx, _parentState));
						((MulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(160);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(161);
						((MulDivContext)_localctx).right = expression(6);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(163);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__12) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						((AddSubContext)_localctx).right = expression(5);
						}
						break;
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 26, RULE_var);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(ID);
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(171);
					match(T__0);
					setState(172);
					match(ID);
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public TupleTypeContext tupleType() {
			return getRuleContext(TupleTypeContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeName);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(ID);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
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
	public static class PipelineContext extends ParserRuleContext {
		public TupleContext inital;
		public List<NextPipeContext> nextPipe() {
			return getRuleContexts(NextPipeContext.class);
		}
		public NextPipeContext nextPipe(int i) {
			return getRuleContext(NextPipeContext.class,i);
		}
		public List<GuardedPipeContext> guardedPipe() {
			return getRuleContexts(GuardedPipeContext.class);
		}
		public GuardedPipeContext guardedPipe(int i) {
			return getRuleContext(GuardedPipeContext.class,i);
		}
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
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
		enterRule(_localctx, 30, RULE_pipeline);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(182);
				((PipelineContext)_localctx).inital = tuple();
				}
				break;
			}
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(187);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PIPE_OPERATOR:
						{
						setState(185);
						nextPipe();
						}
						break;
					case T__13:
						{
						setState(186);
						guardedPipe();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class GuardedPipeContext extends ParserRuleContext {
		public ExpressionContext elseBody;
		public UntypedArgumentListContext untypedArgumentList() {
			return getRuleContext(UntypedArgumentListContext.class,0);
		}
		public TerminalNode PIPE_OPERATOR() { return getToken(PipedParser.PIPE_OPERATOR, 0); }
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
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
		enterRule(_localctx, 32, RULE_guardedPipe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__13);
			setState(193);
			untypedArgumentList();
			setState(194);
			match(PIPE_OPERATOR);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
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
			match(T__14);
			{
			setState(202);
			((GuardedPipeContext)_localctx).elseBody = expression(0);
			}
			setState(203);
			match(T__15);
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(204);
				match(T__6);
				setState(205);
				typeName();
				}
				break;
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
	public static class NextPipeContext extends ParserRuleContext {
		public Token name;
		public TerminalNode PIPE_OPERATOR() { return getToken(PipedParser.PIPE_OPERATOR, 0); }
		public TerminalNode ID() { return getToken(PipedParser.ID, 0); }
		public NextPipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextPipe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).enterNextPipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PipedListener ) ((PipedListener)listener).exitNextPipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PipedVisitor ) return ((PipedVisitor<? extends T>)visitor).visitNextPipe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextPipeContext nextPipe() throws RecognitionException {
		NextPipeContext _localctx = new NextPipeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_nextPipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(PIPE_OPERATOR);
			setState(209);
			((NextPipeContext)_localctx).name = match(ID);
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
		enterRule(_localctx, 36, RULE_untypedArgumentList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__4);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(212);
					match(ID);
					setState(213);
					match(T__7);
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(219);
			match(ID);
			setState(220);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GuardContext extends ParserRuleContext {
		public ExpressionContext condition;
		public ExpressionContext body;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 38, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__4);
			setState(223);
			((GuardContext)_localctx).condition = expression(0);
			setState(224);
			match(T__5);
			setState(225);
			((GuardContext)_localctx).body = expression(0);
			setState(226);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 40, RULE_tuple);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__4);
			setState(229);
			expression(0);
			setState(230);
			match(T__7);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					expression(0);
					setState(232);
					match(T__7);
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(239);
				expression(0);
				}
				break;
			}
			setState(242);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TupleTypeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PipedParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PipedParser.ID, i);
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
		enterRule(_localctx, 42, RULE_tupleType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__4);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(245);
					match(ID);
					setState(246);
					match(T__7);
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(252);
			match(ID);
			setState(253);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PipedParser.INT, 0); }
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
		enterRule(_localctx, 44, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 21233664L) != 0)) ) {
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
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
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
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u0102\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002;\b\u0002\n\u0002\f\u0002>\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003E\b"+
		"\u0003\n\u0003\f\u0003H\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004N\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004R\b\u0004"+
		"\n\u0004\f\u0004U\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"`\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006g\b\u0006\n\u0006\f\u0006j\t\u0006\u0001\u0006\u0003\u0006"+
		"m\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007v\b\u0007\n\u0007\f\u0007y\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007}\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u009b\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u00a6\b\f\n\f\f\f\u00a9\t\f\u0001\r"+
		"\u0001\r\u0001\r\u0005\r\u00ae\b\r\n\r\f\r\u00b1\t\r\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00b5\b\u000e\u0001\u000f\u0003\u000f\u00b8\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u00bc\b\u000f\n\u000f\f\u000f\u00bf"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00c5"+
		"\b\u0010\n\u0010\f\u0010\u00c8\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00cf\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00d7\b\u0012"+
		"\n\u0012\f\u0012\u00da\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u00eb\b\u0014\n\u0014\f\u0014\u00ee\t\u0014\u0001\u0014\u0003\u0014"+
		"\u00f1\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00f8\b\u0015\n\u0015\f\u0015\u00fb\t\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0000\u0001\u0018"+
		"\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,\u0000\u0003\u0001\u0000\n\u000b\u0001\u0000"+
		"\f\r\u0003\u0000\u0012\u0012\u0016\u0016\u0018\u0018\u0109\u0000.\u0001"+
		"\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000"+
		"\u0000\u0006F\u0001\u0000\u0000\u0000\bI\u0001\u0000\u0000\u0000\nX\u0001"+
		"\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000\u000en\u0001\u0000\u0000"+
		"\u0000\u0010\u0080\u0001\u0000\u0000\u0000\u0012\u0084\u0001\u0000\u0000"+
		"\u0000\u0014\u0087\u0001\u0000\u0000\u0000\u0016\u008c\u0001\u0000\u0000"+
		"\u0000\u0018\u009a\u0001\u0000\u0000\u0000\u001a\u00aa\u0001\u0000\u0000"+
		"\u0000\u001c\u00b4\u0001\u0000\u0000\u0000\u001e\u00b7\u0001\u0000\u0000"+
		"\u0000 \u00c0\u0001\u0000\u0000\u0000\"\u00d0\u0001\u0000\u0000\u0000"+
		"$\u00d3\u0001\u0000\u0000\u0000&\u00de\u0001\u0000\u0000\u0000(\u00e4"+
		"\u0001\u0000\u0000\u0000*\u00f4\u0001\u0000\u0000\u0000,\u00ff\u0001\u0000"+
		"\u0000\u0000./\u0003\u0002\u0001\u0000/0\u0003\u0006\u0003\u00000\u0001"+
		"\u0001\u0000\u0000\u000013\u0003\u0004\u0002\u000021\u0001\u0000\u0000"+
		"\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u00005\u0003\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u0000"+
		"7<\u0005\u0019\u0000\u000089\u0005\u001d\u0000\u00009;\u0005\u0001\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000"+
		"\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000?@\u0005\u001d\u0000\u0000@A\u0005\u001c\u0000\u0000"+
		"A\u0005\u0001\u0000\u0000\u0000BE\u0003\u000e\u0007\u0000CE\u0003\n\u0005"+
		"\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000EH\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0007"+
		"\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IS\u0005\u0002\u0000"+
		"\u0000JN\u0003\u0018\f\u0000KN\u0003\u0014\n\u0000LN\u0003\u0012\t\u0000"+
		"MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OP\u0005\u001c\u0000\u0000PR\u0001\u0000"+
		"\u0000\u0000QM\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000VW\u0005\u0003\u0000\u0000W\t\u0001\u0000\u0000"+
		"\u0000XY\u0005\u0004\u0000\u0000YZ\u0005\u001d\u0000\u0000Z[\u0005\u0005"+
		"\u0000\u0000[\\\u0003\f\u0006\u0000\\_\u0005\u0006\u0000\u0000]^\u0005"+
		"\u0007\u0000\u0000^`\u0003\u001c\u000e\u0000_]\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0003\b\u0004\u0000"+
		"b\u000b\u0001\u0000\u0000\u0000cd\u0003\u0010\b\u0000de\u0005\b\u0000"+
		"\u0000eg\u0001\u0000\u0000\u0000fc\u0001\u0000\u0000\u0000gj\u0001\u0000"+
		"\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000km\u0003\u0010\b\u0000lh\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\r\u0001\u0000\u0000\u0000"+
		"no\u0005\t\u0000\u0000op\u0005\u001d\u0000\u0000pw\u0005\u0002\u0000\u0000"+
		"qr\u0005\u0011\u0000\u0000rs\u0003\u0010\b\u0000st\u0005\b\u0000\u0000"+
		"tv\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x|\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005\u0011\u0000\u0000{}\u0003"+
		"\u0010\b\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005\u0003\u0000\u0000\u007f\u000f\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0005\u001d\u0000\u0000\u0081\u0082\u0005\u0007"+
		"\u0000\u0000\u0082\u0083\u0003\u001c\u000e\u0000\u0083\u0011\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0005\u0019\u0000\u0000\u0085\u0086\u0003\u0018"+
		"\f\u0000\u0086\u0013\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0011\u0000"+
		"\u0000\u0088\u0089\u0003\u0010\b\u0000\u0089\u008a\u0005\u001b\u0000\u0000"+
		"\u008a\u008b\u0003\u0018\f\u0000\u008b\u0015\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0005\u001d\u0000\u0000\u008d\u008e\u0005\u001b\u0000\u0000\u008e"+
		"\u008f\u0003\u0018\f\u0000\u008f\u0017\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0006\f\uffff\uffff\u0000\u0091\u009b\u0003\u001e\u000f\u0000\u0092\u009b"+
		"\u0003\b\u0004\u0000\u0093\u009b\u0003(\u0014\u0000\u0094\u009b\u0003"+
		",\u0016\u0000\u0095\u009b\u0003\u001a\r\u0000\u0096\u0097\u0005\u0005"+
		"\u0000\u0000\u0097\u0098\u0003\u0018\f\u0000\u0098\u0099\u0005\u0006\u0000"+
		"\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0090\u0001\u0000\u0000"+
		"\u0000\u009a\u0092\u0001\u0000\u0000\u0000\u009a\u0093\u0001\u0000\u0000"+
		"\u0000\u009a\u0094\u0001\u0000\u0000\u0000\u009a\u0095\u0001\u0000\u0000"+
		"\u0000\u009a\u0096\u0001\u0000\u0000\u0000\u009b\u00a7\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\n\u0006\u0000\u0000\u009d\u009e\u0005\u0017\u0000\u0000"+
		"\u009e\u00a6\u0003\u0018\f\u0007\u009f\u00a0\n\u0005\u0000\u0000\u00a0"+
		"\u00a1\u0007\u0000\u0000\u0000\u00a1\u00a6\u0003\u0018\f\u0006\u00a2\u00a3"+
		"\n\u0004\u0000\u0000\u00a3\u00a4\u0007\u0001\u0000\u0000\u00a4\u00a6\u0003"+
		"\u0018\f\u0005\u00a5\u009c\u0001\u0000\u0000\u0000\u00a5\u009f\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a2\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u0019\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00aa\u00af\u0005\u001d\u0000\u0000\u00ab\u00ac\u0005\u0001"+
		"\u0000\u0000\u00ac\u00ae\u0005\u001d\u0000\u0000\u00ad\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u001b\u0001\u0000"+
		"\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b5\u0005\u001d"+
		"\u0000\u0000\u00b3\u00b5\u0003*\u0015\u0000\u00b4\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u001d\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b8\u0003(\u0014\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bd\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bc\u0003\"\u0011\u0000\u00ba\u00bc\u0003 \u0010\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be\u001f\u0001\u0000\u0000\u0000\u00bf"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u000e\u0000\u0000\u00c1"+
		"\u00c2\u0003$\u0012\u0000\u00c2\u00c6\u0005\u001a\u0000\u0000\u00c3\u00c5"+
		"\u0003&\u0013\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0005\u000f\u0000\u0000\u00ca\u00cb\u0003"+
		"\u0018\f\u0000\u00cb\u00ce\u0005\u0010\u0000\u0000\u00cc\u00cd\u0005\u0007"+
		"\u0000\u0000\u00cd\u00cf\u0003\u001c\u000e\u0000\u00ce\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf!\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0005\u001a\u0000\u0000\u00d1\u00d2\u0005\u001d\u0000"+
		"\u0000\u00d2#\u0001\u0000\u0000\u0000\u00d3\u00d8\u0005\u0005\u0000\u0000"+
		"\u00d4\u00d5\u0005\u001d\u0000\u0000\u00d5\u00d7\u0005\b\u0000\u0000\u00d6"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00db\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0005\u001d\u0000\u0000\u00dc\u00dd\u0005\u0006\u0000\u0000\u00dd"+
		"%\u0001\u0000\u0000\u0000\u00de\u00df\u0005\u0005\u0000\u0000\u00df\u00e0"+
		"\u0003\u0018\f\u0000\u00e0\u00e1\u0005\u0006\u0000\u0000\u00e1\u00e2\u0003"+
		"\u0018\f\u0000\u00e2\u00e3\u0005\b\u0000\u0000\u00e3\'\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\u0005\u0005\u0000\u0000\u00e5\u00e6\u0003\u0018\f\u0000"+
		"\u00e6\u00ec\u0005\b\u0000\u0000\u00e7\u00e8\u0003\u0018\f\u0000\u00e8"+
		"\u00e9\u0005\b\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e7"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00f0"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f1"+
		"\u0003\u0018\f\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005"+
		"\u0006\u0000\u0000\u00f3)\u0001\u0000\u0000\u0000\u00f4\u00f9\u0005\u0005"+
		"\u0000\u0000\u00f5\u00f6\u0005\u001d\u0000\u0000\u00f6\u00f8\u0005\b\u0000"+
		"\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000"+
		"\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fc\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0005\u001d\u0000\u0000\u00fd\u00fe\u0005\u0006\u0000"+
		"\u0000\u00fe+\u0001\u0000\u0000\u0000\u00ff\u0100\u0007\u0002\u0000\u0000"+
		"\u0100-\u0001\u0000\u0000\u0000\u00194<DFMS_hlw|\u009a\u00a5\u00a7\u00af"+
		"\u00b4\u00b7\u00bb\u00bd\u00c6\u00ce\u00d8\u00ec\u00f0\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}