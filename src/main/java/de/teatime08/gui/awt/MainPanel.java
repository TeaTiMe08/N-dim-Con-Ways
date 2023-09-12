package de.teatime08.gui.awt;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class MainPanel extends JPanel {
    final Gui gui;
    protected String headerText = "xD-GoL v.1.0.0 SIMULATION";
    private String speedText = "";
    private String generationText = "";
    public String statusText = " ⚡";
    private long lastTimeOfTimedTextUpdate = System.currentTimeMillis();
    public final int topBarHeight = 30;
    protected Color topBarColor = new Color(150, 68, 134, 255);

    protected boolean drawPower = true;
    protected boolean drawRPM = true;
    protected boolean drawGeneration = true;

    public MainPanel(Gui gui) {
        this.gui = gui;
    }

    @Override
    protected void paintComponent(Graphics g) {
        paintShit(g);
    }

    public void paintShit(Graphics g) {
        // draw top bar
        g.setColor(topBarColor);
        g.fillRect(0, 0, gui.screenSize.width, topBarHeight);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g.setColor(Color.white);
        Font bigFont = g.getFont().deriveFont(Font.BOLD, 20.0f );
        Font smallFont = g.getFont().deriveFont(Font.ITALIC, 13.0f );
        g.setFont(bigFont);
        g.drawString(headerText.toUpperCase(), 10, topBarHeight - 9);

        // draw Status Text
        g.setFont(bigFont);
        g.setColor(Color.white);
        g.fillRect(290, 3, 24, 24);
        g.setColor(Color.black);
        g.drawString(statusText, 290, 12 + (int)(0.5 * bigFont.getSize()));

        // draw POWER BAR
        if (drawPower) {
            int sizePowerBar = 250;
            int xPosPowerBar = 320;
            int ySizePowerBar = 18;

            Polygon powerTri = new Polygon();
            powerTri.addPoint(xPosPowerBar, topBarHeight - (topBarHeight - ySizePowerBar) / 2);
            powerTri.addPoint(xPosPowerBar + sizePowerBar, (topBarHeight - ySizePowerBar) / 2);
            powerTri.addPoint(xPosPowerBar + sizePowerBar, topBarHeight - (topBarHeight - ySizePowerBar) / 2);
            g.setColor(new Color(215, 170, 15));
            g.fillPolygon(powerTri);

            Polygon powerTriActive = new Polygon();
            powerTriActive.addPoint(xPosPowerBar, topBarHeight - (topBarHeight - ySizePowerBar) / 2);
            int posXActive = xPosPowerBar + (int)Math.max(0, sizePowerBar - (gui.waitMillies * 1.67));
            int yInterpolPowerBar = (int)(ySizePowerBar * (Math.max(0, sizePowerBar - (gui.waitMillies * 1.67)) / sizePowerBar));
            yInterpolPowerBar = (topBarHeight - (topBarHeight - ySizePowerBar) / 2) - yInterpolPowerBar;
            powerTriActive.addPoint(posXActive, yInterpolPowerBar);
            powerTriActive.addPoint(posXActive, topBarHeight - (topBarHeight - ySizePowerBar) / 2);
            g.setColor(new Color(210, 194, 12));
            if (g instanceof Graphics2D g2i) {
                GradientPaint primary = new GradientPaint(
                    xPosPowerBar, 6,
                    new Color(40, 218, 0),
                    xPosPowerBar + sizePowerBar, 6 + ySizePowerBar,
                    new Color(213, 0, 59)
                );
                g2i.setPaint(primary);
            }
            g.fillPolygon(powerTriActive);

            g.setFont(smallFont);
            g.setColor(Color.white);
            g.drawString("POWER LEVEL", xPosPowerBar, 12);
        }

        // timed Update Loop
        if (System.currentTimeMillis() - lastTimeOfTimedTextUpdate > 500) {
            updateTimedTextLabels();
        }

        // paint speed label
        Font speedFont= g.getFont().deriveFont(Font.ITALIC, 18.0f);
        if (drawRPM) {
            g.setFont(speedFont);
            g.setColor(Color.white);
            g.drawString(speedText, 580, 12 + (int)(0.5 * speedFont.getSize()));
        }

        // paint generation
        if (drawGeneration) {
            g.setFont(speedFont);
            g.setColor(Color.white);
            g.drawString(generationText, 810, 12 + (int)(0.5 * speedFont.getSize()));
        }

        g.setFont(bigFont);
        g.setColor(Color.BLACK);
        g.drawString(gui.game.shapesDetector.getFoundShapes().size() + "Shapes found", 890, 12 + (int)(0.5 * bigFont.getSize()));
    }

    private void updateTimedTextLabels() {
        // paint tacho
        double rpm = (double)(60_000_000_000L / Math.max(0.000001, gui.tacho));
        DecimalFormat df = new DecimalFormat("###,###,###");
        speedText = "SPEED: " + df.format(rpm) + " RPM";
        lastTimeOfTimedTextUpdate = System.currentTimeMillis();

        // set Generation Text
        generationText = "Gen" + gui.game.getGeneration();
    }

    public void reset() {
        lastTimeOfTimedTextUpdate = System.currentTimeMillis();
        updateTimedTextLabels();
    }
}