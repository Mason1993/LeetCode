// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// Subscribe to see which companies asked this question

// Tags Tree Depth-first Search
// Similar Problems (M) Binary Tree Inorder Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// two places need attention: （Actually 2 itself can be the validation, which is what we did for this problem）
// 1. curr.val must be within [curr.left.val, curr.right.val]
// 2. if curr is in left children, then curr < the value of the parent of curr
//    if curr is in right children, then curr > the value of the parent of curr
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);  // Integer type is used at the beginning, however, the value of test cases are beyond the upper bound. Also, Double type range is 2^-1074 <= x <= (2-2^-52)·2^1023 (both lower and upper bounds are positive). So double.MIN_VALUE cannot be applied here.
    }
    
    private boolean isValidBSTHelper (TreeNode root, double min, double max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean isLeftBST = isValidBSTHelper (root.left, min, root.val);   // min is the minimum value of the tightest node value
        boolean isRightBST = isValidBSTHelper (root.right, root.val, max);
        return isLeftBST && isRightBST;
    }
}