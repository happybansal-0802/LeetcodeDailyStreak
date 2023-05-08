Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
  Solution:
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
for(int i=0, end=mat.length -1; i<mat.length; i++, end--) {
sum += mat[i][i] + mat[i][end];
if (i == end)
sum -= mat[i][end];
}
return sum;
    }
}
