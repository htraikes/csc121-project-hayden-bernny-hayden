import java.io.*;
import java.util.*;

public class GameLeaderboard {
    private static final String LEADERBOARD_FILE = "leaderboard.txt";
    private static final int MAX_SCORES = 5;

    // Load scores from the file
    public static List<Score> loadScores() {
        List<Score> scores = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LEADERBOARD_FILE))) {
            while (true) {
                try {
                    Score score = (Score) ois.readObject();
                    scores.add(score);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            // Handle the exception, e.g., file not found or unable to read
            e.printStackTrace();
        }

        return scores;
    }

    // Save scores to the file
    public static void saveScores(List<Score> scores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LEADERBOARD_FILE))) {
            for (Score score : scores) {
                oos.writeObject(score);
            }
        } catch (IOException e) {
            // Handle the exception, e.g., unable to write to the file
            e.printStackTrace();
        }
    }

    // Update the leaderboard with a new score
    public static void updateLeaderboard(Score newScore) {
        List<Score> scores = loadScores();

        // Add the new score
        scores.add(newScore);

        // Sort the scores in descending order
        scores.sort(Comparator.comparingInt(Score::getScore).reversed());

        // Keep only the top MAX_SCORES scores
        if (scores.size() > MAX_SCORES) {
            scores = scores.subList(0, MAX_SCORES);
        }

        // Save the updated scores to the file
        saveScores(scores);
    }

    // Display the leaderboard
    public static void displayLeaderboard() {
        System.out.println("===== Leaderboard =====");
        List<Score> scores = loadScores();
        for (int i = 0; i < scores.size(); i++) {
            System.out.println((i + 1) + ". " + scores.get(i));
        }
        System.out.println("=======================");
    }
}
