import processing.core.*;
import processing.event.KeyEvent;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class GameApp extends PApplet{
	GameWorld gw;
	PImage playerImg;
	PImage enemyImg;
	PImage bulletImg;
	PImage explosion;
	
    public void settings() {
        this.size(400, 400);

    }
    
    public void setup() {
    	playerImg = loadImage("/images/Player.png"); 
    	bulletImg = loadImage("/images/Bullet.png"); 
    	enemyImg = loadImage("/images/Enemy.png");
    	explosion = loadImage("/images/Explosion.png");
    	playerImg.mask(playerImg);
    	textAlign(CENTER, CENTER);  // Set the text alignment to center
    	textSize(64);
    	fill(255);
    	gw = new GameWorld(new Player(200, playerImg) , new Bullets(bulletImg), enemyImg, explosion);
    	
    }
    
    public void draw() {
    	if (gw.gameOver()) {
    		fill(255); 
    	    text("GAME OVER", width/2, height/2); 
    	}else {
        	gw = gw.update();
        	gw.draw(this);
    	}

         
    }
    
    public void keyPressed(KeyEvent kev) {
        gw = gw.keyPressed(kev);
    }
    
    public void keyReleased(KeyEvent kev) {
    	gw = gw.keyReleased(kev);
    }
    
    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "GameApp" }, new GameApp());
    }
    
}

