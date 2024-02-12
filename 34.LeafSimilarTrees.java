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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = leaf(root1,new ArrayList<Integer>());
        ArrayList<Integer> list2 = leaf(root2,new ArrayList<Integer>());

        return list1.equals(list2);
        
    }
    private ArrayList<Integer> leaf(TreeNode root, ArrayList<Integer> list){
        if(root == null) return list;
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        leaf(root.left , list);
        leaf(root.right,list);
        return list;
    }
}
