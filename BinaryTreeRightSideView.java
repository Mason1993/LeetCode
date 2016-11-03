// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].

// Credits:
// Special thanks to @amrsaqr for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Tree Depth-first Search Breadth-first Search
// Hide Similar Problems (M) Populating Next Right Pointers in Each Node

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// best way but not easy to think of
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        helper(res, root, 0);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode node, int currDepth) {
        if (node == null) {
            return;
        }
        
        if (currDepth == res.size()) {
            res.add(node.val);
        }
        
        helper(res, node.right, currDepth + 1);
        helper(res, node.left, currDepth + 1);
    }
}