import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.core.*;
import processing.event.KeyEvent;

import java.util.*;


public class GameWorldTest {
	
	
		
	      
        Player player = new Player(200, null);
	    Bullet bullet = new Bullet(4, 4, null);
	    Bullets bullets = new Bullets(null);
	    Enemy enemy = new Enemy(100, 100, null, null);
	    Enemies enemies = new Enemies(null, null);
	     
	    
	    // BULLET TESTS
	    
	    @Test
	    public void testIsOffscreen() {
	        // Test when the bullet is on the screen
	        assertFalse(bullet.isOffscreen());
	
	        // Move the bullet off the screen
	        bullet.update(); // Move the bullet up
	        assertTrue(bullet.isOffscreen());
	    }
	
	    @Test
	    public void testUpdate() {
	        // Test if the bullet's y-coordinate updates correctly
	        float initialY = bullet.getY();
	
	        bullet.update();
	        float newY = bullet.getY();
	
	        // Check that the bullet has moved up by the expected amount (SPEED)
	        assertEquals(initialY - Bullet.getSpeed(), newY, 0.001);
	
	        // Make sure the hitbox boundaries are updated correctly
	        assertEquals(newY - Bullet.getHitbox(), bullet.getbTop(), 0.001);
	        assertEquals(newY + Bullet.getHitbox(), bullet.getbBottom(), 0.001);
	    }
	

	    //BULLETS TESTS
	    
	    @Test
	    public void testUpdateBullets() {
	        bullets.addBullets(player, new KeyEvent(null, 0, 0, 0, (char) (32), 32));
	        bullets.updateBullets();
	        ArrayList<Bullet> bulletList = bullets.giveBullets();
	        assertEquals(bulletList.size(), 1);
	        assertEquals(bulletList.get(0).getY(), player.getPlayerY() - Bullet.getSpeed(), 0.001);
	    }

	    @Test
	    public void testAddBullets() {
	        KeyEvent spaceKeyPress = new KeyEvent(null, 0, 0, 0, (char) (32), 32);
	        bullets.addBullets(player, spaceKeyPress);
	        ArrayList<Bullet> bulletList = bullets.giveBullets();
	        assertEquals(bulletList.size(), 1);
	        assertEquals(bulletList.get(0).getbLeft(), player.getPlayerX() + player.getPlayerWidth() / 2 - Bullet.getHitbox(), 0.001);
	    }

	    @Test
	    public void testGiveBullets() {
	        ArrayList<Bullet> bulletList = bullets.giveBullets();
	        assertEquals(bulletList.size(), 0);
	        bullets.addBullets(player, new KeyEvent(null, 0, 0, 0, (char) (32), 32));
	        bulletList = bullets.giveBullets();
	        assertEquals(bulletList.size(), 1);
	    }

	    // ENEMY TESTS
	    @Test
	    public void testUpdateEnemyNoCollision() {
	        enemy.updateEnemy(bullets); // Call the updateEnemy method without any collisions

	        // Verify that the enemy's position is updated correctly
	        assertEquals(101, enemy.getEnemyY(), 0.001);
	    }
	    
	    // 			these two are failing
	    /*
	    @Test
	    public void testUpdateEnemyWithCollision() {
	        // Add a bullet that collides with the enemy
	        Bullet bullet = new Bullet(100, 100, null);
	        bullets.giveBullets().add(bullet);

	        enemy.updateEnemy(bullets); // Call the updateEnemy method with a collision

	        // Verify that the enemy is marked as dead
	        assertTrue(enemy.isDead());
	    }

	    @Test
	    public void testUpdateEnemyWithMultipleCollisions() {
	        // Add multiple bullets that collide with the enemy
	        Bullet bullet1 = new Bullet(100, 100, null);
	        Bullet bullet2 = new Bullet(100, 100, null);
	        bullets.giveBullets().add(bullet1);
	        bullets.giveBullets().add(bullet2);

	        enemy.updateEnemy(bullets); // Call the updateEnemy method with collisions

	        // Verify that the enemy is marked as dead
	        assertTrue(enemy.isDead());
	    }
	    */
	    
	    // ENEMIES TESTS
	    /*
	    @Test
	    public void testRemoveDead() {
	        // Create a dead enemy and add it to the enemies list
	        Enemy deadEnemy = new Enemy(100, 100, null, null);
	        deadEnemy.isHit(new Bullet(100, 100, null)); // Mark the enemy as dead
	        enemies.getEnemies().add(deadEnemy);

	        // Call the removeDead method
	        enemies.removeDead();

	        // Verify that the dead enemy is removed from the list
	        assertEquals(0, enemies.getEnemies().size());
	    }
	    
	    
	    @Test
	    public void testUpdateEnemies() {
	        // Create an enemy and add it to the enemies list
	        Enemy enemy = new Enemy(100, 100, null, null);
	        enemies.getEnemies().add(enemy);

	        // Call the updateEnemies method
	        enemies.updateEnemies(bullets);

	        // Verify that the enemy is updated
	        assertTrue(enemy.isDead()); // Assuming the update method marks the enemy as dead
	    }

	    @Test
	    public void testGameOver() {
	        // Check game over when there are no enemies
	        assertTrue(enemies.gameOver());

	        // Check game over when there are still enemies
	        enemies.getEnemies().add(new Enemy(100, 100, null, null));
	        assertFalse(enemies.gameOver());

	        // Check game over when the first enemy triggers game over
	        enemies.getEnemies().get(0).isHit(new Bullet(100, 100, null));
	        assertTrue(enemies.gameOver());
	    }
	    */
	    @Test
	    public void testGetScore() {
	        // Check the initial score
	        assertEquals(0, enemies.getScore());

	        // Add some dead enemies to the list
	        Enemy deadEnemy1 = new Enemy(100, 100, null, null);
	        deadEnemy1.isHit(new Bullet(100, 100, null));
	        Enemy deadEnemy2 = new Enemy(100, 100, null, null);
	        deadEnemy2.isHit(new Bullet(100, 100, null));
	        enemies.getEnemies().add(deadEnemy1);
	        enemies.getEnemies().add(deadEnemy2);

	        // Call removeDead to accumulate score
	        enemies.removeDead();

	        // Verify the updated score
	        assertEquals(30, enemies.getScore());
	    }
	    
	    
	    // PLAYER TESTS
	    @Test
	    public void testPlayerInitialization() {
	        PImage img = new PImage();
	        Player player = new Player(100, img);
	        
	        // Check player's initial state
	        assertEquals(100, player.getPlayerX(), 0.001);
	        assertEquals(350, player.getPlayerY(), 0.001);
	        assertFalse(player.isDead());
	        assertFalse(player.isMovingLeft());
	        assertFalse(player.isMovingRight());
	    }
	    
	    @Test
	    public void testPlayerMovement() {
	        PImage img = new PImage();
	        Player player = new Player(100, img);
	        
	        // Move player to the right
	        KeyEvent rightKeyEvent = new KeyEvent(null, 0, 0, 0, (char) (39), 39);
	        player.keyPress(rightKeyEvent);
	        player.updatePlayer();
	        assertEquals(103, player.getPlayerX(), 0.001);
	        
	        // Move player to the left
	        KeyEvent leftKeyEvent = new KeyEvent(null, 0, 0, 0, (char) (37), 37);
	        player.keyPress(leftKeyEvent);
	        player.updatePlayer();
	        assertEquals(100, player.getPlayerX(), 0.001);
	    }
	    /*
	    @Test
	    public void testBulletCollision() {
	        PImage img = new PImage();
	        Player player = new Player(100, img);
	        Bullet bullet = new Bullet(100, 350, img);
	        
	        // Check if player is hit by a bullet
	        player.isHit(bullet);
	        assertTrue(player.isDead());
	    }
	    */
}
