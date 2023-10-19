import processing.core.PApplet;

public class Enemy {
	  float enemyX;
	  float enemyY;
	  float enemyXSpeed;
	  float enemyYSpeed;
	  int enemyWidth;
	  int enemyHeight;
	  
	  float eTop;
	  float eBottom;
	  float eLeft;
	  float eRight;
	  
	  boolean dead;
	  
	  
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
	  void hitbox(Bullet b) {
	    if (b.bRight >= eLeft && b.bLeft <= eRight) {
	      if (b.bTop <= eBottom && b.bBottom >= eTop) {
	        this.dead = true;
	      }
	    }
	  }

}
