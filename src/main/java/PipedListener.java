// Generated from /home/christopher/IdeaProjects/piped2/src/main/resources/Piped.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PipedParser}.
 */
public interface PipedListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PipedParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PipedParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PipedParser.ProgramContext ctx);
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
	 * Enter a parse tree produced by {@link PipedParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(PipedParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(PipedParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PipedParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PipedParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#argumentsDefinitionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsDefinitionList(PipedParser.ArgumentsDefinitionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#argumentsDefinitionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsDefinitionList(PipedParser.ArgumentsDefinitionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolOp}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(PipedParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolOp}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(PipedParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pass1}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass1(PipedParser.Pass1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass1}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass1(PipedParser.Pass1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass2}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass2(PipedParser.Pass2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass2}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass2(PipedParser.Pass2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass3}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass3(PipedParser.Pass3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass3}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass3(PipedParser.Pass3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivOp}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivOp(PipedParser.MulDivOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivOp}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivOp(PipedParser.MulDivOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pass4}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass4(PipedParser.Pass4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass4}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass4(PipedParser.Pass4Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass5}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass5(PipedParser.Pass5Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass5}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass5(PipedParser.Pass5Context ctx);
	/**
	 * Enter a parse tree produced by the {@code pass6}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPass6(PipedParser.Pass6Context ctx);
	/**
	 * Exit a parse tree produced by the {@code pass6}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPass6(PipedParser.Pass6Context ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(PipedParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(PipedParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubOp}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOp(PipedParser.AddSubOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubOp}
	 * labeled alternative in {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOp(PipedParser.AddSubOpContext ctx);
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
	 * Enter a parse tree produced by {@link PipedParser#pipelineElement}.
	 * @param ctx the parse tree
	 */
	void enterPipelineElement(PipedParser.PipelineElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#pipelineElement}.
	 * @param ctx the parse tree
	 */
	void exitPipelineElement(PipedParser.PipelineElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#pipelineTuple}.
	 * @param ctx the parse tree
	 */
	void enterPipelineTuple(PipedParser.PipelineTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#pipelineTuple}.
	 * @param ctx the parse tree
	 */
	void exitPipelineTuple(PipedParser.PipelineTupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void enterPlaceholder(PipedParser.PlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void exitPlaceholder(PipedParser.PlaceholderContext ctx);
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
	 * Enter a parse tree produced by {@link PipedParser#elseGuard}.
	 * @param ctx the parse tree
	 */
	void enterElseGuard(PipedParser.ElseGuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#elseGuard}.
	 * @param ctx the parse tree
	 */
	void exitElseGuard(PipedParser.ElseGuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link PipedParser#bundleInit}.
	 * @param ctx the parse tree
	 */
	void enterBundleInit(PipedParser.BundleInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#bundleInit}.
	 * @param ctx the parse tree
	 */
	void exitBundleInit(PipedParser.BundleInitContext ctx);
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
	 * Enter a parse tree produced by {@link PipedParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PipedParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PipedParser.ValueContext ctx);
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
	 * Enter a parse tree produced by {@link PipedParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PipedParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PipedParser.TypeContext ctx);
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
	 * Enter a parse tree produced by {@link PipedParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(PipedParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link PipedParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(PipedParser.IntContext ctx);
}