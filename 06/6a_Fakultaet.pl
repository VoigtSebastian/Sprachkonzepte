/* Aufgabe S26 Eck-Prolog Fakultät Berechnung: */
fak(0, 1). 
fak(X, Y):- X > 0, X1 is X - 1, fak(X1, Y1), Y is X * Y1.

