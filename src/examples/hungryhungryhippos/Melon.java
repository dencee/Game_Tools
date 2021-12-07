package examples.hungryhungryhippos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Melon {
    static final int RADIUS = 10;
    static final int DIAMETER = 2 * RADIUS;
    int x, y;
    double xSpeed;
    double ySpeed;
    double angle;
    int speed;
    Rectangle collisionBox;
    
    boolean insideBoard = true;

    public Melon(int x, int y) {
        /*
         * X/Y center of circle, not upper left corner
         */
        this.x = x - RADIUS;
        this.y = y - RADIUS;

        collisionBox = new Rectangle(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
        
        speed = new Random().nextInt(10) + 5;
        angle = Math.toRadians(new Random().nextDouble() * 360);
        xSpeed = Math.sin(angle) * speed;
        ySpeed = -Math.cos(angle) * speed;
    }

    void update() {
        
        x += xSpeed;
        y += ySpeed;
        
        checkCollision();
    }

    void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);
    }

    boolean checkCollision() {
        float gameBoardCenterX = HungryHungryHippos.GAME_BOARD_X + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
        float gameBoardCenterY = HungryHungryHippos.GAME_BOARD_Y + (HungryHungryHippos.GAME_BOARD_WIDTH / 2);
        float distX = gameBoardCenterX - x;
        float distY = gameBoardCenterY - y;
        double distance = Math.sqrt((distX * distX) + (distY * distY));
        
        collisionBox.setBounds(x - RADIUS, y - RADIUS, DIAMETER, DIAMETER);

        if( insideBoard && distance >= (HungryHungryHippos.GAME_BOARD_WIDTH / 2) - RADIUS) {
            double tangent = Math.atan2(distY, distX);
            this.angle = (2 * tangent) - this.angle;

            xSpeed = Math.sin(angle) * speed;
            ySpeed = -Math.cos(angle) * speed;
            
            insideBoard = false;
            return true;
        }
        
        insideBoard = true;
        return false;
    }
}