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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        max = helper(root, max);
        return max;
    }
    
    private int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int countRoot = countBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        if (countRoot != -1) {
            return Math.max(countRoot, max);
        }
        return Math.max(helper(root.left, max), helper(root.right, max));
    }
    
    private int countBST (TreeNode root, double min, double max) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.val <= min || root.val >= max) {
            return -1;
        }
        int countLeftBST = countBST (root.left, min, root.val); 
        int countRightBST = countBST (root.right, root.val, max);
        if (countLeftBST == -1) {
            return -1;
        } else if (countRightBST == -1) {
            return -1;
        } else {
            return countLeftBST + countRightBST + 1;
        }
    }
}