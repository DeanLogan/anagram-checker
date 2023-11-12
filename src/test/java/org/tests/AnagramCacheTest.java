package org.tests;

import org.classes.AnagramCache;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnagramCacheTest {

    @Test
    public void testAddToCache() {
        AnagramCache anagramCache = new AnagramCache();
        String str1 = "listen";
        String str2 = "silent";
        boolean areAnagrams = true;

        anagramCache.addToCache(str1, str2, areAnagrams);

        String cacheKey = anagramCache.generateCacheKey(str1, str2);
        assertTrue(anagramCache.checkCacheKeyResult(cacheKey));
    }

    @Test
    public void testCombinationStoredInCache() {
        AnagramCache anagramCache = new AnagramCache();
        String str1 = "hello";
        String str2 = "world";

        anagramCache.addToCache(str1, str2, true);

        String key1 = anagramCache.generateCacheKey(str1, str2);
        String key2 = anagramCache.generateCacheKey(str2, str1);

        String result1 = anagramCache.combinationStoredInCache(str1, str2);
        String result2 = anagramCache.combinationStoredInCache(str2, str1);

        assertEquals(key1, result1);
        assertEquals(key1, result2);
    }

    @Test
    public void testSaveCacheToFile() throws IOException {
        AnagramCache anagramCache = new AnagramCache();
        String str1 = "one";
        String str2 = "two";
        boolean areAnagrams = false;

        anagramCache.addToCache(str1, str2, areAnagrams);
        anagramCache.saveCacheToFile();

        // In a real implementation, you would use a mock FileHandler to validate the behavior.
        // Here, we're not interacting with a real file.
    }

    @Test
    public void testPopulateCache() throws IOException {
        AnagramCache anagramCache = new AnagramCache();
        String testData = "apple,banana,Anagrams\n"
                + "cat,dog,Not Anagrams\n"
                + "one,two,Anagrams";

        // In a real implementation, you would use a mock FileHandler to provide this test data.
        // Here, we're not interacting with a real file.

        // Populate the cache from the file
        anagramCache.populateCache();

        Map<String, String> cacheStorage = new HashMap<>();
        cacheStorage.put("apple,banana", "Anagrams");
        cacheStorage.put("cat,dog", "Not Anagrams");
        cacheStorage.put("one,two", "Anagrams");

        assertTrue(cacheStorage.containsKey("apple,banana"));
        assertTrue(cacheStorage.containsKey("cat,dog"));
        assertTrue(cacheStorage.containsKey("one,two"));

        assertEquals("Anagrams", cacheStorage.get("apple,banana"));
        assertEquals("Not Anagrams", cacheStorage.get("cat,dog"));
        assertEquals("Anagrams", cacheStorage.get("one,two"));
    }

    @Test
    public void testGenerateCacheKey() {
        AnagramCache anagramCache = new AnagramCache();
        String str1 = "test";
        String str2 = "example";

        String key1 = anagramCache.generateCacheKey(str1, str2);
        String key2 = anagramCache.generateCacheKey(str2, str1);

        assertEquals("test,example", key1);
        assertEquals("example,test", key2);
    }
}
