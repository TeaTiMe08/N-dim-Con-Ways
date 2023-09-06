package de.teatime08.gui.awt;

import de.teatime08.Cell;
import de.teatime08.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Closeable;
import java.io.IOException;
import java.util.*;

public class Gui extends JFrame {
    static final Color CELL_COLOR = Color.white;
    static final Color BACKGROUND_COLOR = Color.black;

    final Dimension screenSize;
    JComponent[][] drawMe;

    final Gui thus;
    protected final Game game;

    // gui control
    protected MainPanel mainPanel = new MainPanel(this);
    KeyChecka keyChecka;
    Set<Cell> newShape = null;

    // runtime control
    protected boolean shouldRun = true;
    protected boolean shouldCompute = true;
    protected long waitMillies = 10;
    protected boolean isBlockedGenerating = false;

    // (tacho = german for speed display, kilometer = german for overall distance travelled)
    protected long tacho = 0;
    protected long kilometer = System.nanoTime();

    public Gui(Game game) throws HeadlessException {
        super();
        thus = this;
        this.game = game;

        initKeyAdapter();
        initWindowAdapter();

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        mainPanel.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
        getContentPane().add(mainPanel);

        mainPanel.setLayout(null);
        initBoards();
        mainPanel.setVisible(true);

        getContentPane().setBackground(BACKGROUND_COLOR);

        addKeyListener((KeyAdapter)keyChecka);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shouldCompute = !shouldCompute;
                mainPanel.statusText = shouldCompute ? " ⚡" : "⏸️";
            }
        });

        pack();
        setVisible(true);

        Thread t = new Thread() {
            @Override
            public void run() {
                drawing();
            }
        };
        t.setDaemon(true);
        t.start();
    }

    protected void initKeyAdapter() {
        keyChecka = new KeyChecka(this);
    }

    protected  void initWindowAdapter() {
        addWindowListener(new WindowAdapter() {

        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                shouldCompute = true;
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                shouldCompute = false;
            }

            @Override
            public void windowClosing(WindowEvent e) {
                shouldRun = false;
                if (game instanceof Closeable closeableGame) {
                    try {
                        long waitTorGeneration = System.currentTimeMillis();
                        mainPanel.statusText = "👋";
                        SwingUtilities.invokeLater(() -> {
                            mainPanel.repaint();
                        });
                        shouldCompute = false;
                        shouldRun = false;
                        while (isBlockedGenerating) {
                            Thread.sleep(50);
                        }
                        closeableGame.close();
                    } catch (IOException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    private void initBoards() {
        if (game.getCells().isEmpty())
            return;
        int dim = game.getCells().stream().findFirst().get().getPosition().length;
        drawMe = new JComponent[dim - 1][dim - 1];
        for (int i = 0; i < drawMe.length; i++) {
            for (int j = 0; j < drawMe[0].length; j++) {
                drawMe[i][j] = new CellBoard(this, i, j);
                drawMe[i][j].setBounds(
                    i * (screenSize.width / drawMe.length),
                    (j * (screenSize.height / drawMe[0].length)) + mainPanel.topBarHeight,
                    screenSize.width / drawMe.length,
                    (screenSize.height / drawMe[0].length) - (drawMe[0].length / mainPanel.topBarHeight)
                );
                drawMe[i][j].setBackground(BACKGROUND_COLOR);
                mainPanel.add(drawMe[i][j]);
                drawMe[i][j].setVisible(true);
            }
        }
    }

    public void drawing() {
        while (shouldRun) {
            if (shouldCompute) {
                long past = System.currentTimeMillis();
                if (newShape != null) {
                    game.clear();
                    game.decorateShape(newShape);

                    for (int i = 0; i < drawMe.length; i++) {
                        for (int j = 0; j < drawMe[0].length; j++) {
                            mainPanel.remove(drawMe[i][j]);
                        }
                    }
                    initBoards();
                    newShape = null;
                }

                isBlockedGenerating = true;
                game.next();
                isBlockedGenerating = false;
                tacho = System.nanoTime() - kilometer;
                kilometer = System.nanoTime();

                SwingUtilities.invokeLater(() -> {
                    mainPanel.repaint();
                });
                nextFinishedEvent();
                try {
                    long present = System.currentTimeMillis();
                    long restFromTimed = Math.max(0, this.waitMillies - (present - past));
                    if (restFromTimed > 0)
                        Thread.sleep(restFromTimed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void nextFinishedEvent() {}

    public Set<Set<Cell>> getFoundShapes() {
        return game.shapesDetector.getFoundShapes();
    }

    public void setWaitMillies(long waitMillies) {
        this.waitMillies = waitMillies;
    }
}
