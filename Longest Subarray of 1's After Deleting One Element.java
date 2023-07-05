Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
  Solution:
  class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left=0;
        int zeros=0;
        int ans=0;
        for(int right=0; right<n; right++){
            if(nums[right]==0){
                zeros++;
            }
            while(zeros >1){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            ans=Math.max(ans, right-left+1-zeros);
        }
        return (ans==n) ? ans-1:ans;
    }
}
