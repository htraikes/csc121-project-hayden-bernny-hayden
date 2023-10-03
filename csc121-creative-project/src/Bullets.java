import java.util.ArrayList;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Bullets {
	ArrayList<Bullet> bullets;
	
	public Bullets() {
		bullets = new ArrayList<>();
	}
	
	  public PApplet draw(PApplet c) {
		  
			  for (int i = bullets.size() - 1; i >= 0; i--) {
				    Bullet bullet = bullets.get(i);
				    
				    bullet.draw(c);
				    if (bullet.isOffscreen()) {
				      bullets.remove(i);
				    }
				  }
		  
		  return c;
		  }
	  
    public Bullets updateBullets(){
    	
	    	  for (int i = bullets.size() - 1; i >= 0; i--) {
	  		    Bullet bullet = bullets.get(i);
	  		    bullet.update();
	  		  }
    	
    	  return this;
      }
    
    public Bullets addBullets(Player p, KeyEvent key){
    	if (key.getKeyCode() == 32) {
    		
    		Bullet newBullet = new Bullet(p.playerX + p.playerWidth / 2, p.playerY);
    		bullets.add(newBullet);
    		
    		return this;
  		  }
    	
    	return this;
    }
}
