class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<int[]> q = new LinkedList<>();
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int total = num + (!q.isEmpty() ? q.getFirst()[1] : 0);
            res = Math.max(res, total);

            while (!q.isEmpty() && total >= q.getLast()[1]) {
                q.removeLast();
            }

            if (total > 0) {
                q.addLast(new int[]{i, total});
            }

            if (!q.isEmpty() && q.getFirst()[0] == i - k) {
                q.removeFirst();
            }
        }

        return res;        
    }
}
