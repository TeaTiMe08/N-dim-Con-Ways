package de.teatime08;

import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ShapesDetector implements Banq {

    static final int maxSizePastMemory = 1000;
    LinkedList<Set<Cell>> past = new LinkedList<>();

    final Set<Set<Cell>> foundShapes = new HashSet<>();

    final Set<Graph<Integer, DefaultEdge>> foundGraphs = new HashSet<>();

    boolean nextGenFinished(Set<Cell> cells) {
        if (cells == null || cells.isEmpty())
            return false;
        if (past.isEmpty()) {
            past.add(new HashSet<>(cells));
            return false;
        } else {
            long banqT = System.nanoTime();
            if (past.size() > maxSizePastMemory)
                past.pop();
            past.stream().filter(cells::equals).findFirst().ifPresent( x -> {
                handleShapeDetected(x);
            });
            past.add(new HashSet<>(cells));
            banq("nextGenFinished", System.nanoTime() - banqT);
            return true;
        }
    }

    private void handleShapeDetected(Set<Cell> detectedShape) {
        if (detectedShape == null || detectedShape.isEmpty())
            return;
        Thread thread = new Thread(() -> {
            long banqT = System.nanoTime();
            Set<Set<Cell>> computeUnits = splitIntoComputeUnits(detectedShape);
            banq("splitComputeUnits", System.nanoTime() - banqT);

            // create graphs and make a Map for all Cells graphs
            //todo optimize instead of check in n graphs we can check only sqrt(n) graphs
            banqT = System.nanoTime();
            Map<SimpleGraph<Integer, DefaultEdge>, Set<Cell>> detectedGraphs = computeUnits.parallelStream()
                .map(ShapesDetector::createGraph)
                .collect(Collectors.toMap(
                    x -> x.graph,
                    y -> y.shape,
                    (existingValue, newValue) -> newValue // Handle collisions if keys are duplicated
                ));
            banq("createGraph", System.nanoTime() - banqT);
            // skip first and assign
            if (foundGraphs.isEmpty()) {
                foundShapes.addAll(computeUnits);
                foundGraphs.addAll(detectedGraphs.keySet());
            }
            // check if isomorphic graphs were found, add the rest.
            else {
                banqT = System.nanoTime();
                Map<SimpleGraph<Integer, DefaultEdge>, Set<Cell>> newGraphs  = detectedGraphs.keySet().parallelStream()
                    .filter(graph -> foundGraphs.stream().noneMatch( other -> isIsomorphic(graph, other)))
                    .collect(Collectors.toMap(
                        x -> x,
                        detectedGraphs::get,
                        (existingValue, newValue) -> newValue // Handle collisions if keys are duplicated
                    ));
                foundShapes.addAll(newGraphs.values());
                foundGraphs.addAll(newGraphs.keySet());
                banq("isomorphic", System.nanoTime() - banqT);
            }
        });
        thread.start();
    }

    private static Set<Set<Cell>> splitIntoComputeUnits(Set<Cell> cells) {
        int dim = cells.stream().findFirst().get().getPosition().length;
        final Set<Set<Cell>> splits = new HashSet<>();
        cells.stream().forEach(cell -> {
            Set<Set<Cell>> alreadyFound = splits.parallelStream().filter(set -> set.contains(cell)).collect(Collectors.toSet());
            Set<Cell> singleNeighbours = cells.parallelStream()
                .filter(cellfilter -> cell.calculateManhattanDistanceTo(cellfilter) <= dim) //todo why dim not dim-1
                .collect(Collectors.toSet());
            if (alreadyFound.isEmpty()) {
                singleNeighbours.add(cell);
                splits.add(singleNeighbours);
            } else {
                if (alreadyFound.size() > 1) {
                    splits.removeAll(alreadyFound);
                    Set<Cell> flatMapCombined = alreadyFound.parallelStream().flatMap(Set::stream).collect(Collectors.toSet());
                    flatMapCombined.addAll(singleNeighbours);
                    splits.add(flatMapCombined);
                }
                alreadyFound.stream().findFirst().get().addAll(
                    singleNeighbours
                );
            }
        });
        return splits;
    }

    public static ShapeGraphWrapper createGraph(Set<Cell> shape) {
        SimpleGraph<Integer, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Assign a unique vertex for each vector
        int vertexIndex = 0;
        for (Cell cell : shape) {
            int vertex = cell.hashCode();
            graph.addVertex(vertex);
            vertexIndex++;
        }

        // Connect vertices (edges) to represent relationships between vectors
        for (Cell cell : shape) {
            int vertex1 = cell.hashCode();
            for (Cell other : shape) {
                int vertex2 = other.hashCode();
                if (!cell.equals(other)) {
                    graph.addEdge(vertex1, vertex2);
                }
            }
        }
        return new ShapeGraphWrapper(shape, graph);
    }

    private record ShapeGraphWrapper(Set<Cell> shape, SimpleGraph<Integer, DefaultEdge> graph){};

    // Check if two graphs are isomorphic
    public static boolean isIsomorphic(Graph<Integer, DefaultEdge> graph1, Graph<Integer, DefaultEdge> graph2) {
        VF2GraphIsomorphismInspector<Integer, DefaultEdge> inspector =
            new VF2GraphIsomorphismInspector<>(graph1, graph2);
        return inspector.isomorphismExists();
    }

    public Set<Set<Cell>> getFoundShapes() {
        return Collections.unmodifiableSet(foundShapes);
    }
}
