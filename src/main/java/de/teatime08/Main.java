package de.teatime08;

import de.teatime08.gui.awt.Gui;
import de.teatime08.shapes.D2;
import de.teatime08.shapes.IStringIO;

import java.awt.*;
public class Main {
    public static void main(String[] args) {
        Game g = new dNSimulation(4);
        //Game g = new Game(D2.GOSPER_GLIDER_GUN);
        //Game g = new Game(IStringIO.fromString("[-6, -3], [-5, -2], [-7, -4], [-7, -2], [-6, -1], [-8, -3]"));

        long passed = 0, start = System.currentTimeMillis(), how = 10_000;
        //withGui(g);
        while(passed < how) {
            g.next();
            passed = System.currentTimeMillis() - start;
        }
        g.close();
    }

    public static void withGui(Game game) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gui gui = new Gui(game);
                gui.setWaitMillies(0);
            }
        });
    }
}