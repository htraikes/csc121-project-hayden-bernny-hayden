import processing.core.*;
import processing.event.KeyEvent;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class GameApp extends PApplet {
    private GameWorld gw;
    private static PImage playerImg;
    private static PImage enemyImg;
    private static PImage bulletImg;
    private static PImage explosion;

    private static final int SCREEN_SIZE = 400;
    private static final int PLAYER_START_POSITION = 200;
    private static final int TEXT_SIZE = 64;
    private static final int TEXT_COLOR = 255;

    public void settings() {
        this.size(SCREEN_SIZE, SCREEN_SIZE);
    }

    public void setup() {
        // Load images for player, bullets, enemies, and explosions
        playerImg = loadImage("images/Player.png");
        bulletImg = loadImage("images/Bullet.png");
        enemyImg = loadImage("images/Enemy.png");
        explosion = loadImage("images/Explosion.png");
        playerImg.mask(playerImg); // Apply mask to the player image
         

        // Initialize the game world with player, bullets, enemies, and explosions
        gw = new GameWorld(new Player(PLAYER_START_POSITION, playerImg), new Bullets(bulletImg), enemyImg, explosion);
    }

    public void draw() {
        // Check if the game is over, display appropriate text if it is, otherwise update and draw the game
        if (gw.gameOver()) {
        	textAlign(CENTER, CENTER);// Set the text alignment to center
            textSize(TEXT_SIZE);
            fill(TEXT_COLOR);
            fill(TEXT_COLOR);
            text("GAME OVER", width / 2, height / 2);
            
        } else {
            gw = gw.update();
            gw.draw(this);
        }
    }

    // Handle key press events
    public void keyPressed(KeyEvent kev) {
        gw = gw.keyPressed(kev);
    }

    // Handle key release events
    public void keyReleased(KeyEvent kev) {
        gw = gw.keyReleased(kev);
    }

    // Main method to run the Processing sketch
    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "GameApp" }, new GameApp());
    }
}