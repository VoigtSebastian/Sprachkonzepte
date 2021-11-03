lexer grammar SVTPLexer;
// $antlr-format columnLimit 180

FN: 'fn';

COMMA: ',';
SEMICOLON: ';';

QUOTATION_MARK: '"';
CURLY_BRACKET_OPEN: '{';
CURLY_BRACKET_CLOSED: '}';
PARENTHESIS_OPEN: '(';
PARENTHESIS_CLOSED: ')';

VAL: 'val';
ASSIGN: '=';

RETURN: 'return';

NUMBERS: DIGIT+;
STRING: '"' .*? '"';

IDENTIFIER: LETTER*;

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];

WS: [ \t\r\n]+ -> channel(HIDDEN);
