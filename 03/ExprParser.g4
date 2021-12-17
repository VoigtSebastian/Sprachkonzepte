parser grammar ExprParser;
// $antlr-format columnLimit 180

options {
	tokenVocab = ExprLexer;
}

start: expr EOF;

expr: functionDefinition*;

functionDefinition:
	PARENTHESIS_OPEN DEF IDENTIFIER BRACKET_OPEN functionArgument* BRACKET_CLOSED functionCall PARENTHESIS_CLOSED;
functionArgument: IDENTIFIER;

functionCall: PARENTHESIS_OPEN IDENTIFIER (functionCall | number | string | identifierAsArgument)* PARENTHESIS_CLOSED;
identifierAsArgument: IDENTIFIER;

number: NUMBER;
string: STRING;
