/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode temp = new ListNode(0);
            ListNode preNode = null;
            while (head != null) {
               temp = head.next;
               head.next = preNode;
               preNode = head;
               head = temp;
            }
            return preNode;
        }
    }
}