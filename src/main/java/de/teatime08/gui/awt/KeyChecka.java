package de.teatime08.gui.awt;

import de.teatime08.gui.awt.found.FoundMainPanel;
import de.teatime08.shapes.D2;
import de.teatime08.shapes.D3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import static java.awt.event.KeyEvent.*;

public class KeyChecka extends KeyAdapter {

    final JFrame d3Frame;
    final FoundMainPanel foundMainPanel;
    
    final Gui gui;

    public KeyChecka(Gui gui) {
        this.gui = gui;
        this.foundMainPanel = new FoundMainPanel(gui);
        this.foundMainPanel.setPreferredSize(new Dimension(gui.getWidth(), gui.getHeight()));

        d3Frame = new JFrame(); // new FoundGui(gui.game);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_ESCAPE:
                gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
                break;
            case VK_CONTROL:
                //TODO update cells
                d3Frame.toFront();
                d3Frame.setVisible(true);
                gui.shouldCompute = false;
                foundMainPanel.statusText = "⏸️";
                break;
            case VK_UP:
            case VK_KP_UP:
                gui.waitMillies = gui.waitMillies < 10 ? gui.waitMillies : gui.waitMillies - 10;
                break;
            case VK_DOWN:
            case VK_KP_DOWN:
                gui.waitMillies = gui.waitMillies > 140 ? 150 : gui.waitMillies + 10;
                break;
            case VK_SPACE:
                gui.shouldCompute = !gui.shouldCompute;
                gui.mainPanel.statusText = gui.shouldCompute ? " ⚡" : "⏸️";
                break;
            case VK_0:
                gui.newShape = D2.ACHIMS_P11;
                break;
            case VK_1:
                gui.newShape = D2.METHUSELAH_R_PENTOMINO;
                break;
            case VK_2:
                gui.newShape = D2.BEEHIVE;
                break;
            case VK_3:
                gui.newShape = D2.LOAF;
                break;
            case VK_4:
                gui.newShape = D2.LWSS;
                break;
            case VK_5:
                gui.newShape = D2.PULSAR;
                break;
            case VK_6:
                gui.newShape = D2.FERMAT_PRIMER;
                break;
            case VK_7:
                gui.newShape = D2.CATERLOOPILLAR;
                break;
            case VK_8:
                gui.newShape = D2.GOSPER_GLIDER_GUN;
                break;
            case VK_9:
                gui.newShape = D2.BLINKER;
                break;
            case VK_Q:
                gui.newShape = D3.GLIDER;
                break;
            case VK_W:
                gui.newShape = D3.TUMBLER;
                break;
        }
    }
}