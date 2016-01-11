// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______3______
//        /              \
//     ___5__          ___1__
//    /      \        /      \
//    6      _2       0       8
//          /  \
//          7   4
// For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

// Subscribe to see which companies asked this question

// Tags Tree
// Similar Problems (E) Lowest Common Ancestor of a Binary Search Tree

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {   // if the root, namely current node, mataches either p or q, return it, since if the root mataches either p or q, lca must be root no matter if the other node is in the tree or not
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);   // left is the lca of p & q in tree root.left
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // case 1, each left and right subtree of parent node, root, contains one of these two nodes.
        if (left != null && right != null) {
            return root;
        // case 2, no lca found in right tree, so the overall lca would be left lca
        } else if (left != null) {
            return left;
        // case 3 , no lca found in left tree
        } else if (right != null) {
            return right;
        // case 4, no lca found in both left and right tree, therefore, no lca for p & q in the tree.
        } else {
            return null;
        }
    }
}