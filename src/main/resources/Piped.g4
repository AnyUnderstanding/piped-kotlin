grammar Piped;

program: import_* (bundleDefinition | pipeDefinition)+;

bundleDefinition: 'bundle' ID '{'
 (VARIABLE_NAME typedName ',')*
 (VARIABLE_NAME typedName)?
'}';

import_: '>>' (ID '.')* ID END_STATEMENT;

pipeDefinition: 'pi' name=ID argumentsDefinitionList ':' type=ID scope;

scope : '{' ((assign | expr | return) END_STATEMENT)* '}';

argumentsDefinitionList: '('(typedName ',')* typedName? ')';

expr:
	 left=expr op=ADD_SUB_OPERATOR right=expr
    | left=expr op=MUL_DIV_OPERATOR right=expr
    | left=expr op=BOOL_OPERATOR right=expr
    | pipeline
    | tuple
    | scope
    | value
    | var
    | '(' expr ')'
    ;

pipeline: ((pipelineTuple | ID) guardedPipe? PIPE_OPERATOR)* ( pipelineTuple | (ID guardedPipe?) );
pipelineTuple: '(' ((expr | '#'DEC_INT) ',')* (expr | '#'DEC_INT)? ')';
guardedPipe: '[' untypedArgumentList PIPE_OPERATOR (guard)* elseGuard ']';

tuple: '(' (expr ',')* expr? ')';
guard: '(' condition=expr')' body=expr ',';
untypedArgumentList: '(' (ID ',')* ID ')';
elseGuard: 'else' body=expr;




var : ID ('.' ID)*;



assign: VARIABLE_NAME ID ASSIGN_OPERATOR expr;
return : RETURN_OPERATOR expr;

value : int | STRING_ | BOOLEAN;
typedName: name=ID ':' type=ID;

int: DEC_INT | HEX_INT | BIN_INT;
DEC_INT: [0-9]+;
HEX_INT: '0x'[0-9A-F]+;
BIN_INT: '0b'[0-1]+;


STRING_: '"' (~'"'|'\\"')* '"';


BOOL_OPERATOR: '==' | '!=' | '>=' | '<=' | '>' | '<';
ADD_SUB_OPERATOR: '+' | '-';
MUL_DIV_OPERATOR: '*' | '/';

BOOLEAN: 'false' | 'true';

VARIABLE_NAME: 'let';
RETURN_OPERATOR: '>>';
PIPE_OPERATOR: '|>';
ASSIGN_OPERATOR: '=';
END_STATEMENT: ';';
ID: [a-zA-Z_][a-zA-Z0-9]*;
NEWLINE : [\r\n]+ -> skip;
Space: [ \t\r\n]+ -> skip;