In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
  Solution:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = null;

        // Reverse the first half of the linked list
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            ListNode nextNode = slowPtr.next;
            slowPtr.next = prevPtr;
            prevPtr = slowPtr;
            slowPtr = nextNode;
        }

        // Adjust pointers if the length of the linked list is odd
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        int maxSum = Integer.MIN_VALUE;
        while (slowPtr != null) {
            maxSum = Math.max(maxSum, slowPtr.val + prevPtr.val);
            slowPtr = slowPtr.next;
            prevPtr = prevPtr.next;
        }
        return maxSum;
    }
}
