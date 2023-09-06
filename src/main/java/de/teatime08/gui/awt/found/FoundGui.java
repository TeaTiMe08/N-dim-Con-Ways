package de.teatime08.gui.awt.found;

import de.teatime08.Cell;
import de.teatime08.Game;
import de.teatime08.gui.awt.Gui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FoundGui extends Gui {

    private final Game simGame;

    private java.util.List<Set<Cell>> currentlyFound = new LinkedList<>();

    private int foundShapesIterator = 0;

    public FoundGui(Game simGame) throws HeadlessException {
        super(firstFoundShapeGame(simGame));
        this.simGame = simGame;
        mainPanel = new FoundMainPanel(this);
        currentlyFound = simGame.shapesDetector.getFoundShapes().stream().toList();
    }

    @Override
    protected void initKeyAdapter() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_KP_RIGHT:
                        foundShapesIterator++;
                        game.clear();
                        game.reInitWithCells(currentlyFound.get(foundShapesIterator));
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_KP_LEFT:
                        foundShapesIterator = Math.max(0, --foundShapesIterator);
                        game.clear();
                        game.reInitWithCells(currentlyFound.get(foundShapesIterator));
                        break;
                    case KeyEvent.VK_CONTROL:
                        shouldCompute = false;
                        mainPanel.statusText = "⏸️";
                        setVisible(false);
                        toBack();
                        break;
                }
            }
        });
    }

    private static Game firstFoundShapeGame(Game simgame) {
        final Set<Cell> initial = new HashSet<>();
        simgame.shapesDetector.getFoundShapes().stream().findFirst().ifPresentOrElse(
            x -> initial.addAll(x),
            () -> {}
        );
        return new Game(initial);
    }
}
