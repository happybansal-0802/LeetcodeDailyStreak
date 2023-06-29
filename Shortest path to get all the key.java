You are given an m x n grid grid where:

'.' is an empty cell.
'#' is a wall.
'@' is the starting point.
Lowercase letters represent keys.
Uppercase letters represent locks.
You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.

If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.

For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
  Solution:
import java.util.*;

class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        Map<Character, Integer> key_bit = new HashMap<>();
        int bit_start = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Character.isLowerCase(grid[i].charAt(j))) {
                    key_bit.put(grid[i].charAt(j), bit_start++);
                }
            }
        }

        int mask_end = (1 << bit_start) - 1;
        int mask_size = (1 << bit_start);

        boolean[][][] memo = new boolean[m][n][mask_size];

        int[] start = new int[3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    start = new int[]{i, j, 0};
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int k = 0; k < sz; k++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                int mask = curr[2];

                if (row < 0 || row >= m || col < 0 || col >= n) continue;

                if (grid[row].charAt(col) == '#') continue;

                if (Character.isUpperCase(grid[row].charAt(col))) {
                    if ((mask & (1 << key_bit.get(Character.toLowerCase(grid[row].charAt(col))))) == 0) continue;
                }

                if (Character.isLowerCase(grid[row].charAt(col))) {
                    mask |= (1 << key_bit.get(grid[row].charAt(col)));
                }

                if (mask == mask_end) return step;

                if (memo[row][col][mask]) continue;

                memo[row][col][mask] = true;

                q.offer(new int[]{row + 1, col, mask});
                q.offer(new int[]{row - 1, col, mask});
                q.offer(new int[]{row, col + 1, mask});
                q.offer(new int[]{row, col - 1, mask});
            }
            step++;
        }
        return -1;
    }
}
