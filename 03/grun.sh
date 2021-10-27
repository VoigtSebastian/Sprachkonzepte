#!/bin/sh
#c="java -cp Time.jar org.antlr.v4.gui.TestRig Time tokens -tokens $1 > ${1%.*}-tokens.txt"
c="java -cp SVTP.jar org.antlr.v4.gui.TestRig SVTP tokens -tokens $1"
echo $c
eval $c
