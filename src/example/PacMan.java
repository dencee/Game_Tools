package example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import game_tools.GameFrame;
import game_tools.GameScene;
import game_tools.KeyPress;

public class PacMan implements GameScene, KeyPress {
	int x = 0;
	int y = 200;
	boolean openMouth;
	int count = 0;
	Ghost ghost = new Ghost();
	GameOverScene gameOverScene = new GameOverScene();

	GameFrame gameFrame = new GameFrame();

	public PacMan() {
		gameFrame.setVisible(true);
		gameFrame.addKeyPress(this);
		gameFrame.setGameScene(this);
		gameFrame.start();

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.YELLOW);
		moveMouth(g);
		ghost.draw(g);
		x++;
		count++;
	}

	void moveMouth(Graphics g) {
		if (count % 10 == 0)
			openMouth = !openMouth;
		if (openMouth)
			g.fillArc(x, y, 100, 100, 15, 315);
		else
			g.fillArc(x, y, 100, 100, 0, 360);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 3;
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 3;
		} else if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			gameFrame.setGameScene(gameOverScene);
		}
	}
}