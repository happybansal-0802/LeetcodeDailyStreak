class Solution {
    public int countPalindromicSubsequence(String inputString) {
        int firstIndex[] = new int[26], lastIndex[] = new int[26], result = 0;
        Arrays.fill(firstIndex, Integer.MAX_VALUE);
        for (int i = 0; i < inputString.length(); ++i) {
            firstIndex[inputString.charAt(i) - 'a'] = Math.min(firstIndex[inputString.charAt(i) - 'a'], i);
            lastIndex[inputString.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; ++i)
            if (firstIndex[i] < lastIndex[i])
                result += inputString.substring(firstIndex[i] + 1, lastIndex[i]).chars().distinct().count();
        return result;
    }
}
