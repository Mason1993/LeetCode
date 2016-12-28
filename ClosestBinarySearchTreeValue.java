// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
// Hide Company Tags Microsoft Google Snapchat
// Hide Tags Tree Binary Search
// Hide Similar Problems (M) Count Complete Tree Nodes (H) Closest Binary Search Tree Value II

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// iterative solution
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int goal = root.val;
        double min = Double.POSITIVE_INFINITY;
        while (root != null) {
            double diff = Math.abs(root.val - target);
            if (diff < min) {
                min = diff;
                goal = root.val;
            }
            if (target > root.val) {
                root = root.right;
            } else if (target < root.val) {
                root = root.left;
            } else {
                return root.val;
            }
        }
        return goal;
    }
}

// improved recursive solution
public class Solution {
    private int goal = 0;
    private double min = Double.POSITIVE_INFINITY;
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        helper(root, target);
        return goal;
    }
    
    // return the result within root's tree
    private void helper(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(target - root.val) < min) {
            goal = root.val;
            min = Math.abs(target - root.val);
        }
        if (target - root.val > 0) {
            helper(root.right, target);
        } else {
            helper(root.left, target);
        }
    }
}

// original solution, recursive. Inefficient since it check both left and right tree
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        return helper(root, target, root.val);
    }
    
    // return the result within root's tree
    private int helper(TreeNode root, double target, int res) {
        if (root == null) {
            return res;
        }
        int temp = 0;
        if (target - root.val == 0) {
            return root.val;
        }
        res = Math.abs(target - res) < Math.abs(target - root.val) ? res : root.val;
        if (target - root.val > 0) {
            temp = helper(root.right, target, res);
        } else {
            temp = helper(root.left, target, res);
        }
        return Math.abs(target - temp) < Math.abs(target - root.val) ? temp : root.val;
    }
}