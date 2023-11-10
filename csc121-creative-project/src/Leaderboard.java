import java.io.*;
import java.util.*;
import processing.core.*;

public class Leaderboard extends Enemies{
	public static Dictionary<Integer, String> records = new Hashtable<>();
	
	
	Leaderboard(Dictionary<Integer, String> records){
		Leaderboard.records = records;
		super(Enemies);
	}
	
	public void draw(PApplet p) {
		//sort the dictionary, then draw it
		Collections.sort((Dictionary<Integer,String>) records);
	}
	
	public Leaderboard update() {
		System.out.println("Enter your name: ");
		
		//scanner for getting name
		Scanner kb = new Scanner(System.in);
		String name = kb.nextLine();
		records.put(score, name);
		
		//print out record to leaderboard.txt
		PrintWriter pw = new PrintWriter("leaderboard.txt");
		pw.println(score + " " + name);
			
		
		//open output file
	}
}
