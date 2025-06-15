package com.example;

import java.util.*;

/**
 * Problem: Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use 
 * the same element twice.
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n²) time complexity?
 */
public class TwoSum {
      public int[] twoSum(int[] nums, int target) {
        //this maps complements to indices. i.e. assuming target = 10 if nums[1] = 3 then complementToIndice.get(7) = 1
        HashMap<Integer, Integer> complementToIndice = new HashMap<>();
        for(int i = 0; i<nums.length ; i++){
            int complement = target - nums[i];
            complementToIndice.put(complement, i);
        }
        //Boom! O(n)
        for(int i = 0; i<nums.length ; i++){
            if(complementToIndice.containsKey(nums[i])){
                if(complementToIndice.get(nums[i]) != i) //"the same element twice" thing
                    return new int[]{i, complementToIndice.get(nums[i])};
            }
        }
        return new int[0];
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        // Test case 1: nums = [2,7,11,15], target = 9
        System.out.println("Test case 1:");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.print("Input: nums = ");
        printArray(nums1);
        System.out.println(", target = " + target1);
        
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.print("Output: ");
        printArray(result1);
        System.out.println(" (Expected: [0, 1])");
        System.out.println();
        
        // Test case 2: nums = [3,2,4], target = 6
        System.out.println("Test case 2:");
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.print("Input: nums = ");
        printArray(nums2);
        System.out.println(", target = " + target2);
        
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.print("Output: ");
        printArray(result2);
        System.out.println(" (Expected: [1, 2])");
        System.out.println();
        
        // Test case 3: nums = [3,3], target = 6
        System.out.println("Test case 3:");
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.print("Input: nums = ");
        printArray(nums3);
        System.out.println(", target = " + target3);
        
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.print("Output: ");
        printArray(result3);
        System.out.println(" (Expected: [0, 1])");
        System.out.println();
        
        // Test case 4: Negative numbers
        System.out.println("Test case 4:");
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        System.out.print("Input: nums = ");
        printArray(nums4);
        System.out.println(", target = " + target4);
        
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.print("Output: ");
        printArray(result4);
        System.out.println(" (Expected: [2, 4] for -3 + -5 = -8)");
    }
}
