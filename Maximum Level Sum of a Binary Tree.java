Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
  Solution:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int maxSum = root.val;
        int ans = 1;
        int level = 1;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int levelSum = 0;
            for(int i = 0;i<levelSize;i++){
                TreeNode removed = queue.remove();
                levelSum+=removed.val;
                if(removed.left!=null)queue.add(removed.left);
                if(removed.right!=null) queue.add(removed.right);
            }
            if(levelSum>maxSum){
                maxSum = levelSum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}
