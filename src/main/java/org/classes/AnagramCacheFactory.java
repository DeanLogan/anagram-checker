package org.classes;

/**
 * AnagramCacheFactory is a factory class responsible for creating instances of the AnagramCache class.
 */
public class AnagramCacheFactory {
    /**
     * Creates and returns a new instance of the AnagramCache class.
     *
     * @return A new AnagramCache instance.
     */
    public AnagramCache createAnagramCache() {
        return new AnagramCache();
    }
}
