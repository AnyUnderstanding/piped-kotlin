package de.any.analyzer

import de.any.AST.*

class SymbolCollector : ASTVisitor() {
    override fun visitBundle(bundle: Bundle, vararg args: Any) {
        BundleTable.addBundle(
            bundle.name,
            bundle
        )
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        PipeTable.addPipe(
            pipe.name,
            pipe
        )
    }
}

