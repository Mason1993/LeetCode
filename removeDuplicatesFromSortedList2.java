/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        ListNode dummy = preNode;
        int n = 0;
        //dummy.next = head;
        //ListNode preNode = dummy;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int val = head.val;
                while (head.next != null && head.next.val == val) {
                    head = head.next;
                }
                head = head.next;
                preNode.next = head;
            } else {
                head = head.next;
                preNode = preNode.next;
            }
        }
        return dummy.next;
    }
}