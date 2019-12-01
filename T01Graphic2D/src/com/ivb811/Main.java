package com.ivb811;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import javax.swing.*;

public class Main extends JFrame {
    private int _stroke = 3;

    public Main() {
        // super("An AWT-Based Application");
        setSize(500, 900);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        paintJulia(g);
    }

    private void paintJulia(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.MAGENTA);

        int width = getWidth();
        int  height = getHeight();
        int halfWidth = width / 2;
        int halfHeight = height / 2;
        int thirdHeight = height / 3;
        int thirdWidth = width / 3;
        int quarterHeight = height / 4;

        // Clear screen for the new frame
        g2D.clearRect(0, 0, (int)width - 1, (int)height - 1);

        // Title definition and draw
        g2D.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 22));
        g2D.drawString("Юлия Буравлёва, ИВБ-811", 10, height / 10);

        // Set stroke for lines
        g2D.setStroke(new BasicStroke(_stroke));

        // Figure drawing
        g2D.draw(new Arc2D.Float(halfWidth - thirdWidth, halfHeight - quarterHeight,
                thirdWidth, thirdHeight, 270, 90, Arc2D.OPEN));
        float dx = halfWidth - thirdWidth - (halfWidth - thirdWidth) / 2f;
        g2D.draw(new Arc2D.Float(width / 2.4f + dx, halfHeight - quarterHeight,
                thirdWidth, thirdHeight, 180, 90, Arc2D.OPEN));
        g2D.drawLine((int)halfWidth, (int)(halfHeight - quarterHeight), (int)halfWidth, (int)(height / 2.39));
        g2D.drawLine((int)(halfWidth - width / 8), (int)(height / 2.39), (int)(halfWidth + width / 8), (int)(height / 2.39));
        g2D.draw(new Arc2D.Float(halfWidth - width / 4, halfHeight - quarterHeight,
                thirdWidth, thirdHeight,  15, 30, Arc2D.OPEN));
    }

    public static void main(String args[]) {
        Main canvas = new Main();
    }
}
