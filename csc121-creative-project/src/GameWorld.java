import processing.core.*;
import processing.event.KeyEvent;

/**
 * Represents an interactive application where a player can move and hit 
 * enemies with ships while moving and enemies firing back
 */
public class GameWorld{
    Player p;
    Bullets bullets; 
    Enemies enemies;
    PImage enemyImg;
    
    /**
     * Creates a game world given a Player object and Bullets object
     */
    public GameWorld(Player p , Bullets bullets, PImage enemyImg, PImage explosion) {
        this.p = p;
        this.bullets = bullets;
        enemies = new Enemies(enemyImg, explosion);
    }
    
    /**
     * Renders a picture of the Player and Bullets
     */
    public PApplet draw(PApplet c) {
    	enemies.removeDead();
    	c.background(0);
    	p.draw(c);
    	bullets.draw(c);
    	enemies.draw(c);
    	
        return c;
    }
    
    public boolean gameOver() {
    	return enemies.gameOver();
    }
    
    /**
     * Produces an updated world where the player moves
     * left or right and the bullets flying up the screen
     */
    public GameWorld update() {
    	enemies.updateEnemies(bullets);
    	p.updatePlayer();
    	bullets.updateBullets();
    	return this;
    }
    
    /**
     * Produces an updated world which changes values to allow the player to move and add bullets to the Bullets class
     */
    public GameWorld keyPressed(KeyEvent key) {
    	p = p.keyPress(key);
    	bullets = bullets.addBullets(p, key);
    	return this;
  }
    
    /**
     * Produces an updated world which changes values to not allow the player to move.
     */
    public GameWorld keyReleased(KeyEvent key) {
        p.keyReleased(key);
        return this;
    }
    
    /**public String toString() {
        return "[" + x + ", " + y + "]";
    }
    */
}


    
 
    

    

    

