import processing.core.PApplet;




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
	    c.background(255);
	    c.fill(0, 0, 255);
	    c.rect(playerX, playerY, playerWidth, playerHeight);
	    return c;
	  }
	  
	  //move player
	  public Player move() {
	    if (movingRight == true) {
	    	return new Player(playerX += playerXSpeed);
	    }
	     if (movingLeft == true) {
	    	 return new Player(playerX -= playerXSpeed);
	    }else {
	    	return this;
	    }
	  } 
	  

	  

	  

}


