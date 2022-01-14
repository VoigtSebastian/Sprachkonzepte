/* Aufgabe 6b Summe aus liste: */
sum([],0).
sum([ADD|TODO],RES):- sum(TODO,RES2) ,RES is RES2 + ADD.


/*
Ausführung:
sum([2,3], X)
	sum(X=2|Y=[3], RES)
		-> Call sum(Y=[3], RES2)
			sum(X=3|Y=[], RES)
				-> Call sum(Y=[], RES2)
					sum([],0)	
				-> Exit sum(Y=[], RES2=0)
			RES is 0+3
			sum(X=3|Y=[], RES=3)
		-> Exit sum(Y=[3], RES2=3)
	RES is 3+2
	sum(X=2|Y=[3]], RES=5)
X=5
*/