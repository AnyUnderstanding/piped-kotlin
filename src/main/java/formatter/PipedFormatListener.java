// Generated from /home/christopher/IdeaProjects/piped2/src/main/resources/PipedFormat.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PipedFormatParser}.
 */
public interface PipedFormatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PipedFormatParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PipedFormatParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#bundleDefinition}.
	 * @param ctx the parse tree
	 */
	void enterBundleDefinition(PipedFormatParser.BundleDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#bundleDefinition}.
	 * @param ctx the parse tree
	 */
	void exitBundleDefinition(PipedFormatParser.BundleDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#import_}.
	 * @param ctx the parse tree
	 */
	void enterImport_(PipedFormatParser.Import_Context ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#import_}.
	 * @param ctx the parse tree
	 */
	void exitImport_(PipedFormatParser.Import_Context ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#pipeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterPipeDefinition(PipedFormatParser.PipeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#pipeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitPipeDefinition(PipedFormatParser.PipeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(PipedFormatParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(PipedFormatParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PipedFormatParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PipedFormatParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#argumentsDefinitionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsDefinitionList(PipedFormatParser.ArgumentsDefinitionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#argumentsDefinitionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsDefinitionList(PipedFormatParser.ArgumentsDefinitionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(PipedFormatParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(PipedFormatParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pass1}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass1(PipedFormatParser.Pass1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass1}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass1(PipedFormatParser.Pass1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass2}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass2(PipedFormatParser.Pass2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass2}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass2(PipedFormatParser.Pass2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass3}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass3(PipedFormatParser.Pass3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass3}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass3(PipedFormatParser.Pass3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivOp(PipedFormatParser.MulDivOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivOp(PipedFormatParser.MulDivOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pass4}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass4(PipedFormatParser.Pass4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass4}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass4(PipedFormatParser.Pass4Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass5}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass5(PipedFormatParser.Pass5Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass5}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass5(PipedFormatParser.Pass5Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass6}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass6(PipedFormatParser.Pass6Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass6}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass6(PipedFormatParser.Pass6Context ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(PipedFormatParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(PipedFormatParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOp(PipedFormatParser.AddSubOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOp(PipedFormatParser.AddSubOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void enterPipeline(PipedFormatParser.PipelineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void exitPipeline(PipedFormatParser.PipelineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#pipelineElement}.
	 * @param ctx the parse tree
	 */
	void enterPipelineElement(PipedFormatParser.PipelineElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#pipelineElement}.
	 * @param ctx the parse tree
	 */
	void exitPipelineElement(PipedFormatParser.PipelineElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#pipelineTuple}.
	 * @param ctx the parse tree
	 */
	void enterPipelineTuple(PipedFormatParser.PipelineTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#pipelineTuple}.
	 * @param ctx the parse tree
	 */
	void exitPipelineTuple(PipedFormatParser.PipelineTupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void enterPlaceholder(PipedFormatParser.PlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void exitPlaceholder(PipedFormatParser.PlaceholderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#guardedPipe}.
	 * @param ctx the parse tree
	 */
	void enterGuardedPipe(PipedFormatParser.GuardedPipeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#guardedPipe}.
	 * @param ctx the parse tree
	 */
	void exitGuardedPipe(PipedFormatParser.GuardedPipeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(PipedFormatParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(PipedFormatParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(PipedFormatParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(PipedFormatParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#untypedArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterUntypedArgumentList(PipedFormatParser.UntypedArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#untypedArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitUntypedArgumentList(PipedFormatParser.UntypedArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#elseGuard}.
	 * @param ctx the parse tree
	 */
	void enterElseGuard(PipedFormatParser.ElseGuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#elseGuard}.
	 * @param ctx the parse tree
	 */
	void exitElseGuard(PipedFormatParser.ElseGuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#bundleInit}.
	 * @param ctx the parse tree
	 */
	void enterBundleInit(PipedFormatParser.BundleInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#bundleInit}.
	 * @param ctx the parse tree
	 */
	void exitBundleInit(PipedFormatParser.BundleInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(PipedFormatParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(PipedFormatParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PipedFormatParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PipedFormatParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(PipedFormatParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(PipedFormatParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PipedFormatParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PipedFormatParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#typedName}.
	 * @param ctx the parse tree
	 */
	void enterTypedName(PipedFormatParser.TypedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#typedName}.
	 * @param ctx the parse tree
	 */
	void exitTypedName(PipedFormatParser.TypedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PipedFormatParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PipedFormatParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#tupleType}.
	 * @param ctx the parse tree
	 */
	void enterTupleType(PipedFormatParser.TupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#tupleType}.
	 * @param ctx the parse tree
	 */
	void exitTupleType(PipedFormatParser.TupleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedFormatParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(PipedFormatParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedFormatParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(PipedFormatParser.IntContext ctx);
}