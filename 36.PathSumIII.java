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
    int resultPathCount=0;
    public int pathSum(TreeNode root, int targetSum) {
        
        dfsHelper(root,targetSum,0L,new HashMap<>());
        
        return resultPathCount;
    }

    private void dfsHelper(TreeNode node,int targetSum,Long currentSum,Map<Long,Integer> map)
    {
        if(node == null)
          return;

        currentSum+=node.val;

        if(currentSum==targetSum)
           resultPathCount++;

        // The number of times the curr_sum − k has occurred already, 
        // determines the number of times a path with sum k 
        // has occurred up to the current node
        resultPathCount+=map.getOrDefault(currentSum-targetSum,0);

        //Add the current sum into the hashmap
        // to use it during the child node's processing
        map.put(currentSum,map.getOrDefault(currentSum,0)+1);

        // Process the left subtree
        dfsHelper(node.left,targetSum,currentSum,map);

        //Process right subtree
        dfsHelper(node.right,targetSum,currentSum,map);

        // Remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        //back tracking
        map.put(currentSum,map.get(currentSum)-1);
         
    }
}
