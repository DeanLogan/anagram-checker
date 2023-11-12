package org.classes;

import java.io.IOException;
import java.util.Arrays;

/**
 * AnagramChecker is a class that implements the IAnagramChecker interface to determine if two strings are anagrams.
 * It also manages caching and saving results to a file.
 */
public class AnagramChecker implements IAnagramChecker {
    private final Cache anagramCache;

    /**
     * Constructor for AnagramChecker. Initializes the cache and file handler for storing anagram results.
     */
    public AnagramChecker() {
        anagramCache = CacheFactory.createCache("anagram");
    }

    /**
     * Saves the result of an anagram check to a file, along with the two input strings and the result.
     *
     * @param str1         The first string to check for anagrams.
     * @param str2         The second string to check for anagrams.
     * @param areAnagrams  A boolean indicating whether the strings are anagrams.
     */
    public void saveResultToFile(String str1, String str2, boolean areAnagrams) {
        CsvFileHandler csvFileHandler = new CsvFileHandler();
        String result = "Not Anagrams";
        if (areAnagrams) {
            result = "Anagrams";
        }
        try {
            csvFileHandler.appendToFile(str1 + "," + str2 + "," + result + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if two strings are anagrams by comparing their sorted character arrays.
     * It first checks the cache for the result, and if not found, performs the anagram check,
     * then stores the result in the cache and saves it to a file.
     *
     * @param str1  The first string to check for anagrams.
     * @param str2  The second string to check for anagrams.
     * @return true if the strings are anagrams, false otherwise.
     */
    public boolean areAnagrams(String str1, String str2) {
        if(str1 == null || str2 == null){
            return false;
        }
        str1 = str1.replaceAll(" ", "").toLowerCase();
        str2 = str2.replaceAll(" ", "").toLowerCase();

        if(!str1.matches("[a-zA-Z]+") && !str2.matches("[a-zA-Z]+")){
            return false;
        }

        // Checks the cache
        String cacheKey = anagramCache.combinationStoredInCache(str1, str2); // Checks if either possible combinations of the cache key is present in the HashMap (is null if neither is in the HashMap)
        if (cacheKey != null) {
            return anagramCache.checkCacheKeyResult(cacheKey);
        }

        // If not in the cache, perform the anagram check
        boolean areAnagrams = false;
        if (str1.length() == str2.length()) {
            char[] charArray1 = str1.toCharArray();
            charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            areAnagrams = Arrays.equals(charArray1, charArray2);
        }
        // Populate the cache with the result
        anagramCache.addToCache(str1, str2, areAnagrams);
        // Populate the external file with the result
        saveResultToFile(str1, str2, areAnagrams);
        return areAnagrams;
    }
}
