We have n buildings numbered from 0 to n - 1. Each building has a number of employees. It's transfer season, and some employees want to change the building they reside in.

You are given an array requests where requests[i] = [fromi, toi] represents an employee's request to transfer from building fromi to building toi.

All buildings are full, so a list of requests is achievable only if for each building, the net change in employee transfers is zero. This means the number of employees leaving is equal to the number of employees moving in. For example if n = 3 and two employees are leaving building 0, one is leaving building 1, and one is leaving building 2, there should be two employees moving to building 0, one employee moving to building 1, and one employee moving to building 2.

Return the maximum number of achievable requests.
  Solution:
  class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        return helper(0, requests, indegree, n, 0);
    }

    public int helper(int start, int[][] requests, int[] indegree, int n, int count) {
        if (start == requests.length) {
            for (int i = 0; i < n; i++) {
                if (indegree[i] != 0) {
                    return 0;
                }
            }
            return count;
        }

        // Take 
        indegree[requests[start][0]]--;
        indegree[requests[start][1]]++;
        int take = helper(start + 1, requests, indegree, n, count + 1);

        // Not-take
        indegree[requests[start][0]]++;
        indegree[requests[start][1]]--;
        int notTake = helper(start + 1, requests, indegree, n, count);

        return Math.max(take, notTake);
    }
}
