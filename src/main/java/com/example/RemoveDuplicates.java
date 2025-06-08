package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Remove Duplicates from Sorted Array
 * 
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place 
 * such that each unique element appears only once. The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * - Change the array nums such that the first k elements of nums contain the unique elements 
 *   in the order they were present in nums initially.
 * - The remaining elements of nums are not important as well as the size of nums.
 * - Return k.
 */
public class RemoveDuplicates {
    
    public int removeDuplicates(int[] nums) {
        int writePointer = 0;
        //Set<Integer> uniqueIntegers = new HashSet<>();
        for(int readPointer = 0; readPointer<nums.length; readPointer++){
            //if(!uniqueIntegers.contains(nums[readPointer])){ //This would make sense on an unsorted array but ours is sorted.
            if(writePointer == 0 || nums[writePointer -1 ] != nums[readPointer]){
                nums[writePointer] = nums[readPointer];
                writePointer = writePointer + 1;
                //uniqueIntegers.add(nums[readPointer]);
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
        RemoveDuplicates solution = new RemoveDuplicates();
        
        // Test case 1: nums = [1,1,2]
        int[] test1 = {1, 1, 2};
        System.out.println("Test case 1:");
        System.out.print("Input: nums = ");
        printArray(test1);
        System.out.println();
        
        int k1 = solution.removeDuplicates(test1);
        
        System.out.println("Output: k = " + k1);
        System.out.print("First k elements: ");
        printFirstK(test1, k1);
        System.out.println(" (Expected: [1, 2])");
        System.out.println();
        
        // Test case 2: nums = [0,0,1,1,1,2,2,3,3,4]
        int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Test case 2:");
        System.out.print("Input: nums = ");
        printArray(test2);
        System.out.println();
        
        int k2 = solution.removeDuplicates(test2);
        
        System.out.println("Output: k = " + k2);
        System.out.print("First k elements: ");
        printFirstK(test2, k2);
        System.out.println(" (Expected: [0, 1, 2, 3, 4])");
        System.out.println();
        
        // Test case 3: Edge case - single element
        int[] test3 = {1};
        System.out.println("Test case 3 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test3);
        System.out.println();
        
        int k3 = solution.removeDuplicates(test3);
        
        System.out.println("Output: k = " + k3);
        System.out.print("First k elements: ");
        printFirstK(test3, k3);
        System.out.println(" (Expected: [1])");
        System.out.println();
        
        // Test case 4: Edge case - all elements the same
        int[] test4 = {2, 2, 2, 2, 2};
        System.out.println("Test case 4 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test4);
        System.out.println();
        
        int k4 = solution.removeDuplicates(test4);
        
        System.out.println("Output: k = " + k4);
        System.out.print("First k elements: ");
        printFirstK(test4, k4);
        System.out.println(" (Expected: [2])");
    }
}
