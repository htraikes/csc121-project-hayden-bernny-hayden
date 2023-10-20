import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemy extends PApplet{
	  private float enemyX;
	  private float enemyY;
	  // private float enemyXSpeed;
	  private float enemyYSpeed;
	  private int enemyWidth;
	  private int enemyHeight;
	  PImage img;
	  PImage explosion;
	  private float eTop;
	  private float eBottom;
	  private float eLeft;
	  private float eRight;
	  
	  private boolean dead;
	  private int counter;
	  
	  Enemy(float enemyX, float enemyY, PImage img, PImage explosion){
		   this.enemyX = enemyX;
		   this.enemyY = enemyY;
		   // this.enemyXSpeed = 7;
		   this.enemyYSpeed = 1;
		   this.enemyHeight = 20;
		   this.enemyWidth = 20;
		   this.img = img;
		   this.eTop = (float) (enemyY - (enemyHeight));
		   this.eBottom = (float) (enemyY + (enemyHeight));
		   this.eLeft = (float) (enemyX - (enemyWidth));
		   this.eRight = (float) (enemyX + (enemyWidth));
		   counter = 0;
		   this.explosion = explosion;
		   this.dead = false;
		   
		   
		   
	  }
	     
	  public PApplet draw(PApplet c) {
		  if (!dead) {
			    c.fill(255, 0, 0);
			    c.imageMode(CORNER);
			    c.image(img, enemyX , enemyY , enemyWidth, enemyHeight);
			    return c;
		  } else {
			  c.fill(255, 0, 0);
			  c.imageMode(CORNER);
			  c.image(explosion, enemyX , enemyY , enemyWidth, enemyHeight);
			  return c;
		  }
		  		
		  }

	  public Enemy updateEnemy(Bullets b) {
		  ArrayList<Bullet> bullets = b.giveBullets();
		  
		  for(int i = 0; i < bullets.size(); i++) {
			  this.isHit(bullets.get(i));
			  if(this.dead) {
				  return this;
			  }
		  }
		  
		  if (counter % 3 == 0 && !dead) {
			  enemyY = enemyY + enemyYSpeed;
		  }
		  counter++;
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
	  
	  public boolean gameOver() {
		  return enemyY > 400;
	  }

}
