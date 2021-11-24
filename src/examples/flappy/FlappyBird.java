package examples.flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game_tools.GameControlScene;
import game_tools.GameFrame;

public class FlappyBird implements GameControlScene {
	float x = 100;
	float y = 0;
	int pipeX = 500;
	float velocity = 1;
	float gravity = 1;
	GameFrame window = new GameFrame();

	public FlappyBird() {
		window.setGameScene(this);
		window.start();
	}

	@Override
	public void draw(Graphics g) {
		// draw background
		g.setColor(new Color(100, 150, 230));
		g.fillRect(0, 0, window.screenWidth, window.screenHeight);

		// draw bird
		drawBird(g);
		drawPipes(g);

		// physics
		pipeX -= 2;
		y -= velocity;
		velocity -= gravity;

	}

	public void drawPipes(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(pipeX, 0, 50, 200);
	}

	public void drawBird(Graphics g) {
		g.setColor(Color.orange);
		g.fillOval((int) x, (int) y, 50, 50);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		velocity = 10;
	}
}
