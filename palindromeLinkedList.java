/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // note: the ordinary data structure was destoryed. However, it can be easily recovered by reverse the second half linked list back to get the original linked list
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        middle.next = reverseList(middle.next);
        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        //middle.next = reverseList(middle.next);  // recover the original data structure, but it's not required for this question.
        return p2 == null; // if true, then compare completed, no inequality founded
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
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
            //System.out.println(preNode.val);
            return preNode;
        }
    }
}