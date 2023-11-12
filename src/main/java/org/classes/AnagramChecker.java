package org.classes;

import java.io.IOException;
import java.util.Arrays;

public class AnagramChecker {
    private final AnagramCache anagramCache;

    public AnagramChecker(){
        anagramCache = new AnagramCache();
    }

    public void saveResultToFile(String str1, String str2, boolean areAnagrams){
        FileHandler fileHandler = new FileHandler();
        String result = "Not Anagrams";
        if (areAnagrams) {
            result = "Anagrams";
        }
        try {
            fileHandler.appendToFile(str1+","+str2+","+result+"\n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean areAnagrams(String str1, String str2){
        str1 = str1.replaceAll(" ","").toLowerCase();
        str2 = str2.replaceAll(" ","").toLowerCase();

        // Checks the cache
        String cacheKey = anagramCache.combinationStoredInCache(str1, str2); // Checks if either possible combinations of the cache key is present in the HashMap (is null if neither is in the HashMap)
        if(cacheKey != null){
            return anagramCache.checkCacheKeyResult(cacheKey);
        }

        // If not in the cache, perform the anagram check
        boolean areAnagrams = false;
        if (str1.length() == str2.length()){
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            areAnagrams = Arrays.equals(charArray1, charArray2);
        }
        // Populate the cache with the result
        anagramCache.addToCache(str1, str2, areAnagrams);
        // Populate the external file with the result
        saveResultToFile(str1, str2, areAnagrams);
        anagramCache.printCacheContents();
        return areAnagrams;
    }
}
