package examples.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game_tools.GameControlScene;
import game_tools.GameFrame;

public class Tetris implements GameControlScene {

	GameFrame frame = new GameFrame();
	Level2 level2 = new Level2();

	Tetris() {
		frame.setGameScene(this);
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
			frame.setGameScene(level2);
		}

	}

}
