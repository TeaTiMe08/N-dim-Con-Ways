package de.teatime08.configuration;

import de.teatime08.Banq;
import de.teatime08.Cell;
import de.teatime08.Game;
import de.teatime08.IRule;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConwaysConfiguration extends IConfiguration implements Banq {
    @Override
    public Set<IRule> rules() {
        Set<Cell> enlivenAlreadyChecked = new HashSet<>();
        IRule conwaysRule = new IRule() {
            @Override
            public Map<Cell, Action> apply(Game game) {
                Map<Cell, Action> allActions = new HashMap<>();
                // map reduce and parallel for about x3 speedup.
                game.getCells().parallelStream().forEach(cell -> {
                    long banqT = System.nanoTime();
                    Set<Cell> neighbours = cell.pointsOfHyperSphere(1);
                    // first check myself for live
                    // all surrounding cells contained in game
                    long numberNeighbours = neighbours.stream().filter(x -> game.getCells().contains(x)).count();

                    // all real neighbours
                    synchronized (allActions) {
                        if (numberNeighbours < 2)
                            allActions.put(cell, IRule.Action.KILL);
                        else if (numberNeighbours == 2 || numberNeighbours == 3)
                            allActions.put(cell, IRule.Action.KEEP);
                        else
                            allActions.put(cell, IRule.Action.KILL);
                    }

                    // generate new potential neighbours for enliven
                    banqT = System.nanoTime();
                    Set<Cell> potentials = neighbours.stream()
                        .filter(x -> ! game.getCells().contains(x))
                        .filter(x -> ! enlivenAlreadyChecked.contains(x))
                        .collect(Collectors.toSet());
                    banq("rule-filterForNeightbours", System.nanoTime() - banqT);
                    // check neighbours for enliven
                    banqT = System.nanoTime();
                    potentials.forEach(neighbour -> {
                        //TODO optimize, when measuring distance to all (#other_cells < coorHyperShpere -> distance to all other cells)
                        long numberNeighbourNeighbours = neighbour.pointsOfHyperSphere(1).stream()
                            .filter(x -> game.getCells().contains(x))
                            .count();
                        if (numberNeighbourNeighbours == 3)
                            allActions.put(neighbour, IRule.Action.ENLIVE);
                    });
                    synchronized (enlivenAlreadyChecked) {
                        enlivenAlreadyChecked.addAll(potentials);
                    }
                    banq("rule-checkEnliven", System.nanoTime() - banqT);
                    // reduce all collected List of Maps to one large Map
                });
                return allActions;

                /*
                long banqT = System.nanoTime();
                Stream<Map.Entry<Cell, IRule.Action>> stream1 = stream.flatMap(map -> map.entrySet().stream());
                banq("rule-flatMap", System.nanoTime() - banqT);

                banqT = System.nanoTime();
                Map out = stream1.collect(Collectors.toMap(
                        x -> x.getKey(),
                        x -> x.getValue(),
                        (existingValue, newValue) -> newValue // Merge function for handling duplicates
                    ));
                banq("rule-collect", System.nanoTime() - banqT);

                return out;
                */
            }
        };
        return new HashSet<>(){{add(conwaysRule);}};
    }
}
