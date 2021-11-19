package example;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game_tools.GameScene;
import game_tools.GameFrame;
import game_tools.GamePanel;
import game_tools.KeyPress;

public class MyGame implements GameScene, KeyPress{
	public MyGame() {
		GameFrame  frame = new GameFrame(this);
		GamePanel panel = new GamePanel(this);
		frame.add(panel);
		frame.setSize(500,100);
	}
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

}
