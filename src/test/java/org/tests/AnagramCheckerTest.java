package org.tests;

import org.classes.AnagramChecker;
import org.classes.IAnagramChecker;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.*;

public class AnagramCheckerTest {

    private IAnagramChecker anagramChecker;

    @Before
    public void setUp() {
        anagramChecker = new AnagramChecker();
    }

    @Test
    public void testAreAnagrams_True() {
        assertTrue(anagramChecker.areAnagrams("listen", "silent"));
    }

    @Test
    public void testAreAnagrams_False() {
        assertFalse(anagramChecker.areAnagrams("hello", "world"));
    }

    @Test
    public void testAreAnagrams_CaseInsensitive() {
        assertTrue(anagramChecker.areAnagrams("Tea", "Eat"));
    }

    @Test
    public void testAreAnagrams_WithSpaces() {
        assertTrue(anagramChecker.areAnagrams("railsafety", "fairytales"));
    }

    @Test
    public void testAreAnagrams_EmptyStrings() {
        assertFalse(anagramChecker.areAnagrams("", ""));
    }

    @Test
    public void testAreAnagrams_SpaceStrings() {
        assertFalse(anagramChecker.areAnagrams(" ", "   "));
    }

    @Test
    public void testAreAnagrams_NullStrings() {
        assertFalse(anagramChecker.areAnagrams(null, null));
    }

    @Test
    public void testAreAnagrams_NumbersInInput() {
        assertFalse(anagramChecker.areAnagrams("12345", "54321"));
    }

    @Test
    public void testAreAnagrams_SpecialCharactersInInput() {
        assertFalse(anagramChecker.areAnagrams("hello!", "world"));
    }

    @Test
    public void testAreAnagrams_NumbersAndSpecialCharacters() {
        assertFalse(anagramChecker.areAnagrams("abc123", "123cba"));
    }

    @Test
    public void testAreAnagrams_NumbersAndSpaces() {
        assertFalse(anagramChecker.areAnagrams("123 45", "45 123"));
    }

    @Test
    public void testAreAnagrams_SpecialCharactersAndSpaces() {
        assertFalse(anagramChecker.areAnagrams("test!", "test"));
    }
}
