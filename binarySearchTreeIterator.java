// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Tags Tree Stack Design
// Similar Problems (M) Binary Tree Inorder Traversal (M) Flatten 2D Vector (M) Zigzag Iterator (M) Peeking Iterator (M) Inorder Successor in BST

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// always push left children into stack. When a node was poped out, check if it has right child, if it has, push right child node into stack, and push all its left children into stack.
public class BSTIterator {
    private Stack<TreeNode> stack; 

    public BSTIterator(TreeNode root) {
            stack = new Stack<TreeNode> ();
            while (root != null) {
                stack.push(root);
                root = root.left;
            } 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int next = curr.val;
        if (curr.right != null) {
            TreeNode node = curr.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return next;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */