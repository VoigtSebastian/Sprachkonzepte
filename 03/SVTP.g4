lexer grammar SVTP;

Functions: Function+;

fragment Function:
	'fn' LETTERS FunctionArguments CURLY_BRACKET_OPEN FunctionBody CURLY_BRACKET_CLOSED;
// Function return values

fragment FunctionBody: (FunctionCall | ValueDefinition)* (
		'return' FunctionCall
		| NUMBER+
		| StringDefinition
	)?;

fragment FunctionCall:
	LETTERS PARENTHESIS_OPEN FunctionArguments PARENTHESIS_CLOSED SEMICOLON;
fragment FunctionArguments:
	PARENTHESIS_OPEN LETTERS (COMMA LETTERS)* PARENTHESIS_CLOSED;

fragment ValueDefinition:
	'val' LETTERS '=' (FunctionCall | NUMBER+ | StringDefinition) SEMICOLON;

// Value definition: Function return values, numbers or strings

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
