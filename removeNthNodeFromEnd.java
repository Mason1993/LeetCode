/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int listLength = 1;
        ListNode currNode = head;
        if (currNode.next != null) {
            listLength++;
            currNode = currNode.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int currPos = 0;
        while (currPos < listLength - n - 1) {
            currPos++;
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}