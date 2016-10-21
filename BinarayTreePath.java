// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Tree Depth-first Search
// Hide Similar Problems (M) Path Sum II


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        helper(root, String.valueOf(root.val), res); // it would be more difficult if initialize the helper in this way helper(root, String.valueOf(root.val), res); As it is hard to determine if "->" is needed (it's not before root)
        return res;
    }
    
    private void helper(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), res);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), res);
        }
    }
}