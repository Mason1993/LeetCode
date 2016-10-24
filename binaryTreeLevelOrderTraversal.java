// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

// Tags Tree Breadth-first Search
// Similar Problems (M) Binary Tree Zigzag Level Order Traversal (E) Binary Tree Level Order Traversal II (E) Minimum Depth of Binary Tree (M) Binary Tree Vertical Order Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BFS implementation, one queue (Recommended solution)
// For other implementations, like DFS, BFS with two queues, BFS with one queue and dummy node, please refer to http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        // queue is used to store the next level TreeNode;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();   // to store the subresult, namely the current level node values.
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}


// recursive solution
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<TreeNode> currLevel = new ArrayList<TreeNode>();
        currLevel.add(root);
        helper(res, currLevel);
        return res;
    }
    
    private void helper (List<List<Integer>> res, List<TreeNode> nodeList) {
        int len = nodeList.size();
        List<Integer> currLevel = new ArrayList<Integer>();
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        if (nodeList.size() == 0) {
            return;
        }
        for (int i = 0; i < len; i++) {
            TreeNode node = nodeList.get(i);
            currLevel.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        res.add(currLevel);
        helper(res, nextLevel);
    }
}