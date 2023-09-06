package de.teatime08;

import de.teatime08.gui.awt.Gui;

import java.awt.*;
public class Main {
    public static void main(String[] args) {
        Game g = new dNSimulation(4);
        //Game g = new Game(IStringIO.fromString("[2, 1, 0], [2, 1, 1], [2, 0, 0], [2, 0, 1], [-1, 1, 0], [-1, 1, 1], [-1, 0, 0], [-1, 0, 1]"));
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gui gui = new Gui(g);
                gui.setWaitMillies(0);
            }
        });
    }
}