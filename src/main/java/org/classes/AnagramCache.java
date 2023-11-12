package org.classes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnagramCache {
    private final Map<String, String> cacheStorage;

    public AnagramCache(){
        cacheStorage = new HashMap<>();
        populateCache();
    }

    public void populateCache() {
        FileHandler fileHandler = new FileHandler();
        String fileContent = "";
        try {
            fileContent = fileHandler.readFile();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : fileContent.split(System.lineSeparator())) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String key = parts[0] + "," + parts[1]; // Use the same key format as for cache
                cacheStorage.put(key, parts[2]);
            }
        }
    }

    public void printCacheContents() {
        System.out.println("Cache Contents:");
        for (Map.Entry<String, String> entry : cacheStorage.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public void addToCache(String str1, String str2, boolean areAnagrams) {
        // Create a key by concatenating the two strings
        String cacheKey = generateCacheKey(str1, str2);

        // Store the result in the cache
        if (areAnagrams) {
            cacheStorage.put(cacheKey, "Anagrams");
        } else {
            cacheStorage.put(cacheKey, "Not Anagrams");
        }
    }

    public boolean checkCacheKeyResult(String cacheKey){
        return "Anagrams".equals(cacheStorage.get(cacheKey));
    }

    public String combinationStoredInCache(String str1, String str2){
        String firstKey = generateCacheKey(str1, str2);
        String secondKey = generateCacheKey(str2, str1);
        if (cacheStorage.containsKey(firstKey)) {
            return firstKey;
        }
        else if (cacheStorage.containsKey(secondKey)){
            return secondKey;
        }
        return null;
    }

    public String generateCacheKey(String str1, String str2){
        return str1 + "," + str2;
    }

    public void saveCacheToFile() {
        FileHandler fileHandler = new FileHandler();
        StringBuilder contentBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry : cacheStorage.entrySet()) {
            String cacheEntry = entry.getKey() + "," + entry.getValue();
            contentBuilder.append(cacheEntry);
            contentBuilder.append(System.lineSeparator());
        }

        // Call the appendToFile method to write the content to the file
        try {
            fileHandler.appendToFile(contentBuilder.toString());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
