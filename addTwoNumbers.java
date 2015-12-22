/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode l3 = new ListNode(0);
        ListNode dummy = l3;
        int mod = 0;
        while (l1 != null && l2 != null) {
            int sum = mod + l1.val + l2.val;
            int rem = sum % 10;
            //System.out.println(rem);
            //System.out.println(mod);
            l3.next = new ListNode(rem);
            mod = sum / 10;
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = mod + l1.val;
            int rem = sum % 10;
            l3.next = new ListNode(rem);
            mod = sum / 10;
            l1 = l1.next;
            l3 = l3.next;
        }
        while (l2 != null) {
            int sum = mod + l2.val;
            int rem = sum % 10;
            l3.next = new ListNode(rem);
            mod = sum / 10;
            l2 = l2.next;
            l3 = l3.next;
        }
        if (mod != 0) {
            l3.next = new ListNode(mod);
        }
        return dummy.next;
    }
}