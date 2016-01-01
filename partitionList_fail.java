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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode insertPlace = dummy;
        while (insertPlace.next != null && insertPlace.next.val < x) {
            insertPlace = insertPlace.next;
        }
        if (insertPlace.next == null) {
            return head;
        }
        ListNode pointer = insertPlace;
        ListNode dummy2 = insertPlace.next;
        while (pointer.next != null && pointer.next.next != null) {
            // didnt consider that the following situation: [1,3,4,4,3,2,5,3,1] x = 4. 1. the part after insert place may be multiple,
            // e.g. in here, 4,4, and later 5.
            if (pointer.next.val < x) {
                insertPlace.next = pointer.next;
                pointer.next = pointer.next.next;
                insertPlace = insertPlace.next;
            }
            else {
                pointer = pointer.next;
            }
        }
        if (pointer.next.val < x) {
            pointer.next.next = dummy2;
            dummy2.next = null;
        } else {
            if (pointer.next == dummy2) {
                return dummy.next;
            } else {
                pointer = pointer.next;
                insertPlace.next = dummy2;
                dummy2.next = pointer;
                // it is so weird that the following statement doesnt work as the above statement.
                // ListNode tail = pointer.next;
                // pointer.next = dummy2;
                // dummy2.next = tail;
            }
        }
        return dummy.next;
    }
}