package com.example;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Find the Unpaired Element
 * 
 * A non-empty array A of N integers is given.
 * The array contains an odd number of elements, and each element occurs an even number of times, 
 * except for one element, which occurs only once.
 * 
 * Write a function that returns the value of the unpaired element.
 * 
 * Constraints:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1) or O(N) depending on the method
 */
public class UnpairedElement {
    
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int num : A) {
            if (set.contains(num)) { // If already present, remove it
                set.remove(num);
            }
            else{
                set.add(num); // Otherwise do the exact opposite of removing it. The polar opposite.
            }
        }

        // The set should contain only one element at the end
        return set.iterator().next(); // O(1) complexity for retrieval
    }
    
    // Helper method for testing - prints array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        UnpairedElement solution = new UnpairedElement();
        
        // Test case 1: {9, 3, 9, 3, 9, 7, 9}
        int[] test1 = {9, 3, 9, 3, 9, 7, 9};
        System.out.println("Test case 1:");
        System.out.print("Input: A = ");
        printArray(test1);
        System.out.println();
        
        int result1 = solution.solution(test1);
        System.out.println("Output: " + result1 + " (Expected: 7)");
        System.out.println();
        
        // Test case 2: Single element
        int[] test2 = {42};
        System.out.println("Test case 2:");
        System.out.print("Input: A = ");
        printArray(test2);
        System.out.println();
        
        int result2 = solution.solution(test2);
        System.out.println("Output: " + result2 + " (Expected: 42)");
        System.out.println();
        
        // Test case 3: Larger example
        int[] test3 = {1, 2, 3, 2, 1, 4, 4, 5, 5};
        System.out.println("Test case 3:");
        System.out.print("Input: A = ");
        printArray(test3);
        System.out.println();
        
        int result3 = solution.solution(test3);
        System.out.println("Output: " + result3 + " (Expected: 3)");
        System.out.println();
        
        // Test case 4: Edge case with large numbers
        int[] test4 = {1000000000, 999999999, 1000000000};
        System.out.println("Test case 4:");
        System.out.print("Input: A = ");
        printArray(test4);
        System.out.println();
        
        int result4 = solution.solution(test4);
        System.out.println("Output: " + result4 + " (Expected: 999999999)");
        System.out.println();
        
        // Test case 5: Three elements with one unique
        int[] test5 = {7, 7, 5};
        System.out.println("Test case 5:");
        System.out.print("Input: A = ");
        printArray(test5);
        System.out.println();
        
        int result5 = solution.solution(test5);
        System.out.println("Output: " + result5 + " (Expected: 5)");
    }
}
