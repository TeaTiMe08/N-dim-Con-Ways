package de.teatime08;

import java.io.Closeable;
import java.util.*;
import java.util.stream.Collectors;

public class dNSimulation extends Game {
    final static Random random = new Random(System.currentTimeMillis());

    static int DIMENSION = 3;
    final static double lowerBoundCellsPerSim = 0.0, upperBoundCellsPerSim = 0.9;
    final static int numberGenerationsCheckedBeforeRegenerate = 150000;
    final static int numberCyclesPerRadius = 1000;
    int currentCubeSizeCycle = 0;
    int currentCubeSize = 3;

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
            cells.addAll(generateRandomDimReflection(DIMENSION, currentCubeSize));
            currentCubeSizeCycle++;
        }
    }

    /**
     * This does awesome stuff.
     * Generates new cells in mirrored pattern so that:
     * 1. Depending on the dimension we pick a ranum number of reflectiveness == #axes_of_reflection_or_mirroring
     * 2. Creates random cells in this sector
     * 3. Mirrors/Reflects/Copies_by_axis this sector over to the others and creates a mirrored shape of random cells.
     * @param dimension the dimension in which the cells should be created
     * @param radius the radius ot maximum negative ir positive value the cell can have
     * @return a new set of cells wich is reflected.
     */
    public Set<Cell> generateRandomDimReflection(int dimension, int radius) {
        long banqt = System.nanoTime();
        // random number of possible reflected axes in dimension space
        int randomReflectionDimension = new Random().nextInt(0, dimension + 1);
        // create quadrant reflection for all reflected == random cell in any quadrant
        boolean[] isReflectedQuadrant = new boolean[dimension];
        Arrays.fill(isReflectedQuadrant, true);
        // set the number of random reflections
        for (int i = 0; i < randomReflectionDimension; i++) {
            isReflectedQuadrant[i] = true; // only positive radius for this dimension
        }
        int range = Math.max(1, (int)rangeOfCellsToCreate(dimension, radius));
        // range is the number of cells to create, depending on the number of non-reflected dimensions
        // the number should be lowered, bc those will be mirrored afterwards.
        if (range <= 0)
            range = (int)Math.floor(range / Math.pow(2, randomReflectionDimension));
        else
            range = (int)Math.ceil(range / Math.pow(2, randomReflectionDimension));
        Set<Cell> out = new HashSet<>();
        for (int i = 0; i < range; i++) {
            Cell rdCinQ = randomCell(dimension, radius);
            // generate exact number given by random, duplicates would be eased by the HashMap.
            while (out.contains(rdCinQ))
                rdCinQ = randomCell(dimension, radius); //TODO can get stuck here if parameters set wrong...
            out.add(rdCinQ);
        }
        // mirror for each random picked axes, to create Math.pow(#cells_in_'out', randomReflectionDimension) cells in total.
        for (int i = 0; i < randomReflectionDimension; i++) {
            final int pos = i;
            HashSet<Cell> mirrored = new HashSet<>();
            out.forEach(cell -> {
                Cell copyThroughMirror = new Cell(Arrays.copyOf(cell.position, cell.position.length));
                // mirror the current dimension of the cell
                copyThroughMirror.position[pos] = - copyThroughMirror.position[pos];
                mirrored.add(copyThroughMirror);
            });
            // add all mirrored cells for this axes and repeat for (if any) other axes, until all are mirrored.
            out.addAll(mirrored);
        }
        banq("generateRandomDimReflection", System.nanoTime() - banqt);
        return out;
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
        total = total * Math.pow(10, - (dimension - 1.5));
        try {
            return random.nextDouble(lowerBoundCellsPerSim * total, upperBoundCellsPerSim * total);
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

    /**
     * Generates a random cell for specified quadrants in the coordinate system and a radius.
     * @param isReflectedQuadrant each position describes a dimension
     *                            if false, the random Cell position in this dimension is only positive fom 0 to (radius / 2)
     *                            if true, the random Cell position in this dimension can be positive or negative from -radius to + radius
     * @param radius the radius determines the maximum position value from 0 (origin) to the radius value
     * @return a new Cell
     */
    public static Cell randomCell(boolean[] isReflectedQuadrant, int radius) {
        int[] pos = new int[isReflectedQuadrant.length];
        for (int i = 0; i < pos.length; i++) {
            if (isReflectedQuadrant[i]) {
                pos[i] = random.nextInt( -radius, radius + 1);
            } else {
                pos[i] = random.nextInt(0, radius <= 0 ? (int)Math.floor(radius / 2d) : (int)Math.ceil(radius / 2d));
            }
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
