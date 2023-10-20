import java.util.ArrayList;

import processing.core.PApplet;

public class Enemies {
	private ArrayList<Enemy> enemies;
	private int counter;
	
	public Enemies() {
		enemies = new ArrayList<>();
		counter = 0;
		
		for(int i = 1; i < 7; i++) {
			Enemy en = new Enemy(i * 25, 30);
			enemies.add(en);
		}
	}
	
	public void removeDead() {
		for (int i = enemies.size() - 1; i >= 0; i--){
			if (enemies.get(i).isDead()) {
				enemies.remove(i);
			}
		}
	}
	
	  public PApplet draw(PApplet c) {
		  for (int i = enemies.size() - 1; i >= 0; i--) {
			    Enemy enemy = enemies.get(i);
			    enemy.draw(c);
			  }
		  return c;
	  }
	  
	   public Enemies updateEnemies(Bullets b){
		   this.removeDead();
		   
		  if(counter % 3 == 0) {
	    	  for (int i = 0; i < enemies.size(); i++) {
	  		    Enemy enemy = enemies.get(i);
	  		    enemy.updateEnemy(b);
	  		  }
		   }
		   counter++;
  	  return this;
		   
    }
}
