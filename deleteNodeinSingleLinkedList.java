/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        // since it's a single linked list, there is no way to change the reference pointing to this node to point node.next
        node.val = node.next.val; 
        node.next = node.next.next;
    }
}