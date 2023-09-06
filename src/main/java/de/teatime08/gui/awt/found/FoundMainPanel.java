package de.teatime08.gui.awt.found;

import de.teatime08.gui.awt.Gui;
import de.teatime08.gui.awt.MainPanel;

import java.awt.*;

public class FoundMainPanel extends MainPanel {
    public FoundMainPanel(Gui gui) {
        super(gui);

        headerText = "xD-GoL v.1.0.0 FOUNDSHAPES";
        topBarColor = new Color(118, 3, 20);
        drawRPM = true;
        drawPower = false;
        drawGeneration = false;
    }


}
