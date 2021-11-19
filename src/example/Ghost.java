package example;

import java.awt.Color;
import java.awt.Graphics;

public class Ghost {
	int x = 0;
	int y = 0;
	boolean left = false;

	// Drawing the Ghost
	void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 100, 100);
		g.setColor(Color.BLACK);
		g.fillOval(x+10, y+10, 10,10);
		g.fillOval(x+70, y+10, 10,10);
		if (!left)
			x++;
		else
			x--;
		if (x > 1000 || x < 0) {
			left = !left;
		}
	}
}
