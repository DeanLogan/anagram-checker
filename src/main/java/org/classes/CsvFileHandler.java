package org.classes;

import java.io.*;
import java.util.logging.Logger;

/**
 * CsvFileHandler is a class that implements the FileHandler interface to handle CSV file operations.
 */
public class CsvFileHandler implements FileHandler {
    private final String filePath;
    private final Logger logger = Logger.getLogger(CsvFileHandler.class.getName());

    /**
     * Constructor with no parameters. Sets a default value for the file path.
     */
    public CsvFileHandler() {
        this.filePath = "output.csv";
    }

    /**
     * Constructor with a parameter to allow specifying the file path.
     *
     * @param filePath The path to the CSV file.
     */
    public CsvFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Appends the provided content to the CSV file.
     *
     * @param content The content to append to the file.
     * @throws IOException if there is an error while writing to the file.
     */
    public void appendToFile(String content) throws IOException {
        File file = new File(this.filePath);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(content);
            logger.info("Appended content to CSV file: " + content);
        } catch (IOException e) {
            logger.severe("Error while appending to CSV file: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Reads the content from the CSV file and returns it as a string.
     *
     * @return The content of the CSV file as a string.
     * @throws IOException if there is an error while reading from the file.
     */
    public String readFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            logger.info("Read content from CSV file.");
        } catch (IOException e) {
            logger.severe("Error while reading from CSV file: " + e.getMessage());
            throw e;
        }
        return content.toString();
    }
}
