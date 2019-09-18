package CafeWall;

import java.awt.*;

public class CafeWall {
    public static final int MORTAR = 2;  // space between pairs of rows

    public static void main(String[] args) {
        DrawingPanel p = new DrawingPanel(650, 400);
        p.setBackground(Color.GRAY);
        Graphics g = p.getGraphics();
        drawRow(g, 0, 0, 4, 20);
        drawRow(g, 50, 70, 5, 30);
        drawGrid(g, 10, 150, 4, 25, 0);
        drawGrid(g, 400, 20, 2, 35, 35);
        drawGrid(g, 250, 200, 3, 25, 10);
        drawGrid(g, 425, 180, 5, 20, 10);
    }

    // Draws a single row using the given Graphics object and with upper-left
    // corner (x, y), and the given number of pairs of black/white squares
    // each size-by-size.
    public static void drawRow(Graphics g, int x, int y, int pairs, 
                               int size) {
        for (int i = 1; i <= pairs; i++) {
            g.setColor(Color.BLACK);
            int newX = x + (2 * i - 2) * size;
            g.fillRect(newX, y, size, size);
            g.setColor(Color.WHITE);
            g.fillRect(newX + size, y, size, size);
            g.setColor(Color.BLUE);
            g.drawLine(newX, y, newX + size, y + size);
            g.drawLine(newX, y + size, newX + size, y);
        }
    }

    // Draws a single grid using the given Graphics object and with upper-left
    // corner (x, y), and the given number of pairs of rows each with the
    // given number of pairs of black/white boxes that are each size-by-size.
    public static void drawGrid(Graphics g, int x, int y, int pairs,
                                int size, int xOffset) {
        for (int i = 1; i <= pairs; i++) {
            int newY = y + (2 * i - 2) * (MORTAR + size);
            drawRow(g, x, newY, pairs, size);
            drawRow(g, x + xOffset, newY + MORTAR + size, pairs, size);
        }
    }
}

