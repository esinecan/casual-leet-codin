package com.example;

/**
 * Problem: Maximum Subarray (Kadane's Algorithm)
 * 
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another solution 
 * using the divide and conquer approach, which is more subtle.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 */
public class MaximumSubarray {
        
    public int maxSubArray(int[] nums) {
        int currentSubArraySum = 0;
        int currentSubArrayStart = 0;
        int globalSubArraySum = Integer.MIN_VALUE;
        //int globalSubArrayStart = 0;
        //int globalSubArrayEnd = 0;
        for(int i =0; i<nums.length;i++){
            currentSubArraySum = nums[i] + currentSubArraySum;
            if(globalSubArraySum < currentSubArraySum){
                globalSubArraySum = currentSubArraySum;
                //globalSubArrayEnd = i;
                //globalSubArrayStart = currentSubArrayStart;
            }
            if(currentSubArraySum < 0){
                currentSubArraySum = 0;
                //currentSubArrayStart = i;
            }
        }
        return globalSubArraySum;
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
        MaximumSubarray solution = new MaximumSubarray();
        
        // Test case 1: [-2,1,-3,4,-1,2,1,-5,4]
        System.out.println("Test case 1:");
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print("Input: nums = ");
        printArray(nums1);
        System.out.println();
        
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Output: " + result1 + " (Expected: 6)");
        System.out.println("Explanation: Subarray [4,-1,2,1] has largest sum 6");
        System.out.println();
        
        // Test case 2: [1]
        System.out.println("Test case 2:");
        int[] nums2 = {1};
        System.out.print("Input: nums = ");
        printArray(nums2);
        System.out.println();
        
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Output: " + result2 + " (Expected: 1)");
        System.out.println("Explanation: Single element subarray [1]");
        System.out.println();
        
        // Test case 3: [5,4,-1,7,8]
        System.out.println("Test case 3:");
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.print("Input: nums = ");
        printArray(nums3);
        System.out.println();
        
        int result3 = solution.maxSubArray(nums3);
        System.out.println("Output: " + result3 + " (Expected: 23)");
        System.out.println("Explanation: Entire array [5,4,-1,7,8] has sum 23");
        System.out.println();
        
        // Test case 4: All negative numbers
        System.out.println("Test case 4:");
        int[] nums4 = {-3, -2, -1, -5};
        System.out.print("Input: nums = ");
        printArray(nums4);
        System.out.println();
        
        int result4 = solution.maxSubArray(nums4);
        System.out.println("Output: " + result4 + " (Expected: -1)");
        System.out.println("Explanation: Best single element [-1]");
        System.out.println();
        
        // Test case 5: Mixed positive/negative
        System.out.println("Test case 5:");
        int[] nums5 = {-2, -1, -3};
        System.out.print("Input: nums = ");
        printArray(nums5);
        System.out.println();
        
        int result5 = solution.maxSubArray(nums5);
        System.out.println("Output: " + result5 + " (Expected: -1)");
        System.out.println("Explanation: Least negative single element [-1]");
        System.out.println();
        
        // Test case 6: Zero included
        System.out.println("Test case 6:");
        int[] nums6 = {-1, 0, -2};
        System.out.print("Input: nums = ");
        printArray(nums6);
        System.out.println();
        
        int result6 = solution.maxSubArray(nums6);
        System.out.println("Output: " + result6 + " (Expected: 0)");
        System.out.println("Explanation: Single element [0] is best");
    }
}
