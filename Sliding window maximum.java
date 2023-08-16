You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
  Solution:
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int j = 0, i = 0; j < nums.length; j++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.offerLast(nums[j]);
            
            if (j - i + 1 == k) {
                result.add(deque.peekFirst());
                if (deque.peekFirst() == nums[i]) {
                    deque.pollFirst();
                }
                i++;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
