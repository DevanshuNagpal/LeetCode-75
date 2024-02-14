/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);

                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
        }
        return result;

    }
}

/*
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
    int maxlevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list  = new ArrayList<>();
        right(root,1,list);
        return list ;
    }
   public void right(TreeNode root,int level,List<Integer> list){
       if(root==null){
           return;
       }
       if(maxlevel<level){
           list.add(root.val);
           maxlevel=level;
       }
       right(root.right,level+1,list);
       right(root.left,level+1,list);
    }
}

*/
