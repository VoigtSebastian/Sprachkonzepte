#!/bin/sh
gui="java -cp SVTP.jar org.antlr.v4.gui.TestRig SVTP expr -gui $1"
echo $gui
eval $gui
