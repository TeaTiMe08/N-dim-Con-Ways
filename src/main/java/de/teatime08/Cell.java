package de.teatime08;

import de.teatime08.lookup.Masks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The Cell class is the asset class representing one single cell in the game of life.
 * It holds information on the position of the cell and several methods for
 * - moving and re-arranging the cell
 * - geometric information to other cells
 * - constructing n-dimensional hyper-spheres around the cell
 * The cell also implements the Comparable interfaces to be able to compare them to other cells.
 */
public class Cell implements Comparator<Cell>, Comparable<Cell>, Cloneable {
    /**
     * The positions of the cell in whole numbers on the n-dim board.
     */
    int[] position;

    public Cell(int[] positions) {
        this.position = positions;
    }

    /**
     * Constructs a cell from given positions
     * @param positions
     * @return The cell Object holding the position.
     */
    public static Cell of(int[] positions) {
        return new Cell(positions);
    }

    public int[] getPosition() {
        return position;
    }

    /**
     * Checks for nother cell, if this cell is a neighbour of a given distance (taxicab).
     * @param other the other cell to compare to.
     * @param distance maximum Taxicab Distance to the other point.
     * @return true, if the other point is in taxicab distance, otherwise false.
     */
    public boolean isNeighbourOfWithMaxDistance(Cell other, int distance) {
        for (int i = 0; i < position.length; i++) {
            if (Math.abs(position[i] - other.position[i]) > distance)
                return false;
        }
        return true;
    }

    /**
     * Checks, if for another given point and a fixed distance, the other point has the exact
     * taxicab distance to this point.
     * @param other the other point to measure the distance.
     * @param distance taxicab distance.
     * @return true, if the other point has the exact taxicab distance to this point, otherwise false.
     */
    public boolean isNeighbourOfWithExactDistance(Cell other, int distance) {
        return pointsOfHyperSphere(distance).contains(other);
    }

    /**
     * Generates a Set of other Cells/Points for a specific taxicab distance.
     * This cell is not included in the result.
     * Examples:
     * - for 2d arr with radius 1 -> a 3x3 Matrix around this cell
     * - for 2d arr with radius 2 -> a 5x5 Matrix around this cell (without the inner 3x3)
     * - for 2d arr with radius 3 -> a 7x7 Matrix around this cell (without the inner 3x3 and 5x5)
     * - for 3D arr with radius 1 -> a 3x3x3 Block around this cell
     *
     * @param radius the length of the taxicab drive.
     * @return
     */
    public Set<Cell> pointsOfHyperSphere(int radius) {
        return generateMask(position.length, radius)
            .stream()
            .map(x -> new Cell(sequentialAdd(position, x.position)))
            .collect(Collectors.toSet());
    }

    /**
     * Generates hypershere masks for different dimensions and radius.
     * This method is used to create sets of cells around other cells.
     * Example:
     * - mask for generateMask(1, 1) -> {[-1], [1]}
     * - mask for generateMask(1, 2) -> {[-2], [2]}
     *   // one dimensional house around the center cell 0, 0
     * - mask for generateMask(2, 1) -> {[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, -1]}
     *   // eight cells around the middle without the center [0, 0]
     * @param dimension the dimension of the mask to build
     * @param radius the radius from the center in taxidrive distance
     * @return a set of cells repsensenting the mask.
     */
    public static Set<Cell> generateMask(final int dimension, final int radius) {
        // Build the n-dimensional "house"
        Set<Cell> lookedup = Masks.getMaskFor(dimension, radius);
        if (lookedup != null)
            return lookedup;
        final Set<Cell> combinations2 = new HashSet<>();
        Set<List<Integer>> lowerDimensionalPermutations2 = new HashSet<>();
        List initialCombination = new LinkedList(){{
            for (int i = 0; i < dimension; i++) {
                add(0);
            }
        }};
        generateCombinationsRecursiveLists(lowerDimensionalPermutations2, initialCombination, 0, radius);
        //long xList = System.currentTimeMillis() - x;
        //System.out.println("Generate Mask w/ Lists: " + xList + "ms");
        for (int i = 0; i < dimension; i++) {
            final int j = i;
            int[] scaffoldYin = new int[dimension], scaffoldYang = new int[dimension];
            scaffoldYin[i] = radius;
            scaffoldYang[i] = - radius;
            lowerDimensionalPermutations2.forEach(wall -> {
                List<Integer> scaffoldYin2 = new LinkedList<>(){{
                    addAll(wall.subList(0, j));
                    add(radius); //plus
                    addAll(wall.subList(j + 1, wall.size()));
                }};
                List<Integer> scaffoldYang2 = new LinkedList<>(){{
                    addAll(wall.subList(0, j));
                    add( - radius); // minus
                    addAll(wall.subList(j + 1, wall.size()));
                }};
                combinations2.add(new Cell(scaffoldYin2.stream().mapToInt(y -> y).toArray()));
                combinations2.add(new Cell(scaffoldYang2.stream().mapToInt(y -> y).toArray()));
            });
        }
        Cell origin = new Cell(new int[dimension]);
        Arrays.fill(origin.position, 0);
        combinations2.remove(origin);
        return new HashSet<>(combinations2);
    }

    private static void generateCombinationsRecursiveLists(
        Set<List<Integer>> combinations, List<Integer> currentCombination, int index, int radius
    ) {
        if (index == currentCombination.size()) {
            combinations.add(new LinkedList<>(currentCombination));
            return;
        }

        int[] values = new int[(2 * radius) + 1];
        for (int val = 0; val < (2 * radius) + 1; val++) {
            values[val] = val - radius;
        }

        for (int value : values) {
            currentCombination.set(index, value);
            generateCombinationsRecursiveLists(combinations, currentCombination, index + 1, radius);
        }
    }

    public Set<Cell> coordinatesOfHyperSphere(int radius) {
        Set<Cell> foundInDim = new HashSet<>();
        foundInDim.add(this);

        for (int dim = 0; dim < position.length; dim++) {
            Set<Cell> additives = new HashSet<>();
            for (Cell found : foundInDim) {
                Cell more = found.clone();
                more.position[dim] = more.position[dim] + radius;
                Cell less = found.clone();
                less.position[dim] = less.position[dim] - radius;

                additives.add(more);
                additives.add(less);
            }
            foundInDim.addAll(additives);
        }
        foundInDim.remove(this);
        return foundInDim;
    }

    /**
     * @return Euclidean distance to the n-dim origin [0, 0, 0, ... 0]
     */
    public double distEuclidToOrigin() {
        int[] origin = new int[position.length];
        Arrays.fill(origin, 0);
        return calculateEuclideanDistanceTo(new Cell(origin));
    }

    /**
     * Moves all given Cells by a vector
     * @param shape the input cells to be moved
     * @param vector the vector distance each cell is moved
     * @return the same set of cells with moved posisions
     */
    public static Set<Cell> move(Set<Cell> shape, int[] vector) {
        shape.forEach(cell -> {
            cell.position = sequentialAdd(cell.position, vector);
        });
        return shape;
    }

    /**
     * Staight up adds two int arrays together by same index values.
     * @param a first input
     * @param b second input
     * @return an array for which a[i] and b[i] were added at c[i]
     */
    private static int[] sequentialAdd(int[] a, int[] b) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public double calculateEuclideanDistanceTo(Cell other) {
        if (position.length != other.position.length) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }

        double sumOfSquares = 0.0;

        for (int i = 0; i < position.length; i++) {
            double difference = position[i] - other.position[i];
            sumOfSquares += difference * difference;
        }

        return Math.sqrt(sumOfSquares);
    }

    public int calculateManhattanDistanceTo(Cell other) {
        if (position.length != other.position.length) {
            throw new IllegalArgumentException("Points must have the same number of dimensions");
        }

        int distance = 0;
        for (int i = 0; i < position.length; i++) {
            distance += Math.abs(position[i] - other.position[i]);
        }

        return distance;
    }

    @Override
    public int compareTo(Cell o) {
        return compare(this, o);
    }

    @Override
    protected Cell clone() {
        return new Cell(Arrays.copyOf(position, position.length));
    }

    @Override
    public int compare(Cell o1, Cell o2) {
        return Arrays.compare(o1.position, o2.position);
    }

    @Override
    public String toString() {
        return Arrays.toString(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Arrays.equals(position, cell.position);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(position);
    }

    static void print(Set<Cell> cellsToPrint) {
        if (cellsToPrint.stream().findFirst().get().position.length > 2) {
            System.out.println("Cannot print dim 3+");
        } else {
            int width = 50,
                height = 15;
            char[][] board = new char[height][width];
            for (char[] chars : board) Arrays.fill(chars, '.');
            for (Cell c : cellsToPrint) {
                if (c.position[0] >= 0 && c.position[1] >= 0) {
                    board[c.position[0]][c.position[1]] = '#';
                }
            }
            for (char[] chars : board) System.out.println(new String(chars));
        }
    }
}
