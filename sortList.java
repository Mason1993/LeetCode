/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        return mergeList(left,right);
    }
        
        private ListNode findMiddle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        
        private ListNode mergeList (ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    head.next = left;
                    left = left.next;
                } else {
                    head.next = right;
                    right = right.next;
                }
                head = head.next;
                if (left != null) {
                    head.next = left;
                } else {
                    head.next = right;
                }
            }
            return dummy.next;
        }
}