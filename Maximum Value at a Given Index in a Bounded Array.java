You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.
  Solution:
class Solution {
    public int maxValue(int n, int index, int maxSum) {
         long lt=index;
        long rt=n-index-1;
        long st=1;
        long end=maxSum;
        while(st<=end) {
            long mid=st+(end-st)/2;
            long m=mid-1;
            long ls=0;
            long rs=0;
            if(m>=lt) {
                long notInRange=m-lt;
                ls=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            else {
                ls=m*(m+1)/2+1*(lt-m);
            }
            if(m>=rt) {
                long notInRange=m-rt;
                rs=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            else {
                rs=m*(m+1)/2+1*(rt-m);
            }
            long sum=rs+ls+mid;
            if(sum>maxSum) {
                end=mid-1;
            }
            else {
                st=mid+1;
            }
        }
        return (int)end;
    }
}
