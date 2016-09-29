/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        for (int i = 0; i <= A.length; i++) {  // set the boundary condition as equal to A.length is to make sure that after push all the node into stack, there are still nodes in stack, need to pop out all the treenodes in stacl
            int value = i == A.length ? Integer.MAX_VALUE : A[i];  // make sure it can goes into the for loop
            TreeNode nodeA = new TreeNode(value);
            while (!stack.isEmpty() && stack.peek().val < value) {
                TreeNode curr = stack.pop();
                if (stack.isEmpty()) {
                    nodeA.left = curr;  // case 1
                } else {
                    TreeNode nodeS = stack.peek();
                    if (nodeS.val > nodeA.val) {
                        nodeA.left = curr;  // case 2 remember to set case 2 same to case 1 since they wont occur in the same time. While, for case 3, sometimes nodeA and nodeS refer to the same node
                    } else {
                        nodeS.right = curr; // case 3
                    }
                }
            }
            stack.push(nodeA);
        }
        
        return stack.peek().left;
    }
}