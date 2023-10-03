import processing.core.*;
import processing.event.KeyEvent;

import java.util.*;

public class GameWorld{
    Player p;
    ArrayList<Bullet> bullets; 
    
    public GameWorld(Player p , ArrayList<Bullet> bullets) {
        this.p = p;
        this.bullets = bullets; 
    }
    
    public PApplet draw(PApplet c) {
    	c.background(255);
    	
    	p.draw(c);
    	
	  for (int i = bullets.size() - 1; i >= 0; i--) {
		    Bullet bullet = bullets.get(i);
		    
		    bullet.draw(c);
		    if (bullet.isOffscreen()) {
		      bullets.remove(i);
		    }
		  }
    	
    	
        return c;
    }
    
    public ArrayList<Bullet> updateBullets(ArrayList<Bullet> curBullets){
  	  for (int i = curBullets.size() - 1; i >= 0; i--) {
		    Bullet bullet = curBullets.get(i);
		    bullet.update();
		  }
  	  
  	  return curBullets;
    }
    
    
    
    public GameWorld update() {
    	return new GameWorld(p.updatePlayer(), this.updateBullets(bullets));
    }
    
    
    public ArrayList<Bullet> addBullets(ArrayList<Bullet> curBullets, KeyEvent key){
    	if (key.getKeyCode() == 32) {
    		
    		Bullet newBullet = new Bullet(p.playerX + p.playerWidth / 2, p.playerY);
    		curBullets.add(newBullet);
    		
    		return curBullets;
  		  }
    	
    	return curBullets;
    }
    
    public GameWorld keyPressed(KeyEvent key) {

    	return new GameWorld( p.keyPress(key), this.addBullets(bullets, key));
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
