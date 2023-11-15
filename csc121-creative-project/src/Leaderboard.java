import java.io.*;
import java.util.*;
import processing.core.*;

public class Leaderboard extends Enemies{
	public static Dictionary<String, Integer> records = new Hashtable<>();
	public ArrayList<Integer> scores;
	
	
	Leaderboard(Dictionary<String, Integer> records, ArrayList<Integer> scores){
		Leaderboard.records = records;
		this.scores = scores;
		super(enemyImg, explosion);
	}
	
	public PApplet draw(PApplet p) {
		//place items into scores Arraylist, sort it, then draw it
		for (int i = 0; i < records.size(); i++) {
			scores.add(records.get(i));
		}
		Collections.sort(scores);
		return p;
	}
	
	public Leaderboard update() {
		System.out.println("Enter your name: ");
		
		//scanner for getting name
		Scanner kb = new Scanner(System.in);
		String name = kb.nextLine();
		int score = getScore();
		records.put(name, score);
		
		//print out record to leaderboard.txt
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("leaderboard.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println(score + " " + name);
			
		return this;
		//open output file
	}
}
