import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Enemies {
	private ArrayList<Enemy> enemies;
	PImage img;
	int counter;
	public Enemies(PImage enemyImg, PImage explosion) {
		enemies = new ArrayList<>();
		counter = 0;
		
		for(int i = 1; i < 7; i++) {
			Enemy en = new Enemy(i * 50, 30, enemyImg, explosion);
			enemies.add(en);
		}
	}
	
	public void removeDead() {
		if (counter % 30 == 0) {
			for (int i = enemies.size() - 1; i >= 0; i--){
				if (enemies.get(i).isDead()) {
					enemies.remove(i);
				}
			}
			
		}
		counter++;
	}
	
	  public PApplet draw(PApplet c) {
		 this.removeDead();
		  for (int i = enemies.size() - 1; i >= 0; i--) {
			    Enemy enemy = enemies.get(i);
			    if (enemy.isDead()) {
			    	
			    }
			    enemy.draw(c);
			  }
		  
		  return c;
		  
	  }
	  
	   public Enemies updateEnemies(Bullets b){
		   
		   
		   for (int i = 0; i < enemies.size(); i++) {
			   Enemy enemy = enemies.get(i);
			   enemy.updateEnemy(b);
			   
		   }
		   
		   
  	  return this;
		   
    }
	   
	   public boolean gameOver() {
		   return enemies.size() == 0 || enemies.get(0).gameOver();
	   }
}
