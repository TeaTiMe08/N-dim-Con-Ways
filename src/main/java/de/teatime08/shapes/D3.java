package de.teatime08.shapes;

import de.teatime08.Cell;

import java.util.Set;

import static de.teatime08.shapes.IStringIO.fromString;

public abstract class D3 {

    public static final Set<Cell> GLIDER = fromString(
        "(0, 1, 0), (1, 0, 0), (1, 1, 0), (1, 1, 1), (1, 0, 1)"
    );

    public static final Set<Cell> TUMBLER = fromString(
        "(0, 0, 0), (0, 1, 0), (0, 2, 0), (2, 0, 0), (2, 1, 0), (2, 2, 0),\n" +
            "(4, 0, 0), (4, 1, 0), (4, 2, 0), (1, 1, 1), (3, 1, 1)\n"
    );
 }
