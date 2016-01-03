// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

public class Solution {
    public void reorderList(ListNode head) {
      if (head != null && head.next != null) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode head2 = duplicateList(head);
        head = dummy.next;
        head2 = reverseList(head2);
        int length = getLength(head);
        head = dummy.next;
        ListNode temp1;
        ListNode temp2;
        for (int i = 1; i < length; i++) { // first add the node in reversed list into the head list.
            temp1 = head.next;
            temp2 = head2.next;
            head.next = head2;
            i++;
            if ( i >= length) { // if the length of head list reach the length of original list, end the head list (since the head2 is the last node)
                head2.next = null;
                return;
            } else {
                head2.next = temp1; // else add the node in original list into head list by add the node after head2. (note: head list actually is the original list)
                head = temp1;
                head2 = temp2;
            }
        }
        head.next = null;
    }
    }
    private ListNode duplicateList (ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode head2 = new ListNode(head.val);
        dummy.next = head2;
        while (head.next != null) {
            head2.next = new ListNode(head.next.val);
            head2 = head2.next;
            head = head.next;
        }
        return dummy.next;
    }
    
    private int getLength (ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    private ListNode reverseList (ListNode head) {
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