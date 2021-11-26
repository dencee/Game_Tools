package examples.pong;

import java.awt.Color;
import java.awt.Graphics;

import game_tools.GameScene;

public class Level2 implements GameScene {
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 500);

	}
}
