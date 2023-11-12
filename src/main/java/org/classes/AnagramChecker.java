package org.classes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    private final Map<String, String> anagramCache;

    public AnagramChecker(){
        anagramCache = new HashMap<>();
        addToCache("silent","listen", true);
    }

    public void printCacheContents() {
        System.out.println("Cache Contents:");
        for (Map.Entry<String, String> entry : anagramCache.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public void addToCache(String str1, String str2, boolean areAnagrams) {
        // Create a key by concatenating the two strings
        String cacheKey = generateCacheKey(str1, str2);

        // Store the result in the cache
        if (areAnagrams) {
            anagramCache.put(cacheKey, "Anagrams");
        } else {
            anagramCache.put(cacheKey, "Not Anagrams");
        }
    }

    public boolean checkCacheKeyResult(String cacheKey){
        return "Anagrams".equals(anagramCache.get(cacheKey));
    }

    public String combinationStoredInCache(String str1, String str2){
        String firstKey = generateCacheKey(str1, str2);
        String secondKey = generateCacheKey(str2, str1);
        if (anagramCache.containsKey(firstKey)) {
            return firstKey;
        }
        else if (anagramCache.containsKey(secondKey)){
            return secondKey;
        }
        return null;
    }

    public String generateCacheKey(String str1, String str2){
        return str1 + ":" + str2;
    }

    public boolean areAnagrams(String str1, String str2){
        str1 = str1.replaceAll(" ","").toLowerCase();
        str2 = str2.replaceAll(" ","").toLowerCase();

        // Check if the result is already in the cache, the two combinations of the strings need to be checked as HashMaps check for exact matches in the key
        String cacheKey = combinationStoredInCache(str1, str2);
        if(cacheKey != null){
            return checkCacheKeyResult(cacheKey);
        }

        // If not in the cache, perform the anagram check
        if (str1.length() != str2.length()){
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        boolean areAnagrams = Arrays.equals(charArray1, charArray2);

        // Populate the cache with the result
        addToCache(str1, str2, areAnagrams);

        printCacheContents();

        return areAnagrams;
    }
}
