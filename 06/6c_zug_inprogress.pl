/*Vorgegebene Verbindungen*/
zug(konstanz, 08.40, offenburg, 10.59).
zug(konstanz, 08.40, karlsruhe, 11.49).
zug(konstanz, 08.53, singen, 09.26).
zug(singen, 09.37, stuttgart, 11.32).
zug(offenburg, 11.29, mannheim, 12.24).
zug(karlsruhe, 12.08, mainz, 13.47).
zug(stuttgart, 11.51, mannheim, 12.28).
zug(mannheim, 12.39, mainz, 13.18).

/* Test Verbindung aufgrund doppelt */
zug(singen, 12.30, mainz, 14.47).



verbindung(ABORT,ABZEIT,ANORT,LIST):-
    zug(ABORT,ZABZEIT, USTORT, USTZEIT),
    ABZEIT < ZABZEIT,
    zug(USTORT,ZUSTZEIT, ANORT, ANZEIT),
    ZUSTZEIT>=USTZEIT,
    VB = [ABORT, ZABZEIT, ANORT, ANZEIT],
    %not(member(VB, LIST)),
    %append(VB, LIST, LIST).
    LIST=[VB|LIST].
