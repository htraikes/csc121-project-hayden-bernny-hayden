import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import processing.event.KeyEvent;

class GameWorldTest {
	
	//creates a player for the test class
	Player pOne = new Player(200);
	
	//creates a Bullets object for the test class
	Bullets bOne = new Bullets();
	
	//creates a singular bullet for test class that would NOT hit a player
	Bullet bTwo = new Bullet(0, 0);
	
	//creates a singular bullet for test class that WOULD hit a player
	Bullet bThree = new Bullet(200, 350);
	

	GameWorld gOne = new GameWorld(pOne, bOne);
	
	Enemy eOne = new Enemy(200, 350);
	
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
		
		assertEquals(gOne.p.isMovingRight(), true);
		
		gOne.keyReleased(rightEvent);
		
		assertEquals(gOne.p.isMovingRight(), false);
		assertEquals(gOne.p.getPlayerX(), 207);
		
		//LEFTMOVE
		KeyEvent leftEvent = new KeyEvent(null, 0, 0, 0, (char) (37), 37) ;
		gOne.keyPressed(leftEvent);
		gOne.update();
		
		assertEquals(gOne.p.isMovingLeft(), true);
		
		gOne.keyReleased(leftEvent);
		
		eOne.isHit(bThree);
		
		assertTrue(eOne.isDead());
		
		assertEquals(gOne.p.isMovingLeft(), false);
		assertEquals(gOne.p.getPlayerX(), 200);
		
		pOne.isHit(bThree);
		
		assertTrue(pOne.isDead());
		
		//checks to see if keyPressed is updating GameWorlds Bullets correctly
		KeyEvent spaceEvent = new KeyEvent(null, 0, 0, 0, (char) (32), 32) ;
		gOne.keyPressed(spaceEvent);
		gOne.update();
		
		
		
	}

}


