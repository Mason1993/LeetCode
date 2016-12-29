// Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

// Note: If the given node has no in-order successor in the tree, return null.

// Hide Company Tags Pocket Gems Microsoft Facebook
// Hide Tags Tree
// Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Binary Search Tree Iterator

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}

// recursive solution
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}

// original solution, it does not use BST characteristics
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        List<TreeNode> inorderTraversal = new ArrayList<TreeNode>();
        inorderTraverse(root, inorderTraversal);
        for (int i = 0; i < inorderTraversal.size(); i++) {
            if (inorderTraversal.get(i) == p && i < inorderTraversal.size() - 1 ) {
                return inorderTraversal.get(i + 1);
            }
        }
        return null;
    }
    
    private void inorderTraverse (TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, list);
        list.add(root);
        inorderTraverse(root.right, list);
        return;
    }
}