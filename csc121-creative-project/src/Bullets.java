import java.util.ArrayList;
import processing.core.PApplet;
import processing.event.KeyEvent;

/*
 * Represents a list of bullets that will appear on the 'canvas'
 */
public class Bullets {
	ArrayList<Bullet> bullets;
	
	public Bullets() {
		bullets = new ArrayList<>();
	}

	/*
	 * draws the ArrayList of Bullets on the screen
	 */
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
	  
  /*
   * updates all the bullets in the ArrayList to a new y position
   */
    public Bullets updateBullets(){
    	
	    	  for (int i = bullets.size() - 1; i >= 0; i--) {
	  		    Bullet bullet = bullets.get(i);
	  		    bullet.update();
	  		  }
    	  return this;
      }
    
    /*
     * if ' ' is pressed it will add a new bullet to the Array list at the players x position
     */
    public Bullets addBullets(Player p, KeyEvent key){
    	if (key.getKeyCode() == 32) {
    		
    		Bullet newBullet = new Bullet(p.playerX + p.playerWidth / 2, p.playerY);
    		bullets.add(newBullet);
    		
    		return this;
  		  }
    	
    	return this;
    }
}
