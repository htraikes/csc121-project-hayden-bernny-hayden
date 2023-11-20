import java.io.*;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

/*
 * Represents a collection of enemy objects on the screen, manages their behavior and interactions with other game elements.
 */
public class Enemies {
    private ArrayList<Enemy> enemies;
    private int counter;
    private int score;

    private static final int ENEMY_CREATION_INCREMENT = 20; // Periodically remove dead enemies after this count
    private static final String LEADERBOARD_FILE = "leaderboard.txt";

    public Enemies(PImage enemyImg, PImage explosion) {
        enemies = new ArrayList<>();
        counter = 0;

        for (int i = 1; i < 7; i++) {
            Enemy en = new Enemy(i * 50, 30, enemyImg, explosion);
            enemies.add(en);
        }
    }

    // Removes dead enemies from the list periodically
    public void removeDead() {
        if (counter % ENEMY_CREATION_INCREMENT == 0) {
            for (int i = enemies.size() - 1; i >= 0; i--) {
                if (enemies.get(i).isDead()) {
                    enemies.remove(i);
                    updateScore(15);
                }
            }
        }
        counter++;
    }

    // Draws all enemies on the screen
    public PApplet draw(PApplet c) {
        this.removeDead();
        for (int i = enemies.size() - 1; i >= 0; i--) {
            Enemy enemy = enemies.get(i);
            if (enemy.isDead()) {
                // Handle when the enemy is dead
            }
            enemy.draw(c);
        }
        return c;
    }

    // Updates all enemies according to the Bullets
    public Enemies updateEnemies(Bullets b) {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            enemy.updateEnemy(b);
        }
        return this;
    }
    
    private void updateScore(int points) {
        score += points;

       
    }

 

    // Checks if the game is over
    public boolean gameOver() {
        return enemies.size() == 0 || enemies.get(0).gameOver();
    }
    
    public int getScore() {
    	return this.score;
    }

    
    // returns the enemies
    public ArrayList<Enemy> getEnemies() {
    	return enemies;
    }
    


}
