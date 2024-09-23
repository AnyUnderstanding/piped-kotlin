package de.any.analyzer

import de.any.AST.*


class SymbolCollector(val bundleTable: BundleTable, val pipeTable: PipeTable) : ASTVisitor() {
    override fun visitBundle(bundle: Bundle, vararg args: Any) {
        bundleTable.addBundle(
            bundle.name,
            bundle
        )
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        pipeTable.addPipe(
            pipe.name,
            pipe
        )
    }
}

