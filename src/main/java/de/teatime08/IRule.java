package de.teatime08;

import java.util.Map;

public interface IRule {

    enum Action {
        ENLIVE,
        KEEP,
        KILL
    }

    public record Result (Cell livingCell, Action action){ }

    public Map<Cell, Action> apply(Game game);
}
