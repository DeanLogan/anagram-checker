package org.classes;

import java.util.Arrays;

public class AnagramChecker {
    private final String[] cache;

    public AnagramChecker(){
        this.cache = null;
    }

    public boolean areAnagrams(String str1, String str2){
        // rejects all strings with spaces, numbers or special characters per the requirements
        if(!str1.matches("[a-zA-Z]+") || !str2.matches("[a-zA-Z]+")){
            return false;
        }

        // checks if length is the same for the strings, as if they are not then they cannot be anagrams
        if(str1.length() != str2.length()){
            return false;
        }

        // Convert both strings to character arrays and sort them, if these arrays match then the strings must be equal
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2); // returns true or false based on if the arrays are the same
    }
}
