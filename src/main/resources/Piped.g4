grammar Piped;

programm: imports globalScope;

imports: import_*
;

import_: '>>' (ID '.')* ID END_STATEMENT
;

globalScope: (bundleDefinition | pipeDefinition)*
;

localScope: '{'
 ((expression | assign | return) END_STATEMENT)*
 '}'
;



pipeDefinition: 'pi' name=ID '(' args=argumentsDefinition ')' (':' returnType=typeName)? block=localScope
;

argumentsDefinition: ((typedName ',')* typedName)?
;

bundleDefinition: 'Bundle' name=ID '{'
 (ValueDefinition typedName ',')*
 (ValueDefinition typedName)?
 '}'
;

typedName: name=ID ':' type=typeName
;

return: RETURN_OPERATOR expression
;
assign: ValueDefinition typedName ASSIGN_OPERATOR right=expression
;

reassign: name=ID ASSIGN_OPERATOR right=expression
;



expression: pipeline # PIPELINE
    | localScope # Scope
    | tuple # ArgumentList_
    | left=expression op=BOOL_OPERATOR right=expression # BOOL_OP
	| left=expression op=('*'|'/') right=expression # MulDiv
    | left=expression op=('+'|'-') right=expression # AddSub
    | value # Value_
    | var # Var_
    | '(' expression ')' # Parens
    ;

var : ID ('.' ID)*
;
typeName: ID | tupleType;

// for now just imutable values
ValueDefinition: ('val')
;

pipeline: inital=tuple? (nextPipe | guardedPipe)*
;
guardedPipe: '[' untypedArgumentList PIPE_OPERATOR (guard)* 'else' (elseBody=expression) ']' (':' typeName)?
;
nextPipe: PIPE_OPERATOR name=ID
;

untypedArgumentList: '(' (ID ',')* ID ')'
;
guard: '(' condition=expression ')' body=expression ','
;
tuple: '(' expression ',' (expression ',')* expression? ')'
;

tupleType: '(' (ID ',')*  ID')'
;


value : INT | STRING_ | BOOLEAN;

INT: DEC_INT | HEX_INT | BIN_INT;
DEC_INT: [0-9]+;
HEX_INT: '0x'[0-9A-F]+;
BIN_INT: '0b'[0-1]+;


STRING_: '"' (~'"'|'\\"')* '"';


BOOL_OPERATOR: '==' | '!=' | '>=' | '<=' | '>' | '<'
;

BOOLEAN: 'false' | 'true';


RETURN_OPERATOR: '>>';
PIPE_OPERATOR: '|>';
ASSIGN_OPERATOR: '<|';
END_STATEMENT: ';';
ID: [a-zA-Z_][a-zA-Z0-9]*;
NEWLINE : [\r\n]+ -> skip;
Space: [ \t\r\n]+ -> skip;