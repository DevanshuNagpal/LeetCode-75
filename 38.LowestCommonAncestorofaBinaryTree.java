/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return null;
        if(root == p || root == q) return root;
        //find LeftN from left side
        TreeNode leftN = lowestCommonAncestor(root.left,p,q);
        //find rightN from root right side
        TreeNode rightN = lowestCommonAncestor(root.right,p,q);

        if(leftN != null && rightN != null) return  root;
        if(rightN != null) return rightN;
        return leftN;
    }
}
