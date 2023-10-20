import processing.core.PApplet;

public class Enemy {
	  private float enemyX;
	  private float enemyY;
	  private float enemyXSpeed;
	  private float enemyYSpeed;
	  private int enemyWidth;
	  private int enemyHeight;
	  
	  private float eTop;
	  private float eBottom;
	  private float eLeft;
	  private float eRight;
	  
	  private boolean dead;
	  
	  
	  Enemy(float enemyX, float enemyY){
		   this.enemyX = enemyX;
		   this.enemyY = enemyY;
		   this.enemyXSpeed = 7;
		   this.enemyYSpeed = 1;
		   this.enemyHeight = 20;
		   this.enemyWidth = 20;
		   
		   this.eTop = enemyY;
		   this.eBottom = enemyY + enemyHeight;
		   this.eLeft = enemyX;
		   this.eRight = enemyX + enemyWidth;
		   
		   dead = false;
		   
		   
		   
	  }
	     
	  public PApplet draw(PApplet c) {
		    c.fill(255, 0, 0);
		    c.rect(enemyX, enemyY, enemyWidth, enemyHeight);
		    return c;
		  }

	  public Enemy updateEnemy() {
		  enemyY = enemyY + enemyYSpeed;
		  return this;
	  }
	  
	  /*
	   * Determines if a bullet comes in contact with an enemy
	   */
	  public boolean isHit(Bullet b) {
		    if (b.getbRight() >= eLeft && b.getbLeft() <= eRight) {
		      if (b.getbTop() <= eBottom && b.getbBottom() >= eTop) {
		        this.dead = true;
		        return true;
		      }
		    }
		    return false;
		  }
	  
	  /*
	   * determines if *this* enemy is dead
	   */
	  public boolean isDead() {
		  return this.dead;
	  }

}
