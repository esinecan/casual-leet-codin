package com.example;

import java.util.Stack;

/**
 * Problem: Remove Element
 * 
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * 
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * - Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * - The remaining elements of nums are not important as well as the size of nums.
 * - Return k.
 */
public class RemoveElement {
    
    public int removeElement(int[] nums, int val) {
        int writePointer = 0;
        for(int readPointer = 0; readPointer<nums.length; readPointer++){
            if(val != nums[readPointer]){
                nums[writePointer] = nums[readPointer];
                writePointer = writePointer + 1;
            }
        }
        return writePointer;
    }
    
    // Helper method for testing - prints first k elements
    public static void printFirstK(int[] arr, int k) {
        System.out.print("[");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    // Helper method for testing - prints entire array
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
        RemoveElement solution = new RemoveElement();
        
        // Test case 1: nums = [3,2,2,3], val = 3
        int[] test1 = {3, 2, 2, 3};
        System.out.println("Test case 1:");
        System.out.print("Input: nums = ");
        printArray(test1);
        System.out.println(", val = 3");
        
        int k1 = solution.removeElement(test1, 3);
        
        System.out.println("Output: k = " + k1);
        System.out.print("First k elements: ");
        printFirstK(test1, k1);
        System.out.println(" (Expected: [2, 2] in any order)");
        System.out.println();
        
        // Test case 2: nums = [0,1,2,2,3,0,4,2], val = 2
        int[] test2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("Test case 2:");
        System.out.print("Input: nums = ");
        printArray(test2);
        System.out.println(", val = 2");
        
        int k2 = solution.removeElement(test2, 2);
        
        System.out.println("Output: k = " + k2);
        System.out.print("First k elements: ");
        printFirstK(test2, k2);
        System.out.println(" (Expected: [0, 1, 3, 0, 4] in any order)");
        System.out.println();
        
        // Test case 3: Edge case - empty array
        int[] test3 = {};
        System.out.println("Test case 3 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test3);
        System.out.println(", val = 1");
        
        int k3 = solution.removeElement(test3, 1);
        
        System.out.println("Output: k = " + k3);
        System.out.println("Expected: k = 0");
        System.out.println();
        
        // Test case 4: Edge case - all elements equal to val
        int[] test4 = {7, 7, 7, 7};
        System.out.println("Test case 4 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test4);
        System.out.println(", val = 7");
        
        int k4 = solution.removeElement(test4, 7);
        
        System.out.println("Output: k = " + k4);
        System.out.println("Expected: k = 0");
    }
}
