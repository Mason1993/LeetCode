/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode preDelete = dummy;
        dummy.next = head;
        if (head == null) {
            return null;
        } else {
            // handle the situation that the head node will be deleted
            while (preDelete.next != null)  {
                if (preDelete.next.val == val) {
                    preDelete.next = preDelete.next.next;
                } else {
                    preDelete = preDelete.next;
                }
                //System.out.println(preDelete.val);
            }
        }
        return dummy.next;
    }
}