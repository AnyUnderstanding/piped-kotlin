grammar Piped;

program: import_* (bundleDefinition | pipeDefinition)+;

bundleDefinition: 'bundle' name=ID '{'
 (VARIABLE_NAME typedName ',')*
 (VARIABLE_NAME typedName)?
'}';

import_: '>>' (ID '.')* ID END_STATEMENT;

pipeDefinition: 'pi' name=ID argumentsDefinitionList ':' type scope;

scope : '{' (statement END_STATEMENT)* '}';
statement: assign | expr | return;

argumentsDefinitionList: '('(typedName ',')* typedName? ')';

expr:
    left=expr op=BOOL_OPERATOR right=expr #boolOp
    | left=expr op=MUL_DIV_OPERATOR right=expr #mulDivOp
    | left=expr op=ADD_SUB_OPERATOR right=expr #addSubOp
    | scope # pass6
    | value # pass5
    | var # pass4
    | '(' expr ')' # parenthesis
    | tuple # pass3
    | bundleInit # pass2
    | pipeline # pass1
    ;

// TODO:
// a single pipeline element is indistinguishable from a variable
// 1. Possible solutions -> Require '|>' before single pipeline elements
// 2. Don't allow Pipes to have the same name as Variables
pipeline: (pipelineElement PIPE_OPERATOR)+ (pipelineElement);
pipelineElement: pipelineTuple | ID guardedPipe?;
pipelineTuple: '(' ((expr | placeholder) ',')* (expr | placeholder)? ')';
placeholder: '#'DEC_INT;
guardedPipe: '[' args=untypedArgumentList PIPE_OPERATOR (guard)* elseGuard ']';

tuple: '(' (expr ',')* expr? ')';
guard: '(' condition=expr')' body=expr ',';
untypedArgumentList: '(' (ID ',')* ID ')';
elseGuard: 'else' body=expr;


bundleInit: name=ID args='(' (expr ',')* expr? ')';

var : ID ('.' ID)*;



assign: VARIABLE_NAME typedName ASSIGN_OPERATOR expr;
return : RETURN_OPERATOR expr;

value : int | STRING_ | BOOLEAN;
typedName: name=ID ':' type;
type: ID | tupleType;
tupleType: '(' (type ',')* type? ')';

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
COMMENT: '//' ~[\r\n]* -> skip;