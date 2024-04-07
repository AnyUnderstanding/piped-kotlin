package de.any.analyzer

import PipedBaseVisitor

// TODO duplicate names (Pipe, Bundle)

class SymbolCollector : PipedBaseVisitor<Unit>() {
    override fun visitPipeDefinition(ctx: PipedParser.PipeDefinitionContext?) {
        val pipe = Pipe(
            ctx!!.name.text,
            if (ctx.returnType == null) PrimitiveType.VOID.type else Type(ctx.returnType.text),
            listOf()
        )
        PipeTable.addPipe(pipe)
    }

    override fun visitBundleDefinition(ctx: PipedParser.BundleDefinitionContext?) {

        val bundle = Bundle(
            ctx!!.name.text,
            listOf()
        )
        TypeTable.addType(bundle)
    }
}
