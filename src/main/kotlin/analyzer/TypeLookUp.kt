package de.any.analyzer

import de.any.AST.PrimitiveType
import de.any.AST.Type

object TypeLookUp {
    fun typeExists(type: Type): Boolean {
        return (PrimitiveType.hasType(type) && PrimitiveType.NONE.type != type) || BundleTable.containsBundle(type.name)
    }
}