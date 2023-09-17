import processing.core.*;
import java.util.*;


public class GameWorld extends PApplet{
    Player p;
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    
    public void settings() {
        this.size(400, 400);
        
    }

    public void setup() {
        p = new Player(200);
    }
    
    public void draw() {
        p.draw(this);
        
		  for (int i = bullets.size() - 1; i >= 0; i--) {
			    Bullet bullet = bullets.get(i);
			    bullet.update();
			    bullet.draw(this);
			    if (bullet.isOffscreen()) {
			      bullets.remove(i);
			    }
			  }
    }
    
    public void keyPressed() {
    	  if (key == CODED) {
    	    
    		 if (keyCode == RIGHT) {
    	    	p.movingRight = true;
    	    	
    	      
    	    } else if (keyCode == LEFT) {
    	    	p.movingLeft = true;
    	    	
    	    } 
    	  	} else {
    	  		p.movingLeft = false;
    	  		p.movingRight = false;
    	  	}
    	  p = p.move();
    	  
    	  if (keyPressed && key == ' ') {
    		    bullets.add(new Bullet(p.playerX + p.playerWidth / 2, p.playerY));
    		  }
    		  

    }
    
    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "GameWorld" }, new GameWorld());
    }
    
}
