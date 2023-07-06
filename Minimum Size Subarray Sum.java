Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 Solution:
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; int j = 0;
        int sum = 0; int ans = 1000000;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                ans = Math.min(ans, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        
        return ans==1000000?0:ans;
    }
}
