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
	    
	    setbTop(x);
	    setbBottom(y + 10);
	    setbRight(x + 10);
	    setbLeft(x);
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
			  return new Bullet(this.x, y-=speed);
		  } else {
			  return this;
		  }
	  }


	public float getbLeft() {
		return bLeft;
	}


	public void setbLeft(float bLeft) {
		this.bLeft = bLeft;
	}


	public float getbRight() {
		return bRight;
	}


	public void setbRight(float bRight) {
		this.bRight = bRight;
	}


	public float getbTop() {
		return bTop;
	}


	public void setbTop(float bTop) {
		this.bTop = bTop;
	}


	public float getbBottom() {
		return bBottom;
	}


	public void setbBottom(float bBottom) {
		this.bBottom = bBottom;
	}
	}
