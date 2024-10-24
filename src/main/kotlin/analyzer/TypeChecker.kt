package de.any.analyzer

import de.any.AST.*


class TypeChecker(val bundleTable: BundleTable, val pipeTable: PipeTable) : ASTVisitor() {
    var currentScope = VariableScope()

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        currentScope = currentScope.addChild()
        pipe.parameters.forEach { currentScope.addField(it) }
        super.visitPipe(pipe, *args)
        if (pipe.returnType != pipe.body.type) {
            throw Exception("Type error: expected ${pipe.returnType}, got ${pipe.body.type}")
        }
        currentScope = currentScope.bubbleUp()
    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        super.visitAssignment(assignment, *args)
        val expected = assignment.expectedType
        val real = assignment.expression.type
        currentScope.addField(Field(assignment.name, real))

        if (expected != real) {
            throw Exception("Type error: expected $expected, got $real in assignment: ${assignment}")
        }
    }

    override fun visitBoolOpExpression(boolExpression: BoolExpression, vararg args: Any) {
        super.visitBoolOpExpression(boolExpression)
        when (boolExpression.operand) {
            "==" -> {
                if (boolExpression.left.type != boolExpression.right.type) {
                    throw Exception("Type error: expected ${boolExpression.left.type}, got ${boolExpression.right.type}")
                }
            }

            ">", "<", ">=", "<=" -> {
                if (boolExpression.left.type != PrimitiveType.INT.type || boolExpression.right.type != PrimitiveType.INT.type) {
                    throw Exception("Type error: expected int, got ${boolExpression.left.type} and ${boolExpression.right.type}")
                }
            }

            else -> throw Exception("Unknown operand ${boolExpression.operand}")
        }
        boolExpression.type = PrimitiveType.BOOL.type
    }

    override fun visitMulDivExpression(mulDivExpression: MulDivExpression, vararg args: Any) {
        super.visitMulDivExpression(mulDivExpression)
        if (mulDivExpression.left.type != PrimitiveType.INT.type || mulDivExpression.right.type != PrimitiveType.INT.type) {
            throw Exception("Type error: expected int, got ${mulDivExpression.left.type} and ${mulDivExpression.right.type}")
        }
        mulDivExpression.type = PrimitiveType.INT.type
    }

    override fun visitAddSubExpression(addSubExpression: AddSubExpression, vararg args: Any) {
        super.visitAddSubExpression(addSubExpression)
        if (addSubExpression.left.type != PrimitiveType.INT.type || addSubExpression.right.type != PrimitiveType.INT.type) {
            throw Exception("Type error: expected int, got ${addSubExpression.left.type} and ${addSubExpression.right.type}")
        }
        addSubExpression.type = PrimitiveType.INT.type
    }

    override fun visitValue(value: Value, vararg args: Any) {
        when (value) {
            is IntValue -> value.type = PrimitiveType.INT.type
            is BoolValue -> value.type = PrimitiveType.BOOL.type
            is StringValue -> value.type = PrimitiveType.STRING.type
        }
    }

    override fun visitScope(scope: Scope, vararg args: Any) {
        currentScope = currentScope.addChild()
        super.visitScope(scope, *args)
        val type = scope.children.filter { it is Return }.reduceRightOrNull { returnStatement, acc ->
            if (returnStatement.type != acc.type) {
                throw Exception("Scope has no consistent return type")
            }
            acc
        }?.type ?: PrimitiveType.NONE.type
        scope.type = type
        scope.capturedVariables = currentScope.capturedVariables
        currentScope = currentScope.bubbleUp()
    }

    override fun visitVariable(variable: Variable, vararg args: Any) {
        super.visitVariable(variable)

        val lookUp = currentScope.getVariableStrict(variable)

        if (variable.isBundleField()) {
            val bundleLookUp = bundleTable.getBundleByTypeStrict(lookUp.type)
            variable.type = bundleTable.getTypeForPathStrict(bundleLookUp, variable.getPathWithoutIdentifier())
            variable.referencedBundle = lookUp.type
        } else {
            variable.type = lookUp.type
        }
        currentScope.captureVariable(variable)
    }

    override fun visitParenthesis(parenthesis: Parenthesis, vararg args: Any) {
        super.visitParenthesis(parenthesis)
        parenthesis.type = parenthesis.expression.type
    }

    override fun visitTuple(tuple: Tuple, vararg args: Any) {
        super.visitTuple(tuple)
        tuple.type = tuple.typeFromElements()
    }

    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        for (i in 0 until pipeLine.elements.size) {
            val previous = pipeLine.elements.getOrNull(i - 1)
            val current = pipeLine.elements[i]
            current.previousElement = previous
            visitExpression(pipeLine.elements[i])
        }
        super.visitPipeLine(pipeLine)
        pipeLine.type = pipeLine.elements.last().type
    }

    override fun visitPipeCall(pipeLineElement: PipeCall, vararg args: Any) {
        super.visitPipeCall(pipeLineElement, *args)
        val pipe = pipeTable.getPipeStrict(pipeLineElement.name)
        val inType = pipe.getInType()
        if (pipeLineElement.previousElement != null && pipeLineElement.previousElement!!.type != inType) {
            throw Exception("Type error: expected ${inType}, got ${pipeLineElement.previousElement!!.type} in pipe call $pipeLineElement")
        } else if (pipeLineElement.previousElement == null && inType != PrimitiveType.NONE.type) {
            throw Exception("Type error: expected ${inType}, got ${PrimitiveType.NONE.type} in pipe call $pipeLineElement")
        }
        pipeLineElement.type = pipe.returnType
    }

    override fun visitGuardedPipeCall(guardedPipeCall: GuardedPipeCall, vararg args: Any) {
        currentScope = currentScope.addChild()

        checkAndTypeGuardArgs(
            guardedPipeCall.parameters,
            guardedPipeCall.previousElement!!.type
        )
        guardedPipeCall.parameters.forEach { currentScope.addField(it) }

        super.visitGuardedPipeCall(guardedPipeCall, *args)



        guardedPipeCall.type = guardedPipeCall.guards.foldRight(guardedPipeCall.elseGuard.type) { guard, acc ->
            if (guard.type != acc) {
                throw Exception("Type error: expected ${acc}, got ${guard.type}")
            }
            acc
        }
        guardedPipeCall.capturedVariables = currentScope.capturedVariables.distinctBy { it.getIdentifier() }
        currentScope = currentScope.bubbleUp()
    }

    fun checkAndTypeGuardArgs(args: List<Field>, expected: Type) {
        if (args.size != expected.getChildren(bundleTable).size) {
            throw Exception("Type error: expected ${expected.size(bundleTable)} argument(s), got ${args.size}")
        }
        args.zip(expected.getChildren(bundleTable)).forEach { (arg, type) ->
            arg.type = type
        }
    }

    override fun visitPipeLineTuple(pipelineTuple: PipeLineTuple, vararg args: Any) {
        super.visitPipeLineTuple(pipelineTuple)
        val inType = pipelineTuple.previousElement?.type?.getChildren(bundleTable)
        val tupleTypes = pipelineTuple.expressions.map {
            when (it) {
                is PipeLineTuplePlaceholder -> {
                    val type = inType?.getOrNull(it.index)
                        ?: throw Exception("Type error: placeholder with index ${it.index} is a invalid reference")
                    it.type = type
                    type
                }

                else -> it.type
            }
        }
        pipelineTuple.typeFromElements(tupleTypes)
    }

    override fun visitGuard(guard: Guard, vararg args: Any) {
        super.visitGuard(guard)
        if (guard.guardExpression.type != PrimitiveType.BOOL.type) {
            throw Exception("Type error: expected bool, got ${guard.guardExpression.type}")
        }
        guard.type = guard.returnExpression.type
    }

    override fun visitElseGuard(elseGuard: ElseGuard, vararg args: Any) {
        super.visitElseGuard(elseGuard, *args)
        elseGuard.type = elseGuard.returnExpression.type
    }

    override fun visitReturn(return_: Return, vararg args: Any) {
        super.visitReturn(return_, *args)
        return_.type = return_.expression.type
    }

    override fun visitBundleInit(bundleInit: BundleInit, vararg args: Any) {
        super.visitBundleInit(bundleInit)
        val bundle = bundleTable.getBundleByNameStrict(bundleInit.name)
        val expected = bundle.fields.map { it.type }
        if (bundleInit.initializers.size != expected.size) {
            throw Exception("Type error: expected ${expected.size} arguments, got ${bundleInit.initializers.size}")
        }
        bundleInit.initializers.zip(expected).forEach { (init, type) ->
            if (init.type != type) {
                throw Exception("Type error: expected $type, got ${init.type}")
            }
        }
        bundleInit.type = Type.fromString(bundle.name)
    }
}