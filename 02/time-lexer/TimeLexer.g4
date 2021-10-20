/*
 TimeLexer: Takes in time in english format (HH:mm am|pm) and the additional format for 12
 midnight|noon and builds tokens from this text.
 */
lexer grammar TimeLexer;

Time: MidnightNoonTime | AmPmTime;

fragment MidnightNoonTime: (TWELVE SPACE MidnightNoon);
fragment AmPmTime: (Hour (COLON Minute)? SPACE TimeOfDay);

fragment MidnightNoon: 'midnight' | 'noon';
fragment TimeOfDay: 'am' | 'pm';
fragment Hour: [01][0-9];
fragment Minute: [0-6] [0-9];

fragment COLON: ':';
fragment SPACE: ' ';
fragment TWELVE: '12';

WS: [ \t\r\n]+ -> channel(HIDDEN);
