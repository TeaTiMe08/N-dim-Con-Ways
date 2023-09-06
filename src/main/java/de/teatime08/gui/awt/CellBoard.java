package de.teatime08.gui.awt;

import de.teatime08.Cell;
import de.teatime08.Game;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static de.teatime08.gui.awt.Gui.BACKGROUND_COLOR;
import static de.teatime08.gui.awt.Gui.CELL_COLOR;

class CellBoard extends JPanel {
    final int xBoardPos, yBoardPos;

    final Gui gui;
    public CellBoard(Gui gui, int xBoardPos, int yBoardPos) {
        this.gui = gui;
        this.xBoardPos = xBoardPos;
        this.yBoardPos = yBoardPos;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Set<Cell> cells = null;
        try {
            cells = new HashSet<>(gui.game.getCells());
        } catch (ConcurrentModificationException e) {
            System.err.print("e");
        }
        if (cells == null || cells.isEmpty()) return;

        g.setColor(BACKGROUND_COLOR);

        int[][] boardSize = Game.calculateMinMaxVector(cells);
        if (boardSize.length < 2) {
            g.dispose();
            return;
        }
        int[] from = boardSize[0], to = boardSize[1];

        int xSize = Math.abs(to[0] - from[0]) + 1;// add zero
        int ySize = Math.abs(to[1] - from[1]) + 1;// add zero
        // offset for centering cells inside a positive rectangle
        int XnegativeOffset = Math.abs(from[0]);
        int YnegativeOffset = Math.abs(from[1]);
        // always centered
        int XmiddleOffset = (int)(0.5 * getBounds().width - 0.5 * xSize);
        int YmiddleOffset = (int)(0.5 * getBounds().height - 0.5 * ySize);

        g.setColor(CELL_COLOR);
        // 2 dim
        if (cells.stream().findFirst().get().getPosition().length <= 2) {
            cells.forEach(cell -> {
                double XsqreSize = getBounds().width / xSize;
                int x = (int)((cell.getPosition()[0] - from[0]) * XsqreSize);
                //int x = (cell.getPosition()[0] - XnegativeOffset) + XmiddleOffset;
                double YsqreSize = getBounds().height / ySize;
                int y = (int)((cell.getPosition()[1] - from[1]) * YsqreSize);
                //int y = (cell.getPosition()[1] - YnegativeOffset) + YmiddleOffset;
                if (0 < x && x < getBounds().width && 0 < y && y < getBounds().height) {
                    g.fillRect(x, y, (int)XsqreSize, (int)YsqreSize);
                }
            });
        } else {
            int dim = cells.stream().findFirst().get().getPosition().length;
            int xPos = yBoardPos;
            int yPos = (yBoardPos + 1) % dim;
            int zPos = (yBoardPos + 2) % dim;


            /*
            java.util.List<int[]> filteredForLargestElementsOnxAchses
                = cells.stream().map(Cell::getPosition).collect(Collectors.toList());
             */
            List<int[]> filteredForLargestElementsOnxAchses = findMaxValuesForEqualIndices(
                cells.stream().map(x -> x.getPosition()),
                xPos, yPos, zPos
            );

            filteredForLargestElementsOnxAchses.forEach(arr -> {
                double XsqreSize = getBounds().width / xSize;
                int x = (int)((arr[xPos] - from[0]) * XsqreSize);
                //int x = (cell.getPosition()[0] - XnegativeOffset) + XmiddleOffset;
                double YsqreSize = getBounds().height / ySize;
                int y = (int)((arr[yPos] - from[1]) * YsqreSize);
                //int y = (cell.getPosition()[1] - YnegativeOffset) + YmiddleOffset;
                if (0 < x && x < getBounds().width && 0 < y && y < getBounds().height) {
                    if (boardSize[0].length > 2) {
                        int zSize = boardSize[1][2] - boardSize[0][2];
                        int z = (int)((arr[zPos] - from[0]) * (100 / zSize));
                        g.setColor(getColorForValue(z));
                    }
                    g.fillRect(x, y, (int)XsqreSize, (int)YsqreSize);
                }
            });

        }
        g.dispose();
    }

    public static java.util.List<int[]> findMaxValuesForEqualIndices(Stream<int[]> arrayStream, int xPos, int yPos, int zPos) {
        Map<List<Integer>, Optional<int[]>> grouped
            = arrayStream.collect(Collectors.groupingBy(
            arr -> Arrays.asList(arr[xPos], arr[yPos]),
            Collectors.maxBy(Comparator.comparingInt(arr -> arr[zPos]))
        ));

        return grouped.values().stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }

    public static Color getColorForValue(int value) {
        // Define the start and end colors (green to red)
        Color startColor = Color.GREEN;
        Color endColor = Color.RED;

        // Calculate the intermediate color based on the value
        int r = startColor.getRed() + (int) ((endColor.getRed() - startColor.getRed()) * (value / 100.0));
        int g = startColor.getGreen() + (int) ((endColor.getGreen() - startColor.getGreen()) * (value / 100.0));
        int b = startColor.getBlue() + (int) ((endColor.getBlue() - startColor.getBlue()) * (value / 100.0));

        // Ensure that the RGB values are within the valid range (0-255)
        r = Math.min(255, Math.max(0, r));
        g = Math.min(255, Math.max(0, g));
        b = Math.min(255, Math.max(0, b));

        // Create and return the interpolated color
        return new Color(r, g, b);
    }
}