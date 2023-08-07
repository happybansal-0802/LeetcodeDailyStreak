You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
  Solution:
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rw = matrix.length, cl = matrix[0].length;
        int left = 0, right = rw * cl-1;
        while(left <= right){
            int midPos =  left + (right - left)/2;
            int r = midPos / cl, c = midPos % cl;
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] < target){
                left = midPos + 1;
            }else{
                right = midPos - 1;
            }
        }
        return false;
    }
}
