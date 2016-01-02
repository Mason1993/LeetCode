// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftHalf = new ListNode(0);
        ListNode dummyLeft = leftHalf;
        ListNode rightHalf = new ListNode(0);
        ListNode dummyRight = rightHalf;
        while (head != null) {
            if (head.val < x) {
                leftHalf.next = head;
                leftHalf = leftHalf.next;
            } else {
                rightHalf.next = head;
                rightHalf = rightHalf.next;
            }
                head = head.next;            
        }
        leftHalf.next = dummyRight.next;
        rightHalf.next = null;
        return dummyLeft.next;
    }
}