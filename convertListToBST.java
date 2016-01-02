//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode current;  // declare current beside the sortedListToBST function is to let other functions inside solution class can still access the variable; while private is to gurantee the security so that nothing outside solution class can access current;
    public TreeNode sortedListToBST(ListNode head) {
        int size = getLength(head);
        current = head;
        return sortedListToBSTHelper(size);
    }
    
    private int getLength (ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
    
    private TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }
    
    
}