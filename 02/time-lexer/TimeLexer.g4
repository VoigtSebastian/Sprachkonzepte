lexer grammar TimeLexer;

// Uses lazy evaluation to skip some exclusion
Time: (Twelv Space MidnightNoon)
	| (Hour (Colon Minute)? Space TimeOfDay);

fragment Colon: ':';
fragment Space: ' ';
fragment Twelv: '12';
fragment MidnightNoon: 'midnight' | 'noon';
fragment TimeOfDay: 'am' | 'pm';
fragment Hour: [01][0-9];
fragment Minute: [1-6]? [0-9];

WS: [ \t\r\n]+ -> channel(HIDDEN);
