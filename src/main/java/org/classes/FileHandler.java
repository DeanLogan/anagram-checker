package org.classes;

import java.io.IOException;

/**
 * The FileHandler interface defines methods for reading and appending content to files.
 */
public interface FileHandler {

    /**
     * Reads the content from a file and returns it as a string.
     *
     * @return The content of the file as a string.
     * @throws IOException if there is an error while reading from the file.
     */
    String readFile() throws IOException;

    /**
     * Appends the provided content to a file.
     *
     * @param content The content to append to the file.
     * @throws IOException if there is an error while writing to the file.
     */
    void appendToFile(String content) throws IOException;
}
