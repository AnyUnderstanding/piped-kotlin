package de.any.analyzer

import org.antlr.v4.runtime.ParserRuleContext

object TreeInfo {
    val inferredTypes: MutableMap<ParserRuleContext, NodeInformation> = mutableMapOf()

    fun addType(ctx: ParserRuleContext, type: Type): NodeInformation {
        val nodeInformation = inferredTypes.getOrPut(ctx) {
            NodeInformation()
        }
        nodeInformation.type = type
        return nodeInformation
    }

    fun getType(ctx: ParserRuleContext): Type = inferredTypes[ctx]?.type ?: throw IllegalStateException("Type not found")



}

class NodeInformation {
    var type: Type = PrimitiveType.VOID.type
}
