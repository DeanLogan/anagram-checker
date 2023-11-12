package org.classes;

/**
 * CacheFactory is a factory class responsible for creating instances of classes that implement the Cache interface.
 */
public class CacheFactory {

    /**
     * Creates and returns an instance of a cache based on the specified cache type.
     *
     * @param cacheType The type of cache to create.
     * @return A Cache instance corresponding to the specified cache type, or null if the type is empty or unknown.
     * @throws IllegalArgumentException if an unknown cache type is provided.
     */
    public static Cache createCache(String cacheType) {
        if (cacheType == null || cacheType.isEmpty()) {
            return null;
        } else if (cacheType.equals("anagram")) {
            return new AnagramCache();
        }
        throw new IllegalArgumentException("Unknown cache type " + cacheType);
    }
}
