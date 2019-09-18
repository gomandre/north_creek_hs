package gameofsticks;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* get drawing panel imported */
import gameofsticks.DrawingPanel;

/*
 * This is a 2D game of sticks
 * (c) Andre Gomez 2019
 */
public class GameOfSticks {
	public static void main(String[] args) throws IOException, InterruptedException {
        DrawingPanel gameboard = new DrawingPanel(500, 200);
        int sticks = 20;
        gameboard.setBackground(Color.ORANGE);
        BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
        drawboard(gameboard.getGraphics(), sticks);
        String inputString = input.readLine();
        while (inputString.compareTo("q") != 0 || (sticks <= 0)) {
        	if (tryParseInt(inputString)) {
        		int temp = Integer.parseInt(inputString);
        		if (temp <= 3 && temp > 0) {
        			sticks -= temp;
        			gameboard.clear();
        			drawboard(gameboard.getGraphics(), sticks);
        			Thread.sleep((long) 2000);;
        			sticks -= comp_play(sticks);
        			gameboard.clear();
        			drawboard(gameboard.getGraphics(), sticks);
        		}
        	}
        	inputString = input.readLine();
        }
        System.exit(0);
	}
	static int comp_play(int sticks) {
		return ((sticks % 4 != 0) ? (sticks % 4) : 1);
	}
	static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	public static void drawboard(Graphics board, int num_sticks) {
		for (int i=0; i < num_sticks; i++) {
			board.setColor(Color.blue);
			board.fillRect(20 * i + 50, 60, 4, 50);
		}
	}
}
