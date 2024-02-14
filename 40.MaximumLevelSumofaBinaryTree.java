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
        int nLevels = getLevels(root,1);
        long[] levelSums = new long[nLevels];
        calculateLevelSums(root,levelSums,0);
        long currMax = Long.MIN_VALUE;
        int res = 0;
        for(int i =0;i<nLevels;i++){
            if(levelSums[i] > currMax){
                currMax = levelSums[i];
                res = i;
            }
        }
        return res+1;
    }
    private int getLevels(TreeNode root,int curr){
        if(root.left == null  && root.right == null) return curr;
        int res = curr;
        if(root.left != null) res = Math.max(res,getLevels(root.left , curr + 1));
        if(root.right != null) res = Math.max(res,getLevels(root.right,curr + 1));
        return res;
    }
    private void calculateLevelSums(TreeNode root, long[] levelSums,int currLevel){
        if(root == null) return ;
        levelSums[currLevel] += root.val;
        calculateLevelSums(root.left,levelSums,currLevel + 1);
        calculateLevelSums(root.right , levelSums,currLevel + 1);
    }
}
