package com.example;

/**
 * Problem: Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively. 
 * Could you implement both?
 * 
 * Constraints:
 * - The number of nodes in the list is the range [0, 5000]
 * - -5000 <= Node.val <= 5000
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
      // Iterative solution
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  // Initialize to null - new tail of reversed list
        ListNode curr = head;
        ListNode next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;  // prev becomes the new head
    }
    
    // Recursive solution
    public ListNode reverseListRecursive(ListNode head) {
        // base case zero or 1 elem
        if(head == null || head.next == null){
            return head;
        }
        ListNode currentNext = head.next;
        head.next = null;
        ListNode reversedRest = reverseListRecursive(currentNext);
        currentNext.next = head;
        return reversedRest;
    }
    
    // Helper method to create linked list from array
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    // Helper method to print linked list
    public static void printList(ListNode head) {
        System.out.print("[");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }
        System.out.print("]");
    }
    
    // Helper method to convert list to array for easy comparison
    public static int[] listToArray(ListNode head) {
        // Count nodes first
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Create array
        int[] result = new int[count];
        current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.val;
            current = current.next;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        
        // Test case 1: [1,2,3,4,5]
        System.out.println("Test case 1:");
        int[] input1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(input1);
        System.out.print("Input: ");
        printList(head1);
        System.out.println();
        
        ListNode reversed1 = solution.reverseList(head1);
        System.out.print("Output (Iterative): ");
        printList(reversed1);
        System.out.println(" (Expected: [5, 4, 3, 2, 1])");
        System.out.println();
        
        // Test case 2: [1,2] 
        System.out.println("Test case 2:");
        int[] input2 = {1, 2};
        ListNode head2 = createList(input2);
        System.out.print("Input: ");
        printList(head2);
        System.out.println();
        
        ListNode reversed2 = solution.reverseListRecursive(head2);
        System.out.print("Output (Recursive): ");
        printList(reversed2);
        System.out.println(" (Expected: [2, 1])");
        System.out.println();
        
        // Test case 3: [] (empty)
        System.out.println("Test case 3:");
        int[] input3 = {};
        ListNode head3 = createList(input3);
        System.out.print("Input: ");
        printList(head3);
        System.out.println();
        
        ListNode reversed3 = solution.reverseList(head3);
        System.out.print("Output: ");
        printList(reversed3);
        System.out.println(" (Expected: [])");
        System.out.println();
        
        // Test case 4: Single node
        System.out.println("Test case 4:");
        int[] input4 = {42};
        ListNode head4 = createList(input4);
        System.out.print("Input: ");
        printList(head4);
        System.out.println();
        
        ListNode reversed4 = solution.reverseList(head4);
        System.out.print("Output: ");
        printList(reversed4);
        System.out.println(" (Expected: [42])");
    }
}
