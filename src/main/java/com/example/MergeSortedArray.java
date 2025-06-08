package com.example;

/**
 * Problem: Merge Sorted Array
 * 
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n representing the number of elements in nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside nums1.
 * 
 * nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 */
public class MergeSortedArray {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // I know nums1 = [2,0,0,0], m = 1, nums2 = [1,5,6], n = 3
        // I can calculate nums1[m+n-1]
        int pointer1 = m-1;
        int pointer2 = n-1;
        int destinationPointer = m + n - 1;
        //Let us assume I have validated these inputs already for now.
        while (pointer1 >= 0 && pointer2 >=0) {
            //compare largest of each array. the bigger one will be later in the array.
            if(nums1[pointer1] > nums2[pointer2]){
                nums1[destinationPointer] = nums1[pointer1];
                pointer1 = pointer1 - 1; //whichever array you took it from, next one you take gotta be the previous item
            }
            else{
                nums1[destinationPointer] = nums2[pointer2];
                pointer2 = pointer2 - 1;
            }

            //Move the next insert indice:
            destinationPointer = destinationPointer - 1;
        }

        while(pointer2 >= 0){
            nums1[pointer2] = nums2[pointer2];
            pointer2 = pointer2 - 1;
        }
        
    }
    
    // Helper method for testing
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        
        // Test case 1: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] test1 = {1, 2, 3, 0, 0, 0};
        int[] test2 = {2, 5, 6};
        System.out.println("Before merge:");
        System.out.print("nums1: ");
        printArray(test1);
        System.out.print("nums2: ");
        printArray(test2);
          solution.merge(test1, 3, test2, 3);
        
        System.out.println("After merge:");
        System.out.print("nums1: ");
        printArray(test1);
        System.out.println("Expected: [1, 2, 2, 3, 5, 6]");
        System.out.println();
        
        // Test case 2: Edge case where nums2 elements are all smaller
        // nums1 = [4,5,6,0,0,0], m = 3, nums2 = [1,2,3], n = 3
        int[] test3 = {4, 5, 6, 0, 0, 0};
        int[] test4 = {1, 2, 3};
        System.out.println("Test case 2 - Before merge:");
        System.out.print("nums1: ");
        printArray(test3);
        System.out.print("nums2: ");
        printArray(test4);
        
        solution.merge(test3, 3, test4, 3);
        
        System.out.println("After merge:");
        System.out.print("nums1: ");
        printArray(test3);
        System.out.println("Expected: [1, 2, 3, 4, 5, 6]");
    }
}
