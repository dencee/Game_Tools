package examples.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game_tools.Game;
import game_tools.GameControlScene;

public class Tetris implements GameControlScene {

	Game frame = new Game();
	Level2 level2 = new Level2();

	Tetris() {
		frame.setScene(this);
		frame.start();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.WHITE);
		g.fillOval(190, 190, 100, 100);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			frame.setScene(level2);
		}

	}

}
