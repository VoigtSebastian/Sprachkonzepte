#!/bin/sh

if [ ! -f ./ExprToAst.jar ]; then
    ant
    ant ast
fi

command="java -cp ExprToAst.jar ExprToAst < HelloWorld.svtp"

echo $command
eval $command
