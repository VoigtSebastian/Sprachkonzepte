parser grammar SVTPParser;
// $antlr-format columnLimit 180

options {
	tokenVocab = SVTPLexer;
}

start: expr EOF;

expr: function function*;

function: functionIdentifier functionBody;
functionIdentifier: FN IDENTIFIER PARENTHESIS_OPEN functionArguments PARENTHESIS_CLOSED;
functionBody: CURLY_BRACKET_OPEN (assignValue | functionCall)* returnValue? CURLY_BRACKET_CLOSED;

assignValue: VAL IDENTIFIER ASSIGN (functionCall | STRING | NUMBERS | IDENTIFIER) SEMICOLON;
returnValue: RETURN (functionCall | STRING | NUMBERS | IDENTIFIER) SEMICOLON;

functionCall: IDENTIFIER PARENTHESIS_OPEN functionArguments PARENTHESIS_CLOSED SEMICOLON;

functionArguments: (IDENTIFIER (COMMA IDENTIFIER)*)?;
