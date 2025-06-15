package com.example;

import java.util.*;

/**
 * Problem: Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static final Map<Character, Character> PARENTHESIS_MAP;

    static {
        // Initialize the HashMap with opening-closing pairs
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        PARENTHESIS_MAP = Map.copyOf(map); // Immutable map
    }


    public boolean isValid(String s) {
        Stack<Character> closerStack = new Stack<>();
        for(char c : s.toCharArray()){
            if(PARENTHESIS_MAP.containsKey(c) || PARENTHESIS_MAP.containsValue(c)){
                if(PARENTHESIS_MAP.containsKey(c)){
                    closerStack.push(PARENTHESIS_MAP.get(c));
                }else{
                    if(closerStack.empty()){
                        return false;
                    }
                    else{
                        if(closerStack.pop() != c){
                            return false;
                        }
                    }
                }
            }
            else{
                return false;
            }
        }
        return closerStack.empty();
    }
    
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        
        // Test case 1: "()"
        System.out.println("Test case 1:");
        String s1 = "()";
        System.out.println("Input: \"" + s1 + "\"");
        boolean result1 = solution.isValid(s1);
        System.out.println("Output: " + result1 + " (Expected: true)");
        System.out.println();
        
        // Test case 2: "()[]{}"
        System.out.println("Test case 2:");
        String s2 = "()[]{}" ;
        System.out.println("Input: \"" + s2 + "\"");
        boolean result2 = solution.isValid(s2);
        System.out.println("Output: " + result2 + " (Expected: true)");
        System.out.println();
        
        // Test case 3: "(]"
        System.out.println("Test case 3:");
        String s3 = "(]";
        System.out.println("Input: \"" + s3 + "\"");
        boolean result3 = solution.isValid(s3);
        System.out.println("Output: " + result3 + " (Expected: false)");
        System.out.println();
        
        // Test case 4: "([])"
        System.out.println("Test case 4:");
        String s4 = "([])" ;
        System.out.println("Input: \"" + s4 + "\"");
        boolean result4 = solution.isValid(s4);
        System.out.println("Output: " + result4 + " (Expected: true)");
        System.out.println();
        
        // Test case 5: "((("
        System.out.println("Test case 5:");
        String s5 = "(((" ;
        System.out.println("Input: \"" + s5 + "\"");
        boolean result5 = solution.isValid(s5);
        System.out.println("Output: " + result5 + " (Expected: false - unclosed)");
        System.out.println();
        
        // Test case 6: ")))"
        System.out.println("Test case 6:");
        String s6 = ")))" ;
        System.out.println("Input: \"" + s6 + "\"");
        boolean result6 = solution.isValid(s6);
        System.out.println("Output: " + result6 + " (Expected: false - no openers)");
        System.out.println();
        
        // Test case 7: "{[()]}"
        System.out.println("Test case 7:");
        String s7 = "{[()]}" ;
        System.out.println("Input: \"" + s7 + "\"");
        boolean result7 = solution.isValid(s7);
        System.out.println("Output: " + result7 + " (Expected: true - nested properly)");
    }
}
