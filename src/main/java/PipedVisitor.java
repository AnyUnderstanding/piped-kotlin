// Generated from /home/christopher/IdeaProjects/piped2/src/main/resources/Piped.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PipedParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PipedVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PipedParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PipedParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#bundleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBundleDefinition(PipedParser.BundleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#import_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_(PipedParser.Import_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#pipeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeDefinition(PipedParser.PipeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(PipedParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#argumentsDefinitionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsDefinitionList(PipedParser.ArgumentsDefinitionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PipedParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#pipeline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeline(PipedParser.PipelineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#pipelineTuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelineTuple(PipedParser.PipelineTupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#guardedPipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedPipe(PipedParser.GuardedPipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(PipedParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(PipedParser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#untypedArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntypedArgumentList(PipedParser.UntypedArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#elseGuard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseGuard(PipedParser.ElseGuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PipedParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(PipedParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(PipedParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(PipedParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#typedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedName(PipedParser.TypedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(PipedParser.IntContext ctx);
}