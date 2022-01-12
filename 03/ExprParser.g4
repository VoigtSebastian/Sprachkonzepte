parser grammar ExprParser;
// $antlr-format columnLimit 180

options {
	tokenVocab = ExprLexer;
}

start: (settings | move)+ EOF;

settings: sizeDecleration startingPosition;
move: MOVE (orientation COMMA)* orientation;

sizeDecleration: SIZE NUMBER;
startingPosition: START NUMBER COMMA NUMBER;

orientation: (up | down | left | right);
up: NUMBER UP;
down: NUMBER DOWN;
left: NUMBER LEFT;
right: NUMBER RIGHT;
