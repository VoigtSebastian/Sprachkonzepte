#!/bin/sh

if [ ! -f ./ExprRunner.jar ]; then
    ant
    ant ast
    ant runner
fi

command="java -cp ExprRunner.jar ExprRunner < hello_world.move"

echo $command
eval $command
