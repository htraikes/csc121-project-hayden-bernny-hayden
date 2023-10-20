import processing.core.*;
import processing.event.KeyEvent;

/**
 * Represents an interactive application where a player can move and hit 
 * enemies with ships while moving and enemies firing back
 */
public class GameWorld {
    private Player p;
    private Bullets bullets;
    private Enemies enemies;
    
    private static final int TEXT_SIZE_World = 20;
    private static final int TEXT_COLOR_World = 255;

    /**
     * Creates a game world given a Player object, a Bullets object, and enemy images
     */
    public GameWorld(Player p, Bullets bullets, PImage enemyImg, PImage explosion) {
        this.p = p;
        this.bullets = bullets;
        enemies = new Enemies(enemyImg, explosion);
    }

    /**
     * Renders a picture of the Player and Bullets on the canvas
     */
    public PApplet draw(PApplet c) {
        enemies.removeDead();
        c.background(0);
        p.draw(c);
        bullets.draw(c);
        enemies.draw(c);
        c.textAlign(PConstants.TOP, PConstants.RIGHT); // Set the text alignment to center
        c.textSize(TEXT_SIZE_World);
        c.fill(TEXT_COLOR_World);
        String score = this.getScore();
        c.text(("SCORE: " + score), c.width - 90, 40);
        

        return c;
    }

    /**
     * Checks if the game is over
     */
    public boolean gameOver() {
        return enemies.gameOver();
    }

    /**
     * Produces an updated world where the player moves left or right and the bullets fly up the screen
     */
    public GameWorld update() {
        enemies.updateEnemies(bullets);
        p.updatePlayer();
        bullets.updateBullets();
        return this;
    }

    /**
     * Produces an updated world where the player moves and adds bullets to the Bullets class
     */
    public GameWorld keyPressed(KeyEvent key) {
        p = p.keyPress(key);
        bullets.addBullets(p, key);
        return this;
    }

    /**
     * Produces an updated world where the player is not allowed to move
     */
    public GameWorld keyReleased(KeyEvent key) {
        p.keyReleased(key);
        return this;
    }
    
    public String getScore() {
    	return enemies.getScore() +"";
    }
}


    
 
    

    

    

