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
    public int goodNodes(TreeNode root) {

        return good(root,Integer.MIN_VALUE);
    }
    private int good(TreeNode root,int maxSoFar){
        if(root == null) return 0;
        int countGood = 0;
        if(root.val >= maxSoFar){
            countGood++;
            maxSoFar = root.val;
        }
        return good(root.left, maxSoFar) + good(root.right,maxSoFar) +countGood ;


    }
}
