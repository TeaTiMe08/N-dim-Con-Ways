package de.teatime08;

import java.io.Closeable;
import java.util.*;
import java.util.stream.Collectors;

public class dNSimulation extends Game {

    final static Random random = new Random(System.currentTimeMillis());

    static int DIMENSION = 3;
    final static double lowerBoundCellsPerSim = 0.0, upperBoundCellsPerSim = 0.9;
    final static int numberGenerationsCheckedBeforeRegenerate = 150;
    final static int numberCyclesPerRadius = 1000;
    int currentCubeSizeCycle = 0;
    int currentCubeSize = 1;

    public dNSimulation() {
        cells.addAll(generateRandomCellsFor(DIMENSION, currentCubeSize));
    }

    public dNSimulation(int dimension) {
        DIMENSION = dimension;
        cells.addAll(generateRandomCellsFor(DIMENSION, currentCubeSize));
    }

    @Override
    public void handleNextGerationFinished(boolean shapeDetected) {
        // intercept if a shape was detected
        boolean nextSim = shapeDetected;
        // intercept if simulation times are met
        nextSim = nextSim || generation >= numberGenerationsCheckedBeforeRegenerate;
        // intercept if all died
        nextSim = nextSim || cells.isEmpty();
        // intercept if shape grows out of hand
        nextSim = nextSim || cells.stream().anyMatch(
            cell -> Arrays.stream(cell.getPosition()).anyMatch(x -> x > 10 * currentCubeSize + 1)
        );

        if (nextSim) {
            if (currentCubeSizeCycle >= numberCyclesPerRadius) {
                currentCubeSize++;
                currentCubeSizeCycle = 0;
            }
            clear();
            cells.addAll(generateRandomCellsFor(DIMENSION, currentCubeSize));
            currentCubeSizeCycle++;
        }
    }

    public static Set<Cell> generateRandomCellsFor(int dimension, int radius) {
        Set<Cell> out = new HashSet<>();
        int range = Math.max(1, (int)rangeOfCellsToCreate(dimension, radius));
        for (int i = 0; i < range; i++) {
            Cell rdC = randomCell(dimension, radius);
            while (out.contains(rdC))
                rdC = randomCell(dimension, radius);
            out.add(rdC);
        }
        return out;
    }

    public static double rangeOfCellsToCreate(int dimension, int radius) {
        double total = Math.pow(1 + (2 * radius), dimension);
        try {
            return new Random().nextDouble(lowerBoundCellsPerSim * total, upperBoundCellsPerSim * total);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return 0;
        }
    }

    public static Cell randomCell(int dimension, int radius) {
        int[] pos = new int[dimension];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = random.nextInt( -radius, radius + 1);
        }
        return new Cell(pos);
    }

    @Override
    public void close() {
        System.out.println("All found shapes:");
        shapesDetector.getFoundShapes().stream()
            // collect cells by dimension they in
            .collect(Collectors.groupingBy(this::getShapeDimension))
            .forEach( (dimension, setsUnderDimension) -> {
                System.out.println("DIM " + dimension + " #########################");
                // print all sets under the dimension header
                setsUnderDimension.stream()
                    .map(Game::cellsToString)
                    .sorted(Comparator.comparingInt(String::length))
                    .forEach(System.out::println);
            });
        super.close();
    }

    private int getShapeDimension(Set<Cell> cells) {
        Cell cell = cells.stream().findFirst().get();
        int dim = 0;
        for (int i = 0; i < cell.position.length; i++) {
            final int pos = i;
            if (cells.stream().anyMatch(other -> cell.position[pos] != other.position[pos]))
                dim++;
        }
        return dim;
    }
}
