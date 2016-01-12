/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// failed solution.
// three points need to pay attention to:
// 1. have to use stack, queue cannot be used here. Reason: if (normalOrder) can only control the left and right subtrees order (left subtree goes first or right subtree goes first). We also need to consier whose subtrees go first. In this case, stack has to be used here. Consider the following situation, [1,2,3,4,5,6,7]. If we use queue here, it may return [ [1], [3,2], [6,7,4,3] ]. In this case, the subtrees of right node 6 go before subtrees of left node 5, which is wrong.
// 2. since stack is first in last out, so we cannot just use one stack for both currLevel and nextLevel like what we did using queue. For queue, after we insert all subtrees of node A, the poll out order still the same. All nodes (total # == size) in current level will be polled out then we can poll out nodes in next level. However, for stack struck, if we still do the same thing, after we insert all subtrees of node A in current level and we wish to poll out next node which is node B in current level. However, the nodes we polled out will be those subtrees of node A which are just inserted.
// 3. switch currLevel and nextLevel value rather than just pass nextLevel to currLevel.
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> temp;
        currLevel.push(root);
        boolean normalOrder = true;
        while (!currLevel.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            Stack<TreeNode> nextLevel = new Stack<TreeNode>();  // re-initiate nextLevel before using it to store next level TreeNodes.
            while (!currLevel.isEmpty()) {
                TreeNode curr = currLevel.pop();
                level.add(curr.val);
                if (normalOrder) {
                    if (curr.left != null) {
                        nextLevel.push(curr.left);
                    }
                    if (curr.right != null) {
                        nextLevel.push(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        nextLevel.push(curr.right);
                    }
                    if (curr.left != null) {
                        nextLevel.push(curr.left);
                    }
                }
            }
            result.add(level);
            //temp = currLevel;
            currLevel = nextLevel;
            //nextLevel = temp;
            normalOrder = !normalOrder;
        }
        return result;
    }
}