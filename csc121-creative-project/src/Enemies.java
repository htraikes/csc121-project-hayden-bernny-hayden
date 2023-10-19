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
	
	  public PApplet draw(PApplet c) {
		  for (int i = enemies.size() - 1; i >= 0; i--) {
			    Enemy enemy = enemies.get(i);
			    enemy.draw(c);
			  }
		  return c;
	  }
	  
	   public Enemies updateEnemies(){
		  if(counter % 3 == 0) {
	    	  for (int i = 0; i < enemies.size(); i++) {
	  		    Enemy enemy = enemies.get(i);
	  		    enemy.updateEnemy();
	  		  }
		   }
		   counter++;
  	  return this;
		   
    }
}
