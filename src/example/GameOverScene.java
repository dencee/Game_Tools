package example;

import java.awt.Color;
import java.awt.Graphics;

import game_tools.GameScene;

public class GameOverScene implements GameScene {

	@Override
	public void draw(Graphics g) {
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.WHITE);
		g.drawString("Game Over", 100, 100);
	}
}
