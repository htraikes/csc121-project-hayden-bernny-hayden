import processing.core.PApplet;
import processing.event.KeyEvent;





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
		   this.playerYSpeed = 7;
		   this.playerHeight = 25;
		   this.playerWidth = 25;
	  }
	  
	
	  
	  //show player
	  public PApplet draw(PApplet c) {
	    c.fill(0, 0, 255);
	    c.rect(this.playerX, playerY, playerWidth, playerHeight);
	    return c;
	  }
	  
	  public void keyReleased(KeyEvent key) {
		    if (key.getKeyCode() == 39) {
		        movingRight = false;
		    } else if (key.getKeyCode() == 37) {
		        movingLeft = false;
		    }
		}
	  
	  public Player keyPress(KeyEvent key) {
		  
		  		 if (key.getKeyCode() == 39) {
		  	    	//p.movingRight = true;
		  			 
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
	  
	  
	  

	  //move player
	  public Player updatePlayer() {
	    if (movingRight == true) {
	    	this.playerX += this.playerXSpeed;
	    	return this;
	    }
	     if (movingLeft == true) {
	    	 this.playerX -= this.playerXSpeed;
	    	 return this;
	    }else {
	    	return this;
	    }
	  } 
	  

	  

	  

}


