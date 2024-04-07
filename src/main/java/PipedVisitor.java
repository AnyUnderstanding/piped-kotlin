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
	 * Visit a parse tree produced by {@link PipedParser#programm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramm(PipedParser.ProgrammContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(PipedParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#import_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_(PipedParser.Import_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#globalScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalScope(PipedParser.GlobalScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#localScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalScope(PipedParser.LocalScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#pipeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeDefinition(PipedParser.PipeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsDefinition(PipedParser.ArgumentsDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#bundleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBundleDefinition(PipedParser.BundleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#typedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedName(PipedParser.TypedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(PipedParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(PipedParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#reassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReassign(PipedParser.ReassignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_(PipedParser.Var_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL_OP}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL_OP(PipedParser.BOOL_OPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Value_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_(PipedParser.Value_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(PipedParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(PipedParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(PipedParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scope}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(PipedParser.ScopeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PIPELINE}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPIPELINE(PipedParser.PIPELINEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentList_}
	 * labeled alternative in {@link PipedParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList_(PipedParser.ArgumentList_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PipedParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(PipedParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#pipeline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeline(PipedParser.PipelineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#guardedPipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedPipe(PipedParser.GuardedPipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#nextPipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextPipe(PipedParser.NextPipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#untypedArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntypedArgumentList(PipedParser.UntypedArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(PipedParser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(PipedParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#tupleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleType(PipedParser.TupleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PipedParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(PipedParser.ValueContext ctx);
}