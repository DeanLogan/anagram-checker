package org.classes;

import java.io.IOException;

/**
 * The Cache interface defines methods for managing a cache that stores and retrieves data efficiently.
 */
public interface Cache {

    /**
     * Populates the cache with data, typically from an external source.
     *
     * @throws IOException if there is an error reading or loading data into the cache.
     */
    void populateCache() throws IOException;

    /**
     * Prints the contents of the cache for debugging or informational purposes.
     */
    void printCacheContents();

    /**
     * Adds a new entry to the cache, associating it with the given strings and anagrams status.
     *
     * @param str1         The first string.
     * @param str2         The second string.
     * @param areAnagrams  A boolean indicating whether the strings are anagrams.
     */
    void addToCache(String str1, String str2, boolean areAnagrams);

    /**
     * Checks whether a cache entry with a specific key represents a result of anagrams.
     *
     * @param cacheKey The key to check.
     * @return true if the cache entry represents anagrams, false otherwise.
     */
    boolean checkCacheKeyResult(String cacheKey);

    /**
     * Retrieves a cache key for a given pair of strings, taking into account that the order of strings doesn't matter.
     *
     * @param str1 The first string in the pair.
     * @param str2 The second string in the pair.
     * @return The cache key for the combination of the two strings, or null if it's not in the cache.
     */
    String combinationStoredInCache(String str1, String str2);

    /**
     * Generates a cache key for a pair of strings, which is used for indexing cache entries.
     *
     * @param str1 The first string in the pair.
     * @param str2 The second string in the pair.
     * @return The cache key generated from the two strings.
     */
    String generateCacheKey(String str1, String str2);

    /**
     * Saves the contents of the cache to an external storage, such as a file.
     *
     * @throws IOException if there is an error writing the cache data to the storage.
     */
    void saveCacheToFile() throws IOException;
}
