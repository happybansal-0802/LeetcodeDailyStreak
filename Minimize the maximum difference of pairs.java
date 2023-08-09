You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
  Solution:
class Solution {
    public boolean solve(int[] nums, int d, int p) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= d) {
                c++;
                i++;
            }
            if (c >= p) {
                return true;
            }
        }
        return false;
    }
    
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (solve(nums, mid, p)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
