/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// iterative solution, refer to program creek solution
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            } else {
                res.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }
}

// recursive solution
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}