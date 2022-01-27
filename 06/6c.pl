zug(konstanz, 7.0, mainz, 10.59).
zug(konstanz, 08.40, offenburg, 10.59).
zug(konstanz, 08.40, offenburg, 13.00).
zug(konstanz, 08.40, karlsruhe, 11.49).
zug(konstanz, 08.53, singen, 09.26).
zug(singen, 09.37, stuttgart, 11.32).
zug(offenburg, 11.29, mannheim, 12.24).
zug(karlsruhe, 12.08, mainz, 13.47).
zug(stuttgart, 11.51, mannheim, 12.28).
zug(mannheim, 12.39, mainz, 13.18).

verbindung(START, EARLIEST, DESTINATION, LIST) :-
    zug(START, TIME, DESTINATION, ARRIVAL),
    TIME>=EARLIEST,
    append([], [START, TIME, DESTINATION, ARRIVAL], LIST).

verbindung(START, EARLIEST, DESTINATION, LIST) :-
    zug(START, TIME, STOP, STOP_DEPARTURE),
    TIME>=EARLIEST,
    verbindung(STOP, STOP_DEPARTURE, DESTINATION, CURRENT_ROUTE),
    append([START, TIME, STOP, STOP_DEPARTURE], CURRENT_ROUTE, LIST).
