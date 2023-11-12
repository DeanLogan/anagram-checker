package org.classes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * AnagramCache is a class that implements the Cache interface to provide a caching mechanism for storing
 * and managing the results of anagrams checks.
 */
public class AnagramCache implements Cache {

    // A map to store the cache data where keys are string combinations and values are results
    private final Map<String, String> cacheStorage;
    private final Logger logger = Logger.getLogger(AnagramCache.class.getName());


    /**
     * Constructor for AnagramCache. Initializes the cache storage and populates it by reading data from a file.
     */
    public AnagramCache() {
        cacheStorage = new HashMap<>();
        populateCache();
    }

    /**
     * Populates the cache by reading data from a file and storing it in the cache storage.
     */
    @Override
    public void populateCache() {
        org.classes.FileHandler csvFileHandler = FileHandlerFactory.createFileHandler("csv");
        String fileContent = "";
        try {
            fileContent = csvFileHandler.readFile();
            logger.info("Cache populated from file.");
        } catch (IOException e) {
            logger.severe("Error while populating cache from file: " + e.getMessage());
            throw new RuntimeException(e);
        }

        for (String line : fileContent.split(System.lineSeparator())) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String key = parts[0] + "," + parts[1];
                cacheStorage.put(key, parts[2]);
            }
        }
    }

    /**
     * Prints the contents of the cache to the console.
     */
    @Override
    public void printCacheContents() {
        logger.info("Printing cache contents.");
        System.out.println("Cache Contents:");
        for (Map.Entry<String, String> entry : cacheStorage.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    /**
     * Adds a result to the cache for a given pair of strings and specifies whether they are anagrams.
     *
     * @param str1       The first string in the pair.
     * @param str2       The second string in the pair.
     * @param areAnagrams A boolean indicating whether the strings are anagrams.
     */
    @Override
    public void addToCache(String str1, String str2, boolean areAnagrams) {
        String cacheKey = generateCacheKey(str1, str2);
        if (areAnagrams) {
            cacheStorage.put(cacheKey, "Anagrams");
        } else {
            cacheStorage.put(cacheKey, "Not Anagrams");
        }
        logger.info("Added result to cache: " + cacheKey + " => " + (areAnagrams ? "Anagrams" : "Not Anagrams"));
    }

    /**
     * Checks if a given cache key represents a result of anagrams.
     *
     * @param cacheKey The cache key to check.
     * @return true if the cache key represents anagrams, false otherwise.
     */
    @Override
    public boolean checkCacheKeyResult(String cacheKey) {
        boolean result = "Anagrams".equals(cacheStorage.get(cacheKey));
        logger.info("Checked cache for key: " + cacheKey + " => " + (result ? "Anagrams" : "Not Anagrams"));
        return result;
    }

    /**
     * Retrieves the cache key for a given pair of strings, taking into account that the order of strings doesn't matter.
     *
     * @param str1 The first string in the pair.
     * @param str2 The second string in the pair.
     * @return The cache key for the combination of the two strings, or null if it's not in the cache.
     */
    @Override
    public String combinationStoredInCache(String str1, String str2) {
        String firstKey = generateCacheKey(str1, str2);
        String secondKey = generateCacheKey(str2, str1);
        String cacheKey = null;
        if (cacheStorage.containsKey(firstKey)) {
            cacheKey = firstKey;
        } else if (cacheStorage.containsKey(secondKey)) {
            cacheKey = secondKey;
        }
        if (cacheKey != null) {
            logger.info("Cache hit for combination: " + str1 + " and " + str2);
        } else {
            logger.info("Cache miss for combination: " + str1 + " and " + str2);
        }
        return cacheKey;
    }

    /**
     * Generates a cache key for a pair of strings by concatenating them.
     *
     * @param str1 The first string in the pair.
     * @param str2 The second string in the pair.
     * @return The cache key generated from the two strings.
     */
    @Override
    public String generateCacheKey(String str1, String str2) {
        return str1 + "," + str2;
    }

    /**
     * Saves the contents of the cache to a file.
     */
    @Override
    public void saveCacheToFile() {
        FileHandler csvFileHandler = FileHandlerFactory.createFileHandler("csv");
        StringBuilder contentBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry : cacheStorage.entrySet()) {
            String cacheEntry = entry.getKey() + "," + entry.getValue();
            contentBuilder.append(cacheEntry);
            contentBuilder.append(System.lineSeparator());
        }

        try {
            csvFileHandler.appendToFile(contentBuilder.toString());
            logger.info("Cache saved to file.");
        } catch (IOException e) {
            logger.severe("Error while saving cache to file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
