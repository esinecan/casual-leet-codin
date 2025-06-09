package com.example;

/**
 * Problem: Missing Element
 * 
 * A zero-indexed array A contains N distinct integers in the range [1..(N + 1)].
 * That means exactly one element is missing from the sequence.
 * 
 * Write a function that returns the missing element.
 * 
 * Constraints:
 * - 0 ≤ A.length ≤ 100,000
 * - The elements are all distinct
 * - Each element is in the range [1..(A.length + 1)]
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 */
public class MissingElement {
      public int solution(int[] A) {
        int xorUpToLength = 0;

        for(int i = 1; i <= A.length + 1; i++){
            xorUpToLength = xorUpToLength ^ i;
        } //now xorUpToLength is the XOR of all expected numbers

        for(int i = 0; i < A.length; i++){
            //if any A[i] is in the array it should cancel itself out from the XOR
            xorUpToLength = xorUpToLength ^ A[i];
        }
        return xorUpToLength;
    }

    public int solution2(int[] A) {
        int expectedSum = (A.length + 1) * (A.length + 2) / 2;

        int actualSum = 0;
        for(int i = 0; i < A.length; i++){
            actualSum = actualSum + A[i];
        }

        return expectedSum - actualSum;
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
        MissingElement solution = new MissingElement();
        
        // Test case 1: A = [2, 3, 1, 5]
        int[] test1 = {2, 3, 1, 5};
        System.out.println("Test case 1:");
        System.out.print("Input: A = ");
        printArray(test1);
        System.out.println();        
        int result1 = solution.solution(test1);
        int result1_v2 = solution.solution2(test1);
        System.out.println("Output (XOR): " + result1 + " (Expected: 4)");
        System.out.println("Output (Sum): " + result1_v2 + " (Expected: 4)");
        System.out.println();
        
        // Test case 2: Missing first element
        int[] test2 = {2, 3, 4};
        System.out.println("Test case 2:");
        System.out.print("Input: A = ");
        printArray(test2);
        System.out.println();
        
        int result2 = solution.solution(test2);
        System.out.println("Output: " + result2 + " (Expected: 1)");
        System.out.println();
        
        // Test case 3: Missing last element
        int[] test3 = {1, 2, 3};
        System.out.println("Test case 3:");
        System.out.print("Input: A = ");
        printArray(test3);
        System.out.println();
        
        int result3 = solution.solution(test3);
        System.out.println("Output: " + result3 + " (Expected: 4)");
        System.out.println();
        
        // Test case 4: Single element missing
        int[] test4 = {2};
        System.out.println("Test case 4:");
        System.out.print("Input: A = ");
        printArray(test4);
        System.out.println();
        
        int result4 = solution.solution(test4);
        System.out.println("Output: " + result4 + " (Expected: 1)");
        System.out.println();
        
        // Test case 5: Empty array
        int[] test5 = {};
        System.out.println("Test case 5:");
        System.out.print("Input: A = ");
        printArray(test5);
        System.out.println();
        
        int result5 = solution.solution(test5);
        System.out.println("Output: " + result5 + " (Expected: 1)");
        System.out.println();
        
        // Test case 6: Larger example
        int[] test6 = {3, 5, 4, 1, 7, 2};
        System.out.println("Test case 6:");
        System.out.print("Input: A = ");
        printArray(test6);
        System.out.println();
        
        int result6 = solution.solution(test6);
        System.out.println("Output: " + result6 + " (Expected: 6)");
    }
}
