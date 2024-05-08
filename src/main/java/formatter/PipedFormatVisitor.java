// Generated from /home/christopher/IdeaProjects/piped2/src/main/resources/PipedFormat.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PipedFormatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PipedFormatVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PipedFormatParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#bundleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBundleDefinition(PipedFormatParser.BundleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#import_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_(PipedFormatParser.Import_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#pipeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeDefinition(PipedFormatParser.PipeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(PipedFormatParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PipedFormatParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#argumentsDefinitionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsDefinitionList(PipedFormatParser.ArgumentsDefinitionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(PipedFormatParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pass1}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass1(PipedFormatParser.Pass1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code pass2}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass2(PipedFormatParser.Pass2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code pass3}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass3(PipedFormatParser.Pass3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivOp(PipedFormatParser.MulDivOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pass4}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass4(PipedFormatParser.Pass4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code pass5}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass5(PipedFormatParser.Pass5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code pass6}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass6(PipedFormatParser.Pass6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(PipedFormatParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubOp}
	 * labeled alternative in {@link PipedFormatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOp(PipedFormatParser.AddSubOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#pipeline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeline(PipedFormatParser.PipelineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#pipelineElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelineElement(PipedFormatParser.PipelineElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#pipelineTuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelineTuple(PipedFormatParser.PipelineTupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceholder(PipedFormatParser.PlaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#guardedPipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedPipe(PipedFormatParser.GuardedPipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(PipedFormatParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(PipedFormatParser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#untypedArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntypedArgumentList(PipedFormatParser.UntypedArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#elseGuard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseGuard(PipedFormatParser.ElseGuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#bundleInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBundleInit(PipedFormatParser.BundleInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PipedFormatParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(PipedFormatParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(PipedFormatParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(PipedFormatParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#typedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedName(PipedFormatParser.TypedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PipedFormatParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#tupleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleType(PipedFormatParser.TupleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedFormatParser#int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(PipedFormatParser.IntContext ctx);
}