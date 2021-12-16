parser grammar ExprParser;
// $antlr-format columnLimit 180

options {
	tokenVocab = ExprLexer;
}

start: expr EOF;

expr: functionCall*;

functionCall: PARENTHESIS_OPEN IDENTIFIER (functionCall | number | string)* PARENTHESIS_CLOSED;

number: NUMBER;
string: STRING;
