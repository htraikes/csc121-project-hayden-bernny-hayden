import processing.core.PApplet;

public class Enemy {
	  float enemyX;
	  float enemyY;
	  float enemyXSpeed;
	  float enemyYSpeed;
	  int enemyWidth;
	  int enemyHeight;
	  
	  
	  Enemy(float enemyX, float enemyY){
		   this.enemyX = enemyX;
		   this.enemyY = enemyY;
		   this.enemyXSpeed = 7;
		   this.enemyYSpeed = 1;
		   this.enemyHeight = 20;
		   this.enemyWidth = 20;
		   
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

}
