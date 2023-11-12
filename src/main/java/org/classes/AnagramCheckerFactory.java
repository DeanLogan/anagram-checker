package org.classes;

/**
 * AnagramCheckerFactory is a factory class responsible for creating instances of the AnagramChecker class.
 */
public class AnagramCheckerFactory {
    /**
     * Creates and returns a new instance of the AnagramChecker class.
     *
     * @return A new AnagramChecker instance.
     */
    public static AnagramChecker createAnagramChecker() {
        return new AnagramChecker();
    }
}
