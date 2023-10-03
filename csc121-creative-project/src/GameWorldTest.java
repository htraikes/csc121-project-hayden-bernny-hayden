import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import processing.event.KeyEvent;

class GameWorldTest {
	
	//creates a player for the test class
	Player pOne = new Player(200);
	
	//creates a Bullets object for the test class
	Bullets bOne = new Bullets();

	GameWorld gOne = new GameWorld(pOne, bOne);
	
	@Test
	void gameWorldTest() {
		// ensures that player and bullets are not updated before anything is done
		assertEquals(gOne.p.updatePlayer(), gOne.p);
		assertEquals(gOne.bullets.updateBullets(), gOne.bullets);
		  
		//checks to see if keyPressed is updating GameWorlds players position correctly
		//RIGHT MOVE
		KeyEvent rightEvent = new KeyEvent(null, 0, 0, 0, (char) (39), 39) ;
		gOne.keyPressed(rightEvent);
		gOne.update();
		
		assertEquals(gOne.p.movingRight, true);
		
		gOne.keyReleased(rightEvent);
		
		assertEquals(gOne.p.movingRight, false);
		assertEquals(gOne.p.playerX, 207);
		
		//LEFTMOVE
		KeyEvent leftEvent = new KeyEvent(null, 0, 0, 0, (char) (37), 37) ;
		gOne.keyPressed(leftEvent);
		gOne.update();
		
		assertEquals(gOne.p.movingLeft, true);
		
		gOne.keyReleased(leftEvent);
		
		assertEquals(gOne.p.movingLeft, false);
		assertEquals(gOne.p.playerX, 200);
		
		//checks to see if keyPressed is updating GameWorlds Bullets correctly
		KeyEvent spaceEvent = new KeyEvent(null, 0, 0, 0, (char) (32), 32) ;
		gOne.keyPressed(spaceEvent);
		gOne.update();
		
	}

}