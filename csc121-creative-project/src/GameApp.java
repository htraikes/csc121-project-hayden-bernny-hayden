import java.util.ArrayList;

import processing.core.*;
import processing.event.KeyEvent;


public class GameApp extends PApplet{
	GameWorld gw;
	
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
    	gw = new GameWorld(new Player(200) , new ArrayList<>());
    }
    
    public void draw() {
    	gw = gw.update();
    	gw.draw(this);
        
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

