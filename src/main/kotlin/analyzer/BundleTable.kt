package de.any.analyzer

import de.any.AST.Bundle
import de.any.AST.PrimitiveType
import de.any.AST.Type

class BundleTable {
    private val bundleTable = mutableMapOf<String, Bundle>()

    fun addBundle(name: String, bundle: Bundle) {
        if (bundleTable.containsKey(name)) {
            throw IllegalArgumentException("Bundle with name $name already exists")
        }
        bundleTable[name] = bundle
    }

    fun getBundleByName(name: String): Bundle? {
        return bundleTable[name]
    }

    fun getBundleByNameStrict(name: String): Bundle {
        return bundleTable[name] ?: throw Exception("Bundle not found")
    }

    fun getBundleByType(type: Type): Bundle? {
        return bundleTable.values.find { it.name == type.getBasicType() }
    }

    fun getBundleByTypeStrict(type: Type): Bundle {
        return bundleTable.values.find { it.name == type.getBasicType() } ?: throw Exception("Bundle not found: $type")
    }

    fun containsBundle(name: String): Boolean {
        return bundleTable.containsKey(name)
    }

    fun getAllBundles(): List<Bundle> {
        return bundleTable.values.toList()
    }

    fun getTypeForPath(bundle: Bundle, path: List<String>): Type? {
        if (path.isEmpty()) {
            return Type.fromString(bundle.name)
        }
        if (path.size == 1 && PrimitiveType.hasType(
            bundle.fields.find { it.name == path.first() }?.type ?: throw Exception("Field not found")
        )) {
            return bundle.fields.find { it.name == path.first() }?.type
        }
        val nextBundleType = bundle.fields.find { it.name == path.first() }?.type ?: throw Exception("Field not found")
        val nextBundle = getBundleByName(nextBundleType.getBasicTypeStrict()) ?: throw Exception("Unkown Type")
        return getTypeForPath(nextBundle, path.drop(1))
    }

    fun getTypeForPathStrict(bundle: Bundle, path: List<String>): Type {
        return getTypeForPath(bundle, path) ?: throw Exception("Type for path $path not found")
    }

    fun clear() {
        bundleTable.clear()
    }
}