// Given a binary tree, find the maximum path sum from root.

// The path may end at any node in the tree and contain at least one node in it.

//       1
//     /   \
//    2     3
//         /
//       -4 
// return 4 (1 -> 3)
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int result = Math.max(Math.max(left, right), 0) + root.val;
        return result;
    }
}