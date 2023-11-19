class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int si=nums.length;
        int ans=0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]!=nums[i]){
                ans+=si-i;
            }
        }
        return ans;
    }
}
