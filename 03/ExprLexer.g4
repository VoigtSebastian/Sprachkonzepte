lexer grammar ExprLexer;
// $antlr-format columnLimit 180

PARENTHESIS_OPEN: '(';
PARENTHESIS_CLOSED: ')';

NUMBER: DIGIT+;
STRING: '"' .*? '"';

IDENTIFIER: LETTER+;

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];

WS: [ \t\r\n]+ -> channel(HIDDEN);
