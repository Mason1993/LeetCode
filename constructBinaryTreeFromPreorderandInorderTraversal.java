// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// test case : pre: [1,2,4,3,5]
//             in : [2,4,1,5,3]

// tree should be [1,2,3,null,4,5]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return buildTreeHelper(preorder, preStart, preEnd, inorder, inStart, inEnd, map);
    }
    
    // use hashmap to get the index of root in inorder given the root value
    private int findRootPosition (HashMap<Integer, Integer> map, int key) {
        int position = map.get(key);
        return position;
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        // the termination condition is confusing, will figure it out later...
        if (inStart > inEnd) {
            return null;
        }
        // preorder[preStart] is always root. Preorder: root | left children | right children; Inorder: left children | root | right children.
        int position = findRootPosition(map, preorder[preStart]);
        TreeNode root = new TreeNode(inorder[position]);
        // in left child case:
        // for preorder case: consider length of left children range is position - inStart, so preEnd = preStart + position - inStart; 
        // for inorder case: naturally inEnd = root - 1 since root is the bound dividing left and right children.
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + position - inStart, inorder, inStart, position - 1, map); 
        // in right child case:
        // for preorder case: consider length of left children range is inEnd - position, so preStart = preEnd - (inEnd - position) + 1; don't forget plus one. 
        // for inorder case: naturally inStart = root + 1 since root is the bound dividing left and right children.
        root.right = buildTreeHelper(preorder, preEnd - inEnd + position + 1, preEnd, inorder, position + 1, inEnd, map);
        return root;
    }
}