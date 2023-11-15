import java.io.*;
import java.util.*;
import processing.core.*;

public class Leaderboard {
	 static Dictionary<Integer, String> records = new Hashtable<>();
	 ArrayList<Enumeration<Integer>> scores;
	 Enemies e;
	
	
	Leaderboard(Dictionary<Integer, String> records, ArrayList<Enumeration<Integer>> scores, Enemies e){
		Leaderboard.records = records;
		this.scores = scores;
		this.e = e;
	}
	
	public PApplet draw(PApplet p) {
		
		
		
		
		
		//place items into scores Arraylist, sort it, then draw it
		for (int i = 0; i < records.size(); i++) {
			Enumeration<Integer> e = records.keys();
			
			scores.add(e);
		}
		Collections.sort(scores);
		//
		
		
		return p;
	}
	
	public Leaderboard update() {
		System.out.println("Enter your name: ");
		
		//scanner for getting name
		Scanner kb = new Scanner(System.in);
		String name = kb.nextLine();
		int score = e.getScore();
		records.put(score, name);
		
		//print out record to leaderboard.txt
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("leaderboard.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println(score + " " + name);
		
		kb.close();
			
		return this;
		//open output file
		
	
	}
}
