Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
  Solution:
  class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int x : nums) {
            p.offer(x);
            if (p.size() > k) {
                p.poll();
            }
        }
        return p.peek();
    }
}
