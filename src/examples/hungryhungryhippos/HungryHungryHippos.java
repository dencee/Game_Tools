package examples.hungryhungryhippos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import game_tools.Game;
import game_tools.GameControlScene;
import game_tools.GameScene;

/*
 * Background:
 * Hungry Hungry Hippos is a tabletop game made for 2-4 players.
 * Each player control a hippo on the left, right, top, and bottom of the screen
 * and the goal is to eat as many melons as possible that come near your hippo's mouth.
 * Look at the keyPressed method below to see how each hippo eats melons.
 * https://en.wikipedia.org/wiki/Hungry_Hungry_Hippos
 * 
 * Objective:
 * You will notice each Hippo is the same color. In the original game each hippo is a
 * different color with a different name:
 *  Lizzie Hippo (purple)
 *  Henry Hippo (orange)
 *  Homer Hippo (green)
 *  Harry Hippo (yellow)
 * 
 * 1. Create member variables in the Hippo class for each hippo's name and color.
 * 2. Make the Hippo constructor take 2 additional parameters that set the name and color.
 * 3. Change the Hippo's draw method so the hippo is the correct color.
 * 4. Create a method in the Hippo class that displays the hippo's name and number of melons
 *    they've eaten.
 */
public class HungryHungryHippos implements GameScene, GameControlScene {
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 800;
    static final int GAME_BOARD_WIDTH = (2 * GAME_WIDTH) / 3;
    static final int GAME_BOARD_X = -10 +(GAME_WIDTH - GAME_BOARD_WIDTH) / 2;
    static final int GAME_BOARD_Y = 5 + GAME_BOARD_X;
    static final int NUM_MELONS = 150;

    /*
     * Member variables
     */
    boolean startGame = false;
    Color boardColor = new Color(138, 198, 193);
    Game gameFrame = new Game();

    Hippo h1 = new Hippo("up");
    Hippo h2 = new Hippo("down");
    Hippo h3 = new Hippo("left");
    Hippo h4 = new Hippo("right");

    public HungryHungryHippos() {
        gameFrame.setScene(this);
        gameFrame.start();
        gameFrame.setSize(GAME_WIDTH, GAME_HEIGHT);

        setup();
    }

    @Override
    public void draw(Graphics g) {
        /*
         * Background
         */
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        /*
         * Circular game table
         */
        g.setColor(boardColor);
        g.fillOval(GAME_BOARD_X, GAME_BOARD_Y, GAME_BOARD_WIDTH, GAME_BOARD_WIDTH);

        drawMelons(g);

        h1.draw(g);
        h2.draw(g);
        h3.draw(g);
        h4.draw(g);
        
        if (startGame) {
            updateMelons();
            checkHippoEating(h1);
            checkHippoEating(h2);
            checkHippoEating(h3);
            checkHippoEating(h4);
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_S) {
            startGame = true;
        } else if (keyCode == KeyEvent.VK_1) {
            h1.eat();
        } else if (keyCode == KeyEvent.VK_2) {
            h2.eat();
        } else if (keyCode == KeyEvent.VK_3) {
            h3.eat();
        } else if (keyCode == KeyEvent.VK_4) {
            h4.eat();
        }
    }

    ArrayList<Melon> melons;

    public void setup() {
        melons = new ArrayList<>();

        int gameCenterX = HungryHungryHippos.GAME_BOARD_X + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
        int gameCenterY = HungryHungryHippos.GAME_BOARD_Y + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
        Random rand = new Random();

        for (int i = 0; i < NUM_MELONS; i++) {
            int x = gameCenterX + Melon.RADIUS + 20 - rand.nextInt(40);
            int y = gameCenterY + Melon.RADIUS + 20 - rand.nextInt(40);
            melons.add(new Melon(x, y));
        }
        
        String instructions = "Press '1', '2', '3', '4' to make the hippos eat\n";
        instructions += "Press 's' to start";
        JOptionPane.showMessageDialog(null, instructions);
    }

    public void addMelon() {
        melons.add(new Melon(GAME_WIDTH / 2, GAME_HEIGHT / 2));
    }

    public void drawMelons(Graphics g) {
        if (melons != null) {
            for (Melon melon : melons) {
                melon.draw(g);
            }
        }
    }

    public void updateMelons() {
        for (Melon melon : melons) {
            melon.update();
        }
    }

    public void checkHippoEating(Hippo hippo) {
        if (hippo.isEating) {
            Iterator<Melon> melonIterator = melons.iterator();

            while (melonIterator.hasNext()) {
                Melon melon = melonIterator.next();
                if (hippo.collisionBox.intersects(melon.collisionBox)) {
                    hippo.melonsEaten++;
                    melonIterator.remove();
                }
            }
        }
    }
}
