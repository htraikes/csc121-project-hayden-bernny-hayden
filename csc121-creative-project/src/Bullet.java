import processing.core.PApplet;

public class Bullet {
	  float x;
	  float y;
	  float speed = 5; // Bullet speed
	  
	  Bullet(float x, float y) {
	    this.x = x;
	    this.y = y;
	  }
	  

	  
	  public PApplet draw(PApplet c) {
	    c.fill(255, 0, 0); // Red color for bullets
	    c.noStroke();
	    c.ellipse(x, y, 10, 10); // Adjust the size and shape as needed
	    return c;
	  }
	  
	  boolean isOffscreen() {
	    return y < 0;
	  }
	  
	  public Bullet update() {
		  
		  if (this.y < 400){
			  return new Bullet(this.x, y-=speed);
		  } else {
			  return this;
		  }
	  }
	}
