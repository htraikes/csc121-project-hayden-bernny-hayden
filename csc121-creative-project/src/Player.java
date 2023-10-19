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
	  private float playerYSpeed;
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
		   
		   pTop = playerX;
		   pBottom = playerX + getPlayerWidth();
		   pRight = playerX + playerHeight;
		   pLeft = getPlayerY();
		   
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
	  public boolean isHit(Bullet b) {
	    if (b.getbRight() >= pLeft && b.getbLeft() <= pRight) {
	      if (b.getbTop() <= pBottom && b.getbBottom() >= pTop) {
	        this.dead = true;
	        return true;
	      }
	    }
	    return false;
	  }


	public float getPlayerX() {
		return playerX;
	}


	public void setPlayerX(float playerX) {
		this.playerX = playerX;
	}


	public int getPlayerWidth() {
		return playerWidth;
	}


	public void setPlayerWidth(int playerWidth) {
		this.playerWidth = playerWidth;
	}


	public float getPlayerY() {
		return playerY;
	}


	public void setPlayerY(float playerY) {
		this.playerY = playerY;
	}


	public boolean isMovingRight() {
		return movingRight;
	}


	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}


	public boolean isMovingLeft() {
		return movingLeft;
	}


	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}
	  

	  

	  

}


