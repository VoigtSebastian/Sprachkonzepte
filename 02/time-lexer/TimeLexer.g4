lexer grammar TimeLexer;

Number: Hour ':' Minute ' ' TimeOfDay;

fragment TimeOfDay: 'am' | 'pm';
fragment Hour: [01][0-9];
fragment Minute: [1-6]? [0-9];

WS: [ \t\r\n]+ -> channel(HIDDEN);
