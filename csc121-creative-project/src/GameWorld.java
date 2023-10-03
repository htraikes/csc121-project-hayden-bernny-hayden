import processing.core.*;
import processing.event.KeyEvent;

/**
 * Represents an interactive application where a player can move and hit 
 * enemies with ships while moving and enemies firing back
 */
public class GameWorld{
    Player p;
    Bullets bullets; 
    
    /**
     * Creates a game world given a Player object and Bullets object
     */
    public GameWorld(Player p , Bullets bullets) {
        this.p = p;
        this.bullets = bullets; 
    }
    
    /**
     * Renders a picture of the Player and Bullets
     */
    public PApplet draw(PApplet c) {
    	c.background(255);
    	p.draw(c);
    	bullets.draw(c);

        return c;
    }
    
    /**
     * Produces an updated world where the player moves
     * left or right and the bullets flying up the screen
     */
    public GameWorld update() {
    	return new GameWorld(p.updatePlayer(), bullets.updateBullets());
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


    
 
    

    

    

