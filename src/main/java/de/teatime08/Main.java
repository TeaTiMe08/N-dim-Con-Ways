package de.teatime08;

import de.teatime08.gui.awt.Gui;
import de.teatime08.shapes.D2;
import de.teatime08.shapes.IStringIO;

import java.awt.*;
public class Main {
    public static void main(String[] args) {
        //Game g = new dNSimulation(4);
        //Game g = new Game(D2.GOSPER_GLIDER_GUN);
        Game g = new Game(IStringIO.fromString("[-2, -3, -3, -2], [-2, -3, -2, -2], [-1, -3, -3, -2], [1, -3, -3, -2], [-2, -3, 2, -2], [-1, -3, -2, -2], [2, -3, -2, -2], [1, -3, -2, -2], [2, -3, -3, -2], [-1, -3, 2, -2], [-2, -3, 3, -2], [1, -3, 3, -2], [2, -3, 2, -2], [1, -3, 2, -2], [-1, -3, 3, -2], [2, -3, 3, -2]"));
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gui gui = new Gui(g);
                gui.setWaitMillies(0);
            }
        });
    }
}