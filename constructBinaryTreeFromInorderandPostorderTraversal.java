// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// this problem is very similar to #105 construct binary tree from preorder and inorder. Please refer to #105 for detailed explaination.
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;
        return buildTreeHelper(inorder, inStart, inEnd, postorder, postStart, postEnd, map);
    }
    
    private int findRootPosition (HashMap<Integer, Integer> map , int key) {
        int position = map.get(key);
        return position;
    }
    
    private TreeNode buildTreeHelper (int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        // for postorder, root is always at the tail of postorder.
        int position = findRootPosition(map, postorder[postEnd]);
        TreeNode root = new TreeNode(inorder[position]);
        // postorder: left children | right children | root
        // inorder: left children | root | right children
        // the index length of left children is position - inStart, so should be it for postorder; 
        root.left = buildTreeHelper(inorder, inStart, position - 1, postorder, postStart, postStart + position - inStart - 1, map); // postEnd = postStart + offset - 1
        // for right children, postStart should be the next element of left children's postEnd;
        root.right = buildTreeHelper(inorder, position + 1, inEnd, postorder, postStart + position - inStart, postEnd - 1, map); 
        return root;
    }
}