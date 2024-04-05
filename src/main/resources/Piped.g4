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



pipeDefinition: 'pi' ID '(' argumentsDefinition ')'  localScope
;

argumentsDefinition: ((typedName ',')* typedName)?
;

bundleDefinition: 'Bundle' ID '{'
 (ValueDefinition typedName ',')*
 (ValueDefinition typedName)?
 '}'
;

typedName: ID ':' ID
;

return: RETURN_OPERATOR expression
;
assign: ValueDefinition? typedName ASSIGN_OPERATOR expression
;
expression: pipeLine # PIPELINE
    | expression BOOL_OPERATOR expression # BOOL_OP
	| expression ('*'|'/') expression # MulDiv
    | expression ('+'|'-') expression # AddSub
    | value # Value_
    | ID # Variable
    | '(' expression ')' # Parens
    ;

ValueDefinition: ('val' | 'var')
;

pipeLine: argumentList (PIPE_OPERATOR nextPipe | guardedPipe (PIPE_OPERATOR nextPipe)?)? | nextPipe
;
nextPipe: (ID (':' ID)?) (PIPE_OPERATOR nextPipe | guardedPipe (PIPE_OPERATOR nextPipe)?)?
;
guardedPipe: '[' '('argumentsDefinition')' PIPE_OPERATOR ('(' expression ')' (expression| localScope) ',')* '(' expression ')' (expression | localScope) ','? ']' (':' ID)?
;

argumentList: '(' (expression ',')* expression ')'
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