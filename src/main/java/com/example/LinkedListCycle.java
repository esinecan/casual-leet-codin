package com.example;

/**
 * Problem: Linked List Cycle Detection
 * 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can be reached 
 * again by continuously following the next pointer.
 * 
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * 
 * Constraints:
 * - The number of the nodes in the list is in the range [0, 10^4]
 * - -10^5 <= Node.val <= 10^5
 * - pos is -1 or a valid index in the linked-list
 */

// Definition for singly-linked list (reusing from previous problem)
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    
    // Helper method to create a linked list with a cycle for testing
    public static ListNode createListWithCycle(int[] values, int pos) {
        if (values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;
        
        // Create the list
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        // Create cycle if pos is valid
        if (pos >= 0 && pos < values.length) {
            // Find the node at position 'pos'
            ListNode temp = head;
            for (int i = 0; i < pos; i++) {
                temp = temp.next;
            }
            cycleNode = temp;
            
            // Make the last node point to the cycle node
            current.next = cycleNode;
        }
        
        return head;
    }
    
    // Helper method to create a normal list (no cycle)
    public static ListNode createList(int[] values) {
        return createListWithCycle(values, -1);
    }
    
    // Helper to print list values (careful with cycles!)
    public static void printList(int[] values, int pos) {
        System.out.print("[");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1) System.out.print(", ");
        }
        System.out.print("]");
        if (pos >= 0) {
            System.out.print(", pos = " + pos);
        } else {
            System.out.print(", pos = -1 (no cycle)");
        }
    }
    
    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        
        // Test case 1: [3,2,0,-4], pos = 1 (cycle exists)
        System.out.println("Test case 1:");
        int[] values1 = {3, 2, 0, -4};
        int pos1 = 1;
        System.out.print("Input: ");
        printList(values1, pos1);
        System.out.println();
        
        ListNode head1 = createListWithCycle(values1, pos1);
        boolean result1 = solution.hasCycle(head1);
        System.out.println("Output: " + result1 + " (Expected: true)");
        System.out.println("Explanation: Tail connects to node at index 1");
        System.out.println();
        
        // Test case 2: [1,2], pos = 0 (cycle exists)
        System.out.println("Test case 2:");
        int[] values2 = {1, 2};
        int pos2 = 0;
        System.out.print("Input: ");
        printList(values2, pos2);
        System.out.println();
        
        ListNode head2 = createListWithCycle(values2, pos2);
        boolean result2 = solution.hasCycle(head2);
        System.out.println("Output: " + result2 + " (Expected: true)");
        System.out.println("Explanation: Tail connects to node at index 0");
        System.out.println();
        
        // Test case 3: [1], pos = -1 (no cycle)
        System.out.println("Test case 3:");
        int[] values3 = {1};
        int pos3 = -1;
        System.out.print("Input: ");
        printList(values3, pos3);
        System.out.println();
        
        ListNode head3 = createListWithCycle(values3, pos3);
        boolean result3 = solution.hasCycle(head3);
        System.out.println("Output: " + result3 + " (Expected: false)");
        System.out.println("Explanation: No cycle in the linked list");
        System.out.println();
        
        // Test case 4: Empty list
        System.out.println("Test case 4:");
        System.out.println("Input: [], pos = -1 (empty list)");
        
        ListNode head4 = null;
        boolean result4 = solution.hasCycle(head4);
        System.out.println("Output: " + result4 + " (Expected: false)");
        System.out.println("Explanation: Empty list has no cycle");
        System.out.println();
        
        // Test case 5: Single node with self-cycle
        System.out.println("Test case 5:");
        int[] values5 = {1};
        int pos5 = 0;
        System.out.print("Input: ");
        printList(values5, pos5);
        System.out.println();
        
        ListNode head5 = createListWithCycle(values5, pos5);
        boolean result5 = solution.hasCycle(head5);
        System.out.println("Output: " + result5 + " (Expected: true)");
        System.out.println("Explanation: Single node points to itself");
    }
}
