// Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

// Note:
// A subtree must include all of its descendants.
// Here's an example:
//     10
//     / \
//    5  15
//   / \   \ 
//  1   8   7
// The Largest BST Subtree in this case is the highlighted one. 
// The return value is the subtree's size, which is 3.
// Hint:

// You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
// Follow up:
// Can you figure out ways to solve it with O(n) time complexity?

// Hide Company Tags Microsoft
// Hide Tags Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Optimal solution, O(n)
public class Solution {
    private int maxNum = 0;
    private class SuperNode {
        int currSize;
        int min;  // minimum value in the tree 
        int max;  // maximum value in the tree
        SuperNode(int currSize, int min, int max) {
            this.currSize = currSize;
            this.min = min;
            this.max = max;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        SuperNode temp = helper(root);
        return maxNum;
    }
    
    private SuperNode helper (TreeNode root) {
        if (root == null) {
            return new SuperNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        SuperNode left = helper(root.left);
        SuperNode right = helper(root.right);
        if (left.currSize == -1 || right.currSize == -1 || root.val < left.max || root.val > right.min) {
            return new SuperNode(-1, 0, 0);
        }
        int size = left.currSize + right.currSize + 1;
        maxNum = Math.max(maxNum, size);
        return new SuperNode(size, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }
}

// Original solution O(nlogn)
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