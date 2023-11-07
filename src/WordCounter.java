import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        // Check for the correct usage
        if (args.length != 2) {
            System.out.println("Usage: java WordCounter <input file> <output file>");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        // Using a HashMap to keep track of word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert to lowercase to handle case-insensitivity
                line = line.toLowerCase();

                // Increment the count for the word
                wordCounts.put(line, wordCounts.getOrDefault(line, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading from input file: " + e.getMessage());
            System.exit(2);
        }

        // Write the word counts to the output file
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            wordCounts.forEach((word, count) -> writer.println(word + " " + count));
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
            System.exit(3);
        }

        System.out.println("Word counting completed successfully!");
    }
}
