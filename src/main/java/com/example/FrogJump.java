package com.example;

/**
 * Problem: Frog Jump (Minimum Jumps)
 * 
 * A frog is located at position X and wants to get to a position ≥ Y.
 * With each jump, the frog moves a fixed distance D.
 * 
 * Write a function that returns the minimum number of jumps from position X 
 * to a position equal to or greater than Y.
 * 
 * Constraints:
 * - 1 ≤ X ≤ Y ≤ 1,000,000,000
 * - 1 ≤ D ≤ 1,000,000,000
 * - Time Complexity: O(1)
 */
public class FrogJump {
    
    public int solution(int X, int Y, int D) {
        return (int)Math.ceil((double)(Y-X) / D);
    }
    
    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        
        // Test case 1: X = 10, Y = 85, D = 30
        System.out.println("Test case 1:");
        System.out.println("Input: X = 10, Y = 85, D = 30");
        int result1 = solution.solution(10, 85, 30);
        System.out.println("Output: " + result1 + " (Expected: 3)");
        System.out.println();
        
        // Test case 2: Already at target
        System.out.println("Test case 2:");
        System.out.println("Input: X = 50, Y = 50, D = 10");
        int result2 = solution.solution(50, 50, 10);
        System.out.println("Output: " + result2 + " (Expected: 0)");
        System.out.println();
        
        // Test case 3: One jump needed
        System.out.println("Test case 3:");
        System.out.println("Input: X = 5, Y = 10, D = 7");
        int result3 = solution.solution(5, 10, 7);
        System.out.println("Output: " + result3 + " (Expected: 1)");
        System.out.println();
        
        // Test case 4: Exact jump distance
        System.out.println("Test case 4:");
        System.out.println("Input: X = 20, Y = 50, D = 30");
        int result4 = solution.solution(20, 50, 30);
        System.out.println("Output: " + result4 + " (Expected: 1)");
        System.out.println();
          // Test case 5: Large numbers
        System.out.println("Test case 5:");
        System.out.println("Input: X = 1, Y = 1000000000, D = 2");
        int result5 = solution.solution(1, 1000000000, 2);
        System.out.println("Output: " + result5 + " (Expected: 500000000)");
        System.out.println();
        
        // Test case 6: Edge case - minimal jump
        System.out.println("Test case 6:");
        System.out.println("Input: X = 1, Y = 2, D = 1");
        int result6 = solution.solution(1, 2, 1);
        System.out.println("Output: " + result6 + " (Expected: 1)");
    }
}
