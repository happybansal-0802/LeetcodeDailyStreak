Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 Solution:
class Solution {
    public ListNode swapPairs(ListNode head) {
         if(head==null||head.next==null)
           return head;
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode p3=p2.next;
        p1.next=p3;
        p2.next=p1;
        if(p3!=null){
            p1.next=swapPairs(p3);
        }
        return p2;
    }
}
