package org.classes;
import java.io.*;

public class FileHandler {
    private final String filePath;

    // Constructor with no parameters (sets a default value for filePath)
    public FileHandler(){
        this.filePath = "output.txt";
    }

    // Constructor with a parameter to allow filePath to be specified
    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public void appendToFile(String content) throws IOException {
        File file = new File(this.filePath);
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(content);
        fileWriter.write(System.lineSeparator()); // Add a newline character
        fileWriter.close();
    }

    public String readFile() throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append(System.lineSeparator());
        }
        return content.toString();
    }
}