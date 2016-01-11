// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Subscribe to see which companies asked this question

// Tags Tree Depth-first Search Breadth-first Search
// Similar Problems (E) Binary Tree Level Order Traversal (E) Maximum Depth of Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMinDepth(root);
    }
    
    // should consider the situation that [1,2]. In this case, min depth = 2 instead of min(left, right) + 1 = 1.
    private int getMinDepth(TreeNode root) {
        // so the min path passing parent of root can continue on other child.
        if (root == null) {
            return Integer.MAX_VALUE ;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);
        return Math.min(left, right) + 1;
    }
}