package game_tools;

import java.awt.Dimension;

public class Game {
    public GameFrame frame;
    public int screenWidth;
    public int screenHeight;

    public Game() {
        frame = new GameFrame();
    }

    public void start() {
        frame.start();
    }
    
    public void setTitle(String title) {
        this.frame.setTitle(title);
    }

    public void setSize(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
        frame.setSize(width, height);
    }

    public void setSize(Dimension d) {
        this.screenWidth = d.width;
        this.screenHeight = d.height;
        frame.setSize(d);
    }

    public void setPreferredSize(int width, int height) {
        this.frame.setPreferredSize(width, height);
        this.frame.pack();
    }

    public void setScene(GameControlScene scene) {
        frame.setGameScene(scene);
    }

    public void setScene(GameScene scene) {
        frame.setGameScene(scene);
    }

    public void addController(Controller controller) {
        frame.addController(controller);
    }
}
