// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      /    / \
//     4    6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      /    / \
//    4->NULL6->7 -> NULL
// Subscribe to see which companies asked this question

// Hide Tags Tree Depth-first Search
// Hide Similar Problems (H) Populating Next Right Pointers in Each Node II (M) Binary Tree Right Side View


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// I was thinking using binary search with queue, however, when inserting nodes (especially the bottom level ones), the queue is not of constant space anymore. So this solution is not doable, plus it's kinda complicated
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode currNode = start;
            while (currNode != null) {
                if (currNode.left != null) {
                    currNode.left.next = currNode.right;
                }
                if (currNode.next != null && currNode.right != null) {
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next;
            }
            start = start.left;
        }
    }

    public static void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode curr = root;
        while (curr != null) {
            TreeLinkNode head = curr;
            while (curr != null) {
                if (curr.left != null) { // if curr.left != null then curr.right != null since it's perfect bianry tree;
                    curr.left.next = curr.right;

                    if (curr.next != null) {
                        curr.right.next = curr.next.left;
                    }
                }
                curr = curr.next;
            }
            curr = head.left;
        }
    }
}