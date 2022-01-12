#!/bin/sh

if [ ! -f ./ExprToAst.jar ]; then
    ant
    ant ast
fi

command="java -cp ExprToAst.jar ExprToAst < hello_world.move"

echo $command
eval $command
