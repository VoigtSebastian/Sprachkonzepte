zug(konstanz, 08.40, karlsruhe, 11.49).
zug(karlsruhe, 12.08, mainz, 13.47).

% Check if a connection from START to DESTINATION exists, that starts after ERLIEST
% Append to LIST if the predicate above is true
verbindung(START,EARLIEST,DESTINATION,LIST):-
    zug(START, TIME, DESTINATION, ARRIVAL),
    TIME>=EARLIEST,
    CONNECTION=[START, TIME, DESTINATION, ARRIVAL],
    append(CONNECTION, [], LIST).

% Check if there is a connection from START to somewhere, which satisfies the predicate above
% Check if there is a connection from somewhere to DESTINATION
verbindung(START,EARLIEST,DESTINATION,LIST):-
    verbindung(START, EARLIEST, X, LIST),
    verbindung(X, EARLIEST, DESTINATION, LIST).

