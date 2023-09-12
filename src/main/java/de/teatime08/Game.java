package de.teatime08;

import de.teatime08.configuration.ConwaysConfiguration;
import de.teatime08.configuration.IConfiguration;

import java.io.Closeable;
import java.util.*;
import java.util.stream.Collectors;

public class Game implements Closeable, Banq {

    IConfiguration configuration = new ConwaysConfiguration();
    protected final Set<Cell> initial = new HashSet<>();
    protected final Set<Cell> cells = new HashSet<>();
    protected int generation = 0;
    protected int totalGenerations = 0;

    public final ShapesDetector shapesDetector;

    public Game() {
        shapesDetector = new ShapesDetector();
    }

    public Game(Set<Cell> initial) {
        this.initial.addAll(initial);
        generation = 0;
        cells.addAll(initial);
        shapesDetector = new ShapesDetector();
    }

    public Game decorateShape(Set<Cell> additive) {
        initial.addAll(additive);
        generation = 0;
        cells.addAll(additive);
        return this;
    }

    public void next() {
        long banqT = System.nanoTime();
        final Map<Cell, IRule.Action> allRules = new HashMap<>();
        for (IRule rule : configuration.rules()) {
            allRules.putAll(rule.apply(this));
        }
        banq("next-applyRules", System.nanoTime() - banqT);
        cells.clear();
        allRules.forEach((cell, action) -> {
            if (action == IRule.Action.KILL) {
                // Do nothing
            } else if (action == IRule.Action.ENLIVE) {
                cells.add(cell);
            } else if (action == IRule.Action.KEEP) {
                // age cell by 1
                cells.add(cell);
            }
        });
        boolean shapeDetected = false;
        if (generation > 0) {
            banqT = System.nanoTime();
            shapeDetected = shapesDetector.nextGenFinished(cells);
            banq("next-nextGenFinished", System.nanoTime() - banqT);
        }
        banqT = System.nanoTime();
        handleNextGerationFinished(shapeDetected);
        banq("next-handleGenerationFinished", System.nanoTime() - banqT);
        generation++;
        totalGenerations++;
    }

    public void clear() {
        cells.clear();
        initial.clear();
        shapesDetector.past.clear();
        generation = 0;
    }

    public Set<Cell> getCells() {
        return Collections.unmodifiableSet(new HashSet<>(cells));
    }

    public void reInitWithCells(Set<Cell> cells) {
        cells.addAll(cells);
        initial.addAll(cells);
        generation = 0;
    }

    public int getGeneration() {
        return generation;
    }

    public void handleNextGerationFinished(boolean shapeDetected) {};

    public int getDimension() {
        if (cells == null || cells.isEmpty())
            return 0;
        return cells.stream().findFirst().get().position.length;
    }

    public static Set<Cell> getAllPointsOnBoard(Set<Cell> cells) {
        int[][] estBS = calculateMinMaxVector(cells);
        return spanAllPossiblePoints(estBS[0], estBS[1]);
    }

    public static Set<Cell> spanAllPossiblePoints(int[] smallest, int[] largest) {
        Set<Cell> points = new HashSet<>();
        generatePointsRecursive(smallest, largest, new int[smallest.length], 0, points);
        return points;
    }

    private static void generatePointsRecursive(int[] smallest, int[] largest, int[] current, int dimension, Set<Cell> points) {
        if (dimension == smallest.length) {
            points.add(new Cell(current.clone()));
            return;
        }

        for (int i = smallest[dimension]; i <= largest[dimension]; i++) {
            current[dimension] = i;
            generatePointsRecursive(smallest, largest, current, dimension + 1, points);
        }
    }

    public static int[] calculateMinMaxSize(Set<Cell> cells) {
        if (cells == null || cells.isEmpty())
            return new int[]{};
        int[] size = new int[cells.stream().findFirst().get().position.length];
        for (int i = 0; i < size.length; i++) {
            final int pos = i;
            size[i] = cells.stream().mapToInt(x -> x.position[pos]).max().getAsInt()
                        - cells.stream().mapToInt(x -> x.position[pos]).min().getAsInt();
        }
        return size;
    }

    public static int[][] calculateMinMaxVector(Set<Cell> cells) {
        if (cells == null || cells.isEmpty())
            return new int[][] {{0}};
        int[][] minMaxVec = new int[2][cells.stream().findFirst().get().position.length];
        for (int i = 0; i < minMaxVec[0].length; i++) {
            final int pos = i;
            minMaxVec[0][i] = cells.stream().mapToInt(x -> x.position[pos]).min().getAsInt() - 2;
            minMaxVec[1][i] = cells.stream().mapToInt(x -> x.position[pos]).max().getAsInt() + 2;
        }
        return minMaxVec;
    }

    public Set<Cell> getNeighboursForExactDistance(Cell cell, int distance) {
        return cells.stream().parallel()
            .filter(x -> cell.isNeighbourOfWithExactDistance(x, distance))
            .collect(Collectors.toSet());
    }

    public void print() {
        if (getDimension() == 2)  {
            int[][] boardSize = calculateMinMaxVector(cells);
            int[] from = boardSize[0], to = boardSize[1];
            int xSize = Math.abs(from[0]) + Math.abs(to[0]) + 1;// add zero
            int ySize = Math.abs(from[1]) + Math.abs(to[1]) + 1;// add zero
            int xOffset = Math.abs(from[0]);
            int yOffset = Math.abs(from[1]);
            char[][] board = new char[xSize][ySize];
            for (char[] chars : board) Arrays.fill(chars, '.');
            for (Cell c : cells) {
                board[c.position[0] + xOffset][c.position[1] + yOffset] = '#';
            }
            for (char[] chars : board) System.out.println(new String(chars));
        }
    }

    public static String cellsToString(Set<Cell> cells) {
        return cells.stream().map( x -> Arrays.toString(x.getPosition())).collect(Collectors.joining(", "));
    }

    @Override
    public void close() {
        System.out.println("Total gens:" + totalGenerations);
        printMedians();
    }
}
