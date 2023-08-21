Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
  Solution:
class Solution {
    public boolean repeatedSubstringPattern(String s) {
     return (s + s).substring(1, s.length() * 2 - 1).contains(s);   
    }
}
