package de.teatime08.shapes;

import de.teatime08.Cell;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface IStringIO {
    public static Set<Cell> fromString(String input) {
        String[] cells = input
            .replace("\n", " ")
            .replace("),", ");")
            .replace("],", "];")
            .split(";");

        return new HashSet<>(){{
            for (String cell : cells) {
                int[] positions = Arrays.stream(cell
                        .replace("(", "")
                        .replace("[", "")
                        .replace(")", "")
                        .replace("]", "")
                        .split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
                add(new Cell(positions));
            }
        }};
    }

    public static Set<Cell> fromConwaysNotation(String input) {
        Set<Cell> livingCellPositions = new HashSet<>();
        input = input.replace("\n", "");
        String[] rows = input.split("\\$");

        for (String row : rows) {
            row = row.replaceAll("[^ob]", ""); // Remove non-cell characters
            for (int col = 0; col < row.length(); col++) {
                if (row.charAt(col) == 'o') {
                    int[] position = {rows.length - 1, col}; // Adjust for 0-based index
                    livingCellPositions.add(new Cell(position));
                }
            }
        }

        return livingCellPositions;
    }

}
