// Given a binary tree, flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
// click to show hints.

// Hints:
// If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

// Subscribe to see which companies asked this question

// Hide Tags Tree Depth-first Search
// Company Tags: Microsoft

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// my improved solution using recursion. O(1) space complexity
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left, right = root.right;
        flatten(left);
        flatten(right);
        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}

// original solution, pre-order traverse using recursion. O(n) space complexity
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, list);
        root.left = null;
        for (int i = 1; i < list.size(); i++) {
            root.right = list.get(i);
            list.get(i).left = null;
            root = root.right;
        }
    }
    
    private void dfs(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    } 
}