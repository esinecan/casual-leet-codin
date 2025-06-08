package com.example;

/**
 * Problem: Remove Duplicates from Sorted Array II
 * 
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place 
 * such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages, you must instead have the result 
 * be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, 
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesII {
    
    public int removeDuplicates(int[] nums) {
        int writePointer = 0;
        for(int readPointer = 0; readPointer<nums.length; readPointer++){
            if((writePointer < 2) || 
            (nums[writePointer -1 ] != nums[readPointer] || nums[writePointer -2 ] != nums[readPointer])){
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
        RemoveDuplicatesII solution = new RemoveDuplicatesII();
        
        // Test case 1: nums = [1,1,1,2,2,3]
        int[] test1 = {1, 1, 1, 2, 2, 3};
        System.out.println("Test case 1:");
        System.out.print("Input: nums = ");
        printArray(test1);
        System.out.println();
        
        int k1 = solution.removeDuplicates(test1);
        
        System.out.println("Output: k = " + k1);
        System.out.print("First k elements: ");
        printFirstK(test1, k1);
        System.out.println(" (Expected: [1, 1, 2, 2, 3])");
        System.out.println();
        
        // Test case 2: nums = [0,0,1,1,1,1,2,3,3]
        int[] test2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println("Test case 2:");
        System.out.print("Input: nums = ");
        printArray(test2);
        System.out.println();
        
        int k2 = solution.removeDuplicates(test2);
        
        System.out.println("Output: k = " + k2);
        System.out.print("First k elements: ");
        printFirstK(test2, k2);
        System.out.println(" (Expected: [0, 0, 1, 1, 2, 3, 3])");
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
        
        // Test case 4: Edge case - two identical elements
        int[] test4 = {2, 2};
        System.out.println("Test case 4 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test4);
        System.out.println();
        
        int k4 = solution.removeDuplicates(test4);
        
        System.out.println("Output: k = " + k4);
        System.out.print("First k elements: ");
        printFirstK(test4, k4);
        System.out.println(" (Expected: [2, 2])");
        System.out.println();
        
        // Test case 5: Edge case - many identical elements
        int[] test5 = {1, 1, 1, 1, 1};
        System.out.println("Test case 5 (edge case):");
        System.out.print("Input: nums = ");
        printArray(test5);
        System.out.println();
        
        int k5 = solution.removeDuplicates(test5);
        
        System.out.println("Output: k = " + k5);
        System.out.print("First k elements: ");
        printFirstK(test5, k5);
        System.out.println(" (Expected: [1, 1])");
    }
}
