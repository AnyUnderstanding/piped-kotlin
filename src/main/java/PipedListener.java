// Generated from /home/christopher/IdeaProjects/piped2/src/main/resources/Piped.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PipedParser}.
 */
public interface PipedListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PipedParser#programm}.
	 * @param ctx the parse tree
	 */
	void enterProgramm(PipedParser.ProgrammContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#programm}.
	 * @param ctx the parse tree
	 */
	void exitProgramm(PipedParser.ProgrammContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(PipedParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(PipedParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#import_}.
	 * @param ctx the parse tree
	 */
	void enterImport_(PipedParser.Import_Context ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#import_}.
	 * @param ctx the parse tree
	 */
	void exitImport_(PipedParser.Import_Context ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#globalScope}.
	 * @param ctx the parse tree
	 */
	void enterGlobalScope(PipedParser.GlobalScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#globalScope}.
	 * @param ctx the parse tree
	 */
	void exitGlobalScope(PipedParser.GlobalScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#localScope}.
	 * @param ctx the parse tree
	 */
	void enterLocalScope(PipedParser.LocalScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#localScope}.
	 * @param ctx the parse tree
	 */
	void exitLocalScope(PipedParser.LocalScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#pipeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPipeDefinition(PipedParser.PipeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#pipeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPipeDefinition(PipedParser.PipeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsDefinition(PipedParser.ArgumentsDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsDefinition(PipedParser.ArgumentsDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#bundleDefinition}.
	 * @param ctx the parse tree
	 */
	void enterBundleDefinition(PipedParser.BundleDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#bundleDefinition}.
	 * @param ctx the parse tree
	 */
	void exitBundleDefinition(PipedParser.BundleDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#typedName}.
	 * @param ctx the parse tree
	 */
	void enterTypedName(PipedParser.TypedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#typedName}.
	 * @param ctx the parse tree
	 */
	void exitTypedName(PipedParser.TypedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(PipedParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(PipedParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PipedParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PipedParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#reassign}.
	 * @param ctx the parse tree
	 */
	void enterReassign(PipedParser.ReassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#reassign}.
	 * @param ctx the parse tree
	 */
	void exitReassign(PipedParser.ReassignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar_(PipedParser.Var_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Var_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar_(PipedParser.Var_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOL_OP}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBOOL_OP(PipedParser.BOOL_OPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOL_OP}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBOOL_OP(PipedParser.BOOL_OPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Value_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValue_(PipedParser.Value_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Value_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValue_(PipedParser.Value_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(PipedParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(PipedParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(PipedParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(PipedParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParens(PipedParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParens(PipedParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scope}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterScope(PipedParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scope}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitScope(PipedParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PIPELINE}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPIPELINE(PipedParser.PIPELINEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PIPELINE}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPIPELINE(PipedParser.PIPELINEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentList_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList_(PipedParser.ArgumentList_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentList_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList_(PipedParser.ArgumentList_Context ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(PipedParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(PipedParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(PipedParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(PipedParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void enterPipeline(PipedParser.PipelineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void exitPipeline(PipedParser.PipelineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#guardedPipe}.
	 * @param ctx the parse tree
	 */
	void enterGuardedPipe(PipedParser.GuardedPipeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#guardedPipe}.
	 * @param ctx the parse tree
	 */
	void exitGuardedPipe(PipedParser.GuardedPipeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#nextPipe}.
	 * @param ctx the parse tree
	 */
	void enterNextPipe(PipedParser.NextPipeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#nextPipe}.
	 * @param ctx the parse tree
	 */
	void exitNextPipe(PipedParser.NextPipeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#untypedArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterUntypedArgumentList(PipedParser.UntypedArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#untypedArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitUntypedArgumentList(PipedParser.UntypedArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(PipedParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(PipedParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(PipedParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(PipedParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#tupleType}.
	 * @param ctx the parse tree
	 */
	void enterTupleType(PipedParser.TupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#tupleType}.
	 * @param ctx the parse tree
	 */
	void exitTupleType(PipedParser.TupleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PipedParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PipedParser.ValueContext ctx);
}