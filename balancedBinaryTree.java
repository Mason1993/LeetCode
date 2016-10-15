// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// Subscribe to see which companies asked this question

// Tags Tree Depth-first Search
// Similar Problems (E) Maximum Depth of Binary Tree

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (getHeight(root) == -1) {
            return false;
        }
        return true;
    }
    
    private int getHeight (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1) {   // if the subtree is unbalanced, the parent node of that unbalanced subtree will also be unbalanced.
            return -1;
        }
        if (Math.abs(left - right) > 1) {    // if the difference of eight larger than 1, marked as -1
            return -1;
        }
        return Math.max(left, right) + 1;  //// we choose max instead of min since it always return -1 when a balanced subtree and unbalanced subtree compared together. We cannot just return any positive value since we need to compare the height difference.
}