package game_tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener {
	public KeyPress keyPress;
	public KeyRelease keyRelease;

	public static final int DEFAULT_SIZE = 500;
	private GamePanel gamePanel;
	/**
	 * Creates a GameFrame with a `keyPress` key listener
	 * @param keyPress
	 */
	public GameFrame(KeyPress keyPress) {
		this.keyPress = keyPress;
		this.gamePanel = new GamePanel();
		this.setVisible(true);
		this.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		if (keyPress != null) {
			this.addKeyListener(this);
		}
	}

	public GameFrame() {
		this.gamePanel = new GamePanel();
		this.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		this.setVisible(true);
		this.add(gamePanel);
		
	}

	/**
	 * 
	 * @param gamePanel
	 */
	public void add(GamePanel panel) {
		this.add((JPanel) panel);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
   // TODO not yet implemented
 }

	@Override
	public void keyPressed(KeyEvent e) {
		if(keyPress != null)
			keyPress.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(keyRelease != null)
			keyRelease.keyReleased(e);
	}
	
	/**
	 * Add your game's keyPress
	 * @param keyPress
	 */
	public void addKeyPress(KeyPress keyPress) {
		this.keyPress = keyPress;
		this.addKeyListener(this);
	}
	/**
	 * Add your game's keyRelease
	 * @param keyPress
	 */
	public void addKeyRelease(KeyRelease keyRelease) {
		this.keyRelease = keyRelease;
		this.addKeyListener(this);
	}
	/**
	 * Set the scene of your game
	 * @param GameScene
	 */
	public void setGameScene(GameScene scene) {
		this.gamePanel.setGameScene(scene);
	}
	
	public void start() {
		this.gamePanel.start();
	}
}
