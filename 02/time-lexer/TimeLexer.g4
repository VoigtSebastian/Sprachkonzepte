lexer grammar TimeLexer;

Number: Hour ':' Minute;

fragment Hour: ('2' [0-3]) | ([01][0-9]);
fragment Minute: [1-6]? [0-9];

WS: [ \t\r\n]+ -> channel(HIDDEN);
