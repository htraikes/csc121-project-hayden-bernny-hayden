import java.util.ArrayList;

import processing.core.PApplet;

public class Enemy {
	  private float enemyX;
	  private float enemyY;
	  // private float enemyXSpeed;
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
		   // this.enemyXSpeed = 7;
		   this.enemyYSpeed = 1;
		   this.enemyHeight = 20;
		   this.enemyWidth = 20;
		   
		   this.eTop = (float) (enemyY - (enemyHeight));
		   this.eBottom = (float) (enemyY + (enemyHeight));
		   this.eLeft = (float) (enemyX - (enemyWidth));
		   this.eRight = (float) (enemyX + (enemyWidth));
		   
		  
		   this.dead = false;
		   
		   
		   
	  }
	     
	  public PApplet draw(PApplet c) {
		    c.fill(255, 0, 0);
		    c.rect(enemyX, enemyY, enemyWidth, enemyHeight);
		    return c;
		  }

	  public Enemy updateEnemy(Bullets b) {
		  ArrayList<Bullet> bullets = b.giveBullets();
		  
		  for(int i = 0; i < bullets.size(); i++) {
			  this.isHit(bullets.get(i));
		  }
		  
		  enemyY = enemyY + enemyYSpeed;
		  return this;
	  }
	  
	  /*
	   * Determines if a bullet comes in contact with an enemy
	   */
	  public void isHit(Bullet b) {
		    if  ( (b.getbTop() < eBottom) && ( (b.getbRight() > eLeft && b.getbLeft() < eLeft) ||  ( (b.getbLeft() < eRight) && (b.getbRight() > eRight)) || ( (b.getbLeft() > eLeft)
		    		&& (b.getbRight() < eRight)))){
		        this.dead = true;
		    }
		    //(b.getbRight() <= eRight && b.getbLeft() >= eLeft && b.getbTop() < eTop && b.getbBottom() > eBottom)
		  }
	  
	  /*
	   * determines if *this* enemy is dead
	   */
	  public boolean isDead() {
		  return this.dead;
	  }

}
