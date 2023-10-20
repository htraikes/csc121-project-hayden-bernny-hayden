import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * Represents a player that can move
 */
public class Player {
	  private boolean movingRight;
	  private boolean movingLeft;
	  private float playerX;
	  private float playerY;
	  private float playerXSpeed;
	  private int playerWidth;
	  private int playerHeight;
	  
	  private float pTop;
	  private float pBottom;
	  private float pRight;
	  private float pLeft;
	  
	  private boolean dead;
	  
	  
	  
	  Player(float playerX){
		   this.setPlayerX(playerX);
		   this.setPlayerY(350);
		   this.playerXSpeed = 7;
		   this.playerHeight = 25;
		   this.setPlayerWidth(25);
		   
		   pLeft = (float) (playerX - (playerWidth));
		   pRight = (float) (playerX + (playerWidth));
		   pTop = (float) (playerY - (playerHeight));
		   pBottom = (float) (playerY + (playerHeight));
		   
		   this.dead = false;
		  
	  }
	  	
	  
	  /**
	   * Draw rectangle at players current position
	   */
	  public PApplet draw(PApplet c) {
	    c.fill(0, 0, 255);
	    c.rect(this.getPlayerX(), getPlayerY(), getPlayerWidth(), playerHeight);
	    return c;
	  }
	  
	  /**
	   * Changes the boolean values of moving(Right or Left) depending on the key event to allow the player to mvoe
	   */
	  public Player keyPress(KeyEvent key) {
		  
		  		 if (key.getKeyCode() == PApplet.RIGHT) {

		  			this.setMovingLeft(false);
		  			this.setMovingRight(true);
		  			
		  	    } else if (key.getKeyCode() == 37) {
		  			this.setMovingLeft(true);
		  			this.setMovingRight(false);
		  			
		  	    } else {
		  			this.setMovingLeft(false);
		  			this.setMovingRight(false);
		  	    }
		  		return this;
		  	  
	  }
	  
	  /*
	   * Resets the moving(Right or Left) value once the appropriate Key is released
	   */
	  public void keyReleased(KeyEvent key) {
		    if (key.getKeyCode() == 39) {
		        setMovingRight(false);
		    } else if (key.getKeyCode() == 37) {
		        setMovingLeft(false);
		    }
		}
	  

	  /*
	   * Changes the PlayerX position according to if the player is moving(Right or Left)
	   */
	  public Player updatePlayer() {
	    if (isMovingRight() == true) {
	    	this.setPlayerX(this.getPlayerX() + this.playerXSpeed);
	    	
	    }
	     if (isMovingLeft() == true) {
	    	 this.setPlayerX(this.getPlayerX() - this.playerXSpeed); 
	    }
	    	return this;
	  } 
	  
	  /*
	   * Determines if a bullet is in contact with a player
	   */
	  public void isHit(Bullet b) {
	    if (b.getbRight() < pRight && b.getbLeft() > pLeft && b.getbTop() > pTop && b.getbBottom() <= pBottom) {
	        this.dead = true;
	    }
	    
	  }

	  
	  /*
	   * returns the player x position
	   */
	public float getPlayerX() {
		return playerX;
	}


	  /*
	   * sets the player x position
	   */
	public void setPlayerX(float playerX) {
		this.playerX = playerX;
	}


	  /*
	   * returns the player width
	   */
	public int getPlayerWidth() {
		return playerWidth;
	}

	  /*
	   * sets the player width position
	   */
	public void setPlayerWidth(int playerWidth) {
		this.playerWidth = playerWidth;
	}


	  /*
	   * returns the player Y position
	   */
	public float getPlayerY() {
		return playerY;
	}


	  /*
	   * sets the player Y position
	   */
	public void setPlayerY(float playerY) {
		this.playerY = playerY;
	}


	  /*
	   * determines if the player is moving right
	   */
	public boolean isMovingRight() {
		return movingRight;
	}


	  /*
	   * sets the player moving right
	   */
	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}


	  /*
	   * determines if the player is moving left
	   */
	public boolean isMovingLeft() {
		return movingLeft;
	}


	  /*
	   * sets the player moving left
	   */
	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}
	
	
	  /*
	   * determines if *this* player 
	   */
	public boolean isDead() {
		return this.dead;
	}
	  

	  

	  

}


