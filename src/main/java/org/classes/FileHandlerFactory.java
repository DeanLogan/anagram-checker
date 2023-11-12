package org.classes;

/**
 * FileHandlerFactory is a factory class responsible for creating instances of classes that implement the FileHandler interface.
 */
public class FileHandlerFactory {

    /**
     * Creates and returns an instance of a file handler based on the specified file type.
     *
     * @param fileType The type of file handler to create.
     * @return A FileHandler instance corresponding to the specified file type, or null if the type is empty or unknown.
     * @throws IllegalArgumentException if an unknown file type is provided.
     */
    public static FileHandler createFileHandler(String fileType) {
        if (fileType == null || fileType.isEmpty()) {
            return null;
        } else if (fileType.equals("csv")) {
            return new CsvFileHandler();
        }
        throw new IllegalArgumentException("Unknown file type " + fileType);
    }
}
