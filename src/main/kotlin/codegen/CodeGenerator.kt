package de.any.codegen

import de.any.AST.Program

interface CodeGenerator {
    fun gen(program: Program) : String
}