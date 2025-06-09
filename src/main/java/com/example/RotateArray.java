package com.example;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Problem: Rotate Array
 * 
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Follow up:
 * - Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * - Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    // Alternative 1: Default
    public void rotate(int[] nums, int k) {
        int realK = k % nums.length; //if k = nums.length + x, we can rotate only by x.
        
        int[] result = IntStream.concat(
            Arrays.stream(nums, nums.length - realK, nums.length),
            Arrays.stream(nums, 0, nums.length - realK)
        ).toArray();
        
        // if all you need is nums pointing to a rotated version of nums, exploiting Java's call by reference property:
        // nums = result;

        // if you want THE array you got as argument modified:
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    // Alternative 2: Retro Java for vintage lovers
    public void rotateV2(int[] nums, int k) {
        int realK = k % nums.length;        
        
        int[] newFirstPart = Arrays.copyOfRange(nums, nums.length - realK, nums.length);
        int[] newSecondPart = Arrays.copyOfRange(nums, 0, nums.length - realK);

        System.arraycopy(newFirstPart, 0, nums, 0, newFirstPart.length);
        System.arraycopy(newSecondPart, 0, nums, newFirstPart.length, newSecondPart.length);
    }
    
    // Alternative 3: Using reversal for in place transformation (O(1) space)
    public void rotateReverse(int[] nums, int k) {
        int realK = k % nums.length;

        reverseBetween(nums, 0, nums.length -1);
        reverseBetween(nums, 0, realK - 1);
        reverseBetween(nums, realK, nums.length - 1);
    }   
    
    public static void reverseBetween(int[] arr, int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start = start + 1;
            end = end - 1;
        }
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
    
    // Helper method to make a copy for testing
    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
    
    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        
        // Test case 1: nums = [1,2,3,4,5,6,7], k = 3
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Test case 1:");
        System.out.print("Input: nums = ");
        printArray(test1);
        System.out.println(", k = 3");        int[] test1Copy = copyArray(test1);
        solution.rotate(test1Copy, 3);
        
        System.out.print("Output (Solution 1): ");
        printArray(test1Copy);
        System.out.println(" (Expected: [5, 6, 7, 1, 2, 3, 4])");
        
        int[] test1CopyV2 = copyArray(test1);
        solution.rotateV2(test1CopyV2, 3);
        
        System.out.print("Output (Solution 2): ");
        printArray(test1CopyV2);
        System.out.println(" (Expected: [5, 6, 7, 1, 2, 3, 4])");
        
        int[] test1CopyReverse = copyArray(test1);
        solution.rotateReverse(test1CopyReverse, 3);
        
        System.out.print("Output (Solution 3 - O(1) space): ");
        printArray(test1CopyReverse);
        System.out.println(" (Expected: [5, 6, 7, 1, 2, 3, 4])");
        System.out.println();
        
        // Test case 2: nums = [-1,-100,3,99], k = 2
        int[] test2 = {-1, -100, 3, 99};
        System.out.println("Test case 2:");
        System.out.print("Input: nums = ");
        printArray(test2);
        System.out.println(", k = 2");
        
        int[] test2Copy = copyArray(test2);
        solution.rotate(test2Copy, 2);
        
        System.out.print("Output: ");
        printArray(test2Copy);
        System.out.println(" (Expected: [3, 99, -1, -100])");
        System.out.println();
        
        // Test case 3: Edge case - k larger than array length
        int[] test3 = {1, 2, 3};
        System.out.println("Test case 3 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test3);
        System.out.println(", k = 4");
        
        int[] test3Copy = copyArray(test3);
        solution.rotate(test3Copy, 4);
        
        System.out.print("Output: ");
        printArray(test3Copy);
        System.out.println(" (Expected: [3, 1, 2] - same as k = 1)");
        System.out.println();
        
        // Test case 4: Edge case - k = 0
        int[] test4 = {1, 2, 3, 4};
        System.out.println("Test case 4 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test4);
        System.out.println(", k = 0");
        
        int[] test4Copy = copyArray(test4);
        solution.rotate(test4Copy, 0);
        
        System.out.print("Output: ");
        printArray(test4Copy);
        System.out.println(" (Expected: [1, 2, 3, 4] - no change)");
        System.out.println();
        
        // Test case 5: Edge case - single element
        int[] test5 = {1};
        System.out.println("Test case 5 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test5);
        System.out.println(", k = 1");
        
        int[] test5Copy = copyArray(test5);
        solution.rotate(test5Copy, 1);
        
        System.out.print("Output: ");
        printArray(test5Copy);
        System.out.println(" (Expected: [1] - no change)");
    }
}
