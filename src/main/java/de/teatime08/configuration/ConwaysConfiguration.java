package de.teatime08.configuration;

import de.teatime08.Cell;
import de.teatime08.IRule;

import java.util.*;
import java.util.stream.Collectors;

public class ConwaysConfiguration extends IConfiguration {
    @Override
    public Set<IRule> rules() {
        return new HashSet<>() {{
            add(game -> {
                // map reduce and parallel for about x3 speedup.
                Map out = game.getCells().parallelStream().map(cell -> {
                        final Map<Cell, IRule.Action> k = new HashMap<>();
                        Set<Cell> neighbours = cell.pointsOfHyperSphere(1);
                        // first check myself for live
                        // all surrounding cells
                        long numberNeighbours = neighbours.size();
                        // filter for non-neighbours
                        Set<Cell> potentials = neighbours.stream()
                            .filter(x -> ! game.getCells().contains(x))
                            .collect(Collectors.toSet());
                        // all real neighbours
                        numberNeighbours = numberNeighbours - potentials.size();
                        if (numberNeighbours < 2)
                            k.put(cell, IRule.Action.KILL);
                        else if (numberNeighbours == 2 || numberNeighbours == 3)
                            k.put(cell, IRule.Action.KEEP);
                        else
                            k.put(cell, IRule.Action.KILL);
                        // check neighbours for enliven
                        potentials.forEach(neighbour -> {
                            //TODO optimize, when measuring distance to all (#other_cells < coorHyperShpere -> distance to all other cells)
                            long numberNeighbourNeighbours = neighbour.coordinatesOfHyperSphere(1).stream()
                                .filter(x -> game.getCells().contains(x))
                                .count();
                            if (numberNeighbourNeighbours == 3)
                                k.put(neighbour, IRule.Action.ENLIVE);
                        });
                        return k;
                        // reduce all collected List of Maps to one large Map
                    })
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(
                        x -> x.getKey(),
                        x -> x.getValue(),
                        (existingValue, newValue) -> newValue // Merge function for handling duplicates
                    ));
                    /*
                    .reduce((allMapsCombined, collectedMap) -> {
                    allMapsCombined.putAll(collectedMap);
                    return allMapsCombined;
                     */
                return out;
            });
        }};
    }
}
