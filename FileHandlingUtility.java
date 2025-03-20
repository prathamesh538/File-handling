package filehandling;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandlingUtility {
    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        writeFile("Hello, this is a test file.\nWelcome to File Handling in Java.");
        readFile();
        modifyFile("test", "sample");
        readFile();
    }

    // Method to write to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\nReading File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content
    public static void modifyFile(String oldWord, String newWord) {
        try {
            Path path = Paths.get(FILE_PATH);
            List<String> lines = Files.readAllLines(path);
            List<String> modifiedLines = new ArrayList<>();

            for (String line : lines) {
                modifiedLines.add(line.replaceAll(oldWord, newWord));
            }
            Files.write(path, modifiedLines);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
