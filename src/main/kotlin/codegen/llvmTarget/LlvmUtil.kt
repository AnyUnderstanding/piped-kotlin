package de.any.codegen.llvmTarget

import de.any.AST.Bundle
import de.any.AST.PrimitiveType
import de.any.AST.Type
import de.any.analyzer.BundleTable
import java.nio.file.Path

fun PrimitiveType.getLlvmName() {
    when (this) {
        PrimitiveType.INT -> "i32"
        PrimitiveType.BOOL -> "i1"
        PrimitiveType.STRING -> "i8*"
        PrimitiveType.NONE -> "void"
    }
}

fun getLlvmNameFromString(name: String): String {
    return when (name) {
        PrimitiveType.INT.type.getBasicTypeStrict() -> "i32"
        PrimitiveType.BOOL.type.getBasicTypeStrict() -> "i1"
        PrimitiveType.STRING.type.getBasicTypeStrict() -> "i8*"
        PrimitiveType.NONE.type.getBasicTypeStrict() -> "void"
        else -> name
    }

}

fun Type.getLlvmName(): String {
    if (isBundle()) {
        return "%${getBasicTypeStrict()}"
    }
    return getLlvmNameFromString(getBasicTypeStrict())
}

fun Type.getLlvmNamePointer(): String {
    if (PrimitiveType.hasType(this)) {
        return getLlvmName()
    }
    return "${getLlvmName()}*"
}

fun Bundle.getByteCount(bundleTable: BundleTable): Int {
    return fields.sumOf {
        when (it.type) {
            PrimitiveType.INT.type -> 4
            PrimitiveType.BOOL.type -> 1
            PrimitiveType.STRING.type -> 1
            PrimitiveType.NONE.type -> 0
            else -> bundleTable.getBundleByTypeStrict(it.type).getByteCount(bundleTable)
        }
    }
}

data class TranslationResult(val code: String, val location: String)