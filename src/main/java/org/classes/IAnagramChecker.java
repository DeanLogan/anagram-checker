package org.classes;

import java.io.IOException;

/**
 * The IAnagramChecker interface defines methods for checking whether two strings are anagrams
 * and for saving the result to a file.
 */
public interface IAnagramChecker {

    /**
     * Saves the result of an anagram check to a file, along with the two input strings and the result.
     *
     * @param str1         The first string to check for anagrams.
     * @param str2         The second string to check for anagrams.
     * @param areAnagrams  A boolean indicating whether the strings are anagrams.
     * @throws IOException if there is an error while saving the result to a file.
     */
    void saveResultToFile(String str1, String str2, boolean areAnagrams) throws IOException;

    /**
     * Checks whether two strings are anagrams.
     *
     * @param str1 The first string to check for anagrams.
     * @param str2 The second string to check for anagrams.
     * @return true if the strings are anagrams, false otherwise.
     */
    boolean areAnagrams(String str1, String str2);
}
