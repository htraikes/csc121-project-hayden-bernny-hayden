import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * Represents a player that can move
 */
public class Player {
	  boolean movingRight;
	  boolean movingLeft;
	  float playerX;
	  float playerY;
	  float playerXSpeed;
	  float playerYSpeed;
	  int playerWidth;
	  int playerHeight;
	  
	  Player(float playerX){
		   this.playerX = playerX;
		   this.playerY = 350;
		   this.playerXSpeed = 7;
		   this.playerHeight = 25;
		   this.playerWidth = 25;
	  }
	  
	
	  
	  /**
	   * Draw rectangle at players current position
	   */
	  public PApplet draw(PApplet c) {
	    c.fill(0, 0, 255);
	    c.rect(this.playerX, playerY, playerWidth, playerHeight);
	    return c;
	  }
	  
	  /**
	   * Changes the boolean values of moving(Right or Left) depending on the key event to allow the player to mvoe
	   */
	  public Player keyPress(KeyEvent key) {
		  
		  		 if (key.getKeyCode() == 39) {

		  			this.movingLeft = false;
		  			this.movingRight = true;
		  			
		  	    } else if (key.getKeyCode() == 37) {
		  			this.movingLeft = true;
		  			this.movingRight = false;
		  			
		  	    } else {
		  			this.movingLeft = false;
		  			this.movingRight = false;
		  	    }
		  		return this;
		  	  
	  }
	  
	  /*
	   * Resets the moving(Right or Left) value once the appropriate Key is released
	   */
	  public void keyReleased(KeyEvent key) {
		    if (key.getKeyCode() == 39) {
		        movingRight = false;
		    } else if (key.getKeyCode() == 37) {
		        movingLeft = false;
		    }
		}
	  

	  /*
	   * Changes the PlayerX position according to if the player is moving(Right or Left)
	   */
	  public Player updatePlayer() {
	    if (movingRight == true) {
	    	this.playerX += this.playerXSpeed;
	    	
	    }
	     if (movingLeft == true) {
	    	 this.playerX -= this.playerXSpeed;
	    	 
	    }
	    	return this;
	    
	  } 
	  

	  

	  

}


