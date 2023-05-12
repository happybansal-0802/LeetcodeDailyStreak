You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
Return the maximum points you can earn for the exam.
  Solution:
class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long dp[]=new long[n];
        Arrays.fill(dp,-1l);
        return f(0,dp,questions);
    }
    public long f(int ind,long[] dp,int[][] questions){
        if(ind>=questions.length)
            return 0;
        if(dp[ind]!=-1l)
            return dp[ind];
        long take=questions[ind][0]+f(ind+questions[ind][1]+1,dp,questions);
        long nottake=f(ind+1,dp,questions);
        dp[ind]=Math.max(take,nottake);
        return dp[ind];
    }
}
