import processing.core.*;
import processing.event.KeyEvent;


public class GameWorld{
    Player p;
    Bullets bullets; 
    
    public GameWorld(Player p , Bullets bullets) {
        this.p = p;
        this.bullets = bullets; 
    }
    
    public PApplet draw(PApplet c) {
    	c.background(255);
    	p.draw(c);
    	bullets.draw(c);

        return c;
    }
    
    public GameWorld update() {
    	return new GameWorld(p.updatePlayer(), bullets.updateBullets());
    }
    
    
    public GameWorld keyPressed(KeyEvent key) {

    	return new GameWorld( p.keyPress(key), bullets.addBullets(p, key));
  }
    
    public GameWorld keyReleased(KeyEvent key) {
        p.keyReleased(key);
        return this;
    }
    
    
}

/**

import processing.core.*;
import java.util.*;


public class GameWorld extends PApplet{
    
 
    

    

    
}

*/
