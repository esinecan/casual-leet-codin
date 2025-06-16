package com.example;

import java.util.*;

/**
 * Problem: Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without duplicate characters.
 * 
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces
 */
public class LongestSubstringWithoutRepeatingCharacters {
      public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        char[] theCharArray = s.toCharArray();
        int start = 0;
        int end = 0;
        int maxLength = 1;
        
        while (end < theCharArray.length - 1) {
            int next = end + 1;
            while (windowContainsCharacter(theCharArray, start, end, theCharArray[next])) {
                start = start + 1;
            }
            end = next;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    private boolean windowContainsCharacter(char[] theCharArray, int start, int end, char character){
        for(int i = start; i<=end ; i++){
            if(character == theCharArray[i]){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        
        // Test case 1: "abcabcbb"
        System.out.println("Test case 1:");
        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\"");
        int result1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("Output: " + result1 + " (Expected: 3)");
        System.out.println("Explanation: \"abc\" has length 3");
        System.out.println();
        
        // Test case 2: "bbbbb"
        System.out.println("Test case 2:");
        String s2 = "bbbbb";
        System.out.println("Input: \"" + s2 + "\"");
        int result2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("Output: " + result2 + " (Expected: 1)");
        System.out.println("Explanation: \"b\" has length 1");
        System.out.println();
        
        // Test case 3: "pwwkew"
        System.out.println("Test case 3:");
        String s3 = "pwwkew";
        System.out.println("Input: \"" + s3 + "\"");
        int result3 = solution.lengthOfLongestSubstring(s3);
        System.out.println("Output: " + result3 + " (Expected: 3)");
        System.out.println("Explanation: \"wke\" has length 3");
        System.out.println();
        
        // Test case 4: Empty string
        System.out.println("Test case 4:");
        String s4 = "";
        System.out.println("Input: \"" + s4 + "\"");
        int result4 = solution.lengthOfLongestSubstring(s4);
        System.out.println("Output: " + result4 + " (Expected: 0)");
        System.out.println("Explanation: Empty string");
        System.out.println();
        
        // Test case 5: Single character
        System.out.println("Test case 5:");
        String s5 = "a";
        System.out.println("Input: \"" + s5 + "\"");
        int result5 = solution.lengthOfLongestSubstring(s5);
        System.out.println("Output: " + result5 + " (Expected: 1)");
        System.out.println("Explanation: Single character");
        System.out.println();
        
        // Test case 6: All unique characters
        System.out.println("Test case 6:");
        String s6 = "abcdef";
        System.out.println("Input: \"" + s6 + "\"");
        int result6 = solution.lengthOfLongestSubstring(s6);
        System.out.println("Output: " + result6 + " (Expected: 6)");
        System.out.println("Explanation: Entire string is unique");
    }
}
