/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }
        if (l1 == null) {
            newNode.next = l2;
        }
        if (l2 == null) {
            newNode.next = l1;
        }
        return dummy.next;
    }
}