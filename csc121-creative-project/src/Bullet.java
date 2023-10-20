import processing.core.PApplet;

/*
 * Represent a single bullet with x & y position and constant speed
 */
public class Bullet {
	  private float x;
	  private float y;
	  private float speed = 5; // Bullet speed
	  
	  private float bTop;
	  private float bBottom;
	  private float bRight;
	  private float bLeft;
	  
	  
	  
	  Bullet(float x, float y) {
	    this.x = x;
	    this.y = y;
	    
	    setbTop(y-1);
	    setbBottom(y + 1);
	    setbRight(x + 1);
	    setbLeft(x-1);

	  }
	  

	  /*
	   * Draws a single bullet on the 'canvas'
	   */
	  public PApplet draw(PApplet c) {
	    c.fill(255, 0, 0); // Red color for bullets
	    c.noStroke();
	    c.ellipse(x, y, 10, 10); // Adjust the size and shape as needed
	    return c;
	  }
	  
	  /*
	   * Determines if a Bullets has flown off the screen
	   */
	  boolean isOffscreen() {
	    return y < 0;
	  }
	  

	  
	  /*
	   * returns an updated bullet to a new y position
	   */
	  public Bullet update() {
		  
		  if (this.y < 400){
			  this.y = y-=speed;
			   setbTop(y-1);
			   setbBottom(y + 1);
			  return this;
		  } else {
			  return this;
		  }
	  }


	/*
	 * returns the bullet left hitbox boundary 
	 */
	public float getbLeft() {
		return bLeft;
	}


	/*
	 * sets the bullet left hitbox boundary 
	 */
	public void setbLeft(float bLeft) {
		this.bLeft = bLeft;
	}


	/*
	 * returns the bullet right hitbox boundary 
	 */
	public float getbRight() {
		return bRight;
	}


	/*
	 * sets the bullet right hitbox boundary 
	 */
	public void setbRight(float bRight) {
		this.bRight = bRight;
	}


	/*
	 * returns the bullet top hitbox boundary 
	 */
	public float getbTop() {
		return bTop;
	}


	/*
	 * sets the bullet top hitbox boundary 
	 */
	public void setbTop(float bTop) {
		this.bTop = bTop;
	}


	/*
	 * returns the bullet bottom hitbox boundary 
	 */
	public float getbBottom() {
		return bBottom;
	}


	/*
	 * sets the bullet bottom hitbox boundary 
	 */
	public void setbBottom(float bBottom) {
		this.bBottom = bBottom;
	}
	}
