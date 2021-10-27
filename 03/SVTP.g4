lexer grammar SVTP;
// $antlr-format columnLimit 180

Functions: Function+;

fragment Function: 'fn' LETTERS FunctionParameters CURLY_BRACKET_OPEN FunctionBody CURLY_BRACKET_CLOSED;
fragment FunctionParameters: PARENTHESIS_OPEN LETTERS (COMMA LETTERS)* PARENTHESIS_CLOSED;

fragment FunctionBody: (FunctionCall | ValueDefinition)* ( 'return' FunctionCall | NUMBER+ | StringDefinition)?;
fragment ValueDefinition: 'val' LETTERS '=' (FunctionCall | NUMBER+ | StringDefinition) SEMICOLON;

fragment FunctionCall: LETTERS PARENTHESIS_OPEN FunctionArguments PARENTHESIS_CLOSED SEMICOLON;
fragment FunctionArguments: PARENTHESIS_OPEN LETTERS (COMMA LETTERS)* PARENTHESIS_CLOSED;

fragment StringDefinition: QUOTATION_MARK .*? QUOTATION_MARK;

fragment NUMBER: [0-9];
fragment LETTERS: [a-zA-Z]+;

fragment COMMA: ',';
fragment SEMICOLON: ',';

fragment QUOTATION_MARK: '"';
fragment CURLY_BRACKET_OPEN: '{';
fragment CURLY_BRACKET_CLOSED: '}';
fragment PARENTHESIS_OPEN: '(';
fragment PARENTHESIS_CLOSED: ')';

WS: [ \t\r\n]+ -> channel(HIDDEN);
