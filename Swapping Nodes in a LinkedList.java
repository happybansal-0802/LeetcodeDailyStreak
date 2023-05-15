You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 Solution:
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode leftNode = head, rightNode = head;
        
        for (int i = 1; i < k; i++) {
            leftNode = leftNode.next;
        }
        
        ListNode current = leftNode;
        while (current.next != null) {
            current = current.next;
            rightNode = rightNode.next;
        }
        
        int temp = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = temp;
        
        return head;
    }
}
