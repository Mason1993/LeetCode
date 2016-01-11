// Given a binary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Tags Tree Depth-first Search
// Similar Problems (E) Balanced Binary Tree (E) Minimum Depth of Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// solution 1, traverse + recursion 
public class Solution {
    private int depth = 0;
    public int maxDepth(TreeNode root) {
        maxDepthHelper(root, 1);
        return depth;
    }
    
    private void maxDepthHelper(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        if (currDepth > depth) {
            depth = currDepth;
        }
        maxDepthHelper(root.left, currDepth + 1);
        maxDepthHelper(root.right, currDepth + 1);
    }
}

// solution 2, only recursion
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int depth = Math.max(left, right) + 1;
        return depth;
    }
}