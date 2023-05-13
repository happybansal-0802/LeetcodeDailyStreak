Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.
  Solution:


class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        int mod = (int)1e9 + 7;
        for (int i = 1; i <= high; i++) {
            
            int z = dp.getOrDefault(i - zero, 0);
            
            
            int o = dp.getOrDefault(i - one, 0);
            
            
            int n = (z + o) % mod;
            
            
            dp.put(i, n);
        }
        
        
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp.getOrDefault(i, 0)) % mod;
        }
        
       
        return ans;
    }
}
