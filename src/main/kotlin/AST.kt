package de.any

import de.any.analyzer.Type


open class ASTNode(var type: String = "void") {

}



class Program(
    val bundles: List<Bundle>,
    val pipes: List<Pipe>
)



class Bundle(
    val name: String,
    val fields: List<Field>
)

class Field(
    val name: String,
    val type: String,
)

class Pipe(
    val name: String,
    val returnType: Type,
    val parameters: List<Field>,


)

class Scope(val children: List<ASTNode>) : ASTNode()


