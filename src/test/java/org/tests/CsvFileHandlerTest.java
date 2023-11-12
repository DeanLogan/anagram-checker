package org.tests;

import org.classes.CsvFileHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CsvFileHandlerTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private CsvFileHandler csvFileHandler;
    private File testFile;

    @Before
    public void setUp() throws IOException {
        // Create a temporary CSV file for testing
        testFile = tempFolder.newFile("testfile.csv");
        csvFileHandler = new CsvFileHandler(testFile.getAbsolutePath());
    }

    @After
    public void tearDown() {
        tempFolder.delete();
    }

    @Test
    public void testAppendToFile() throws IOException {
        // Append content to the test file
        String contentToAppend = "Test content";
        csvFileHandler.appendToFile(contentToAppend);

        // Read the file content and check if it contains the appended content
        String fileContent = readFileContents(testFile);
        assertTrue(fileContent.contains(contentToAppend));
    }

    @Test
    public void testReadFile() throws IOException {
        // Write content to the test file
        String contentToWrite = "";
        writeContentToFile(testFile, contentToWrite);

        // Read the content from the file using the CsvFileHandler
        String fileContent = csvFileHandler.readFile();

        // Ensure that the content read from the file matches the content that was written
        assertEquals(contentToWrite, fileContent);
    }

    private void writeContentToFile(File file, String content) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
    }

    private String readFileContents(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }
}
