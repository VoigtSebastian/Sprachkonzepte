/*
 TimeLexer: Takes in time in english format (HH:mm am|pm) and the additional format for 12
 midnight|noon and builds tokens from this text.
 */
lexer grammar TimeLexer;

// Uses lazy evaluation to skip some exclusion
Time: (TWELVE SPACE MidnightNoon)
	| (Hour (COLON Minute)? SPACE TimeOfDay);

fragment COLON: ':';
fragment SPACE: ' ';
fragment TWELVE: '12';
fragment MidnightNoon: 'midnight' | 'noon';
fragment TimeOfDay: 'am' | 'pm';
fragment Hour: [01][0-9];
fragment Minute: [1-6]? [0-9];

WS: [ \t\r\n]+ -> channel(HIDDEN);
