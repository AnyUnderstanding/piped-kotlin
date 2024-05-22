package de.any.codegen.llvmTarget

import de.any.AST.*

val printFunctionDeclare = """
    @.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
    declare i32 @printf(ptr noundef, ...) #2
""".trimIndent()

val printPipe = Pipe(
    "print",
    PrimitiveType.INT.type,
    listOf(
        Field("value", PrimitiveType.INT.type),
    ),
    Scope(
        mutableListOf(
            PreDefinedNode(
                "call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)\n"
            ),
            Return(
                Variable(
                    listOf("value"),
                ).apply {
                    type = PrimitiveType.INT.type
                }
            )
        )
    )
)

class InsertPredefined : ASTVisitor() {
    override fun visit(program: Program, vararg args: Any) {
        program.pipes.add(printPipe)
    }
}