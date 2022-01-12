lexer grammar ExprLexer;
// $antlr-format columnLimit 180

START: 'Start' | 'start';
SIZE: 'Size' | 'size';
MOVE: 'Move' | 'move';

UP: 'up' | 'Up';
DOWN: 'down' | 'Down';
LEFT: 'left' | 'Left';
RIGHT: 'right' | 'Right';

COMMA: ',';
NUMBER: DIGIT+;

fragment DIGIT: [0-9];

WS: [ \t\r\n]+ -> channel(HIDDEN);
