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
    public TreeNode deleteNode(TreeNode root, int val) {
      if (root == null)
            return root;
 
        // Recursive calls for ancestors of
        // node to be deleted
        if (root.val > val) {
            root.left = deleteNode(root.left, val);
            return root;
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
            return root;
        }
 
        // We reach here when root is the node
        // to be deleted.
 
        // If one of the children is empty
        if (root.left == null) {
            TreeNode temp = root.right;
            return temp;
        } else if (root.right == null) {
            TreeNode temp = root.left;
            return temp;
        }
 
        // If both children exist
        else {
 
        TreeNode succParent = root;
 
            // Find successor
            TreeNode succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
 
            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;
 
            // Copy Successor Data to root
            root.val = succ.val;
 
            // Delete Successor and return root
            return root;  
        }
    }
}
