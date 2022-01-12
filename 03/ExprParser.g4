parser grammar ExprParser;
// $antlr-format columnLimit 180

options {
	tokenVocab = ExprLexer;
}

start: (settings | move)+ EOF;

settings: sizeDeceleration startingPosition;
move: MOVE (orientation COMMA?)* orientation;

sizeDeceleration: SIZE NUMBER;
startingPosition: START NUMBER NUMBER;

orientation: (up | down | left | right);
up: NUMBER UP;
down: NUMBER DOWN;
left: NUMBER LEFT;
right: NUMBER RIGHT;
