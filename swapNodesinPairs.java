/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode dummy = head.next;
        ListNode afterHead = head.next;
        if (afterHead.next == null) {
            afterHead.next = head;
            head.next = null;
            return dummy;
        }
        //ListNode temp = afterHead.next;
        if (afterHead.next.next == null) {
            ListNode temp1 = afterHead.next;
            afterHead.next = head;
            head.next = temp1;
            return dummy;
        }
        while (afterHead.next != null && afterHead.next.next != null) {
            ListNode temp1 = afterHead.next;
            ListNode temp2 = afterHead.next.next;
            afterHead.next = head;
            head.next = temp2;
            afterHead = temp2;
            head = temp1;
        }
        if (afterHead.next != null) {
            ListNode temp1 = afterHead.next;
            afterHead.next = head;
            head.next = temp1;
        } else {
            afterHead.next = head;
            head.next = null;
        }
        return dummy;
    }
}