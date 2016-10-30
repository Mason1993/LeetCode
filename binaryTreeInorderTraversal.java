// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?

// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// Subscribe to see which companies asked this question

// Tags Tree Hash Table Stack
// Similar Problems (M) Validate Binary Search Tree (M) Binary Tree Preorder Traversal (H) Binary Tree Postorder Traversal (M) Binary Search Tree Iterator (M) Kth Smallest Element in a BST (H) Closest Binary Search Tree Value II (M) Inorder Successor in BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// silution 1, traverse with recursion
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    private void traverse (TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
}

// solution 2, traverse with stack, without recursion
// 根据中序遍历的顺序，对于任一结点，优先访问其左孩子，而左孩子结点又可以看做一根结点，然后继续访问其左孩子结点，直到遇到左孩子结点为空的结点才进行访问，然后按相同的规则访问其右子树。因此其处理过程如下：
  //  对于任一结点P，
  // 1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
  // 2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子；
  // 3)直到P为NULL并且栈为空则遍历结束
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.empty()) { // it seems that check if stack is empty is unnecessary
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}