Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
  Solution:
class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while (a != 0 || b != 0 || c != 0) {
            int x1 = a & 1;
            int x2 = b & 1;
            int x3 = c & 1;
            if ((x1 | x2) != x3) {
                if ((x1 & x2) == 1)
                    ans += 2;
                else
                    ans += 1;
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return ans;
    }
}
