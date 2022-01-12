#!/bin/sh
gui="java -cp Expr.jar org.antlr.v4.gui.TestRig Expr start -gui $1"
echo $gui
eval $gui
