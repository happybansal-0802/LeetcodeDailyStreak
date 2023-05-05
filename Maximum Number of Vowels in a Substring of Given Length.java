Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
  Solution:
class Solution {
    public boolean isVowel(char c){
        if(c=='a' || c== 'e' || c== 'i' || c== 'o' || c== 'u')
            return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int i=0;
        int count = 0;
        for(;i<k;i++){ // First window of size k
            if(isVowel(s.charAt(i)))
                count++;
        }
        int ans = count;
        for(;i<n;i++){ // Remaining n-k windows
            if(isVowel(s.charAt(i))) // If new character is vowel the increment count
                count++;
            if(isVowel(s.charAt(i-k))) // If previous character is vowel then decrement count
                count--;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}
