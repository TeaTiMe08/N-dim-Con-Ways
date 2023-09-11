package de.teatime08;

import de.teatime08.gui.awt.Gui;
import de.teatime08.shapes.D2;

import java.awt.*;
public class Main {
    public static void main(String[] args) {
        Game g = new dNSimulation(3);
        //Game g = new Game(D2.GOSPER_GLIDER_GUN);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gui gui = new Gui(g);
                gui.setWaitMillies(0);
            }
        });
    }
}