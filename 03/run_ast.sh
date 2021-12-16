#!/bin/sh

if [ ! -f ./ExprToAst.jar ]; then
    ant
    ant ast
fi

command="java -cp ExprToAst.jar ExprToAst < example_hello-world.notLisp"

echo $command
eval $command
