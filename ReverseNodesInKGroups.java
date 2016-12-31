// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

// Hide Company Tags Microsoft Facebook
// Hide Tags Linked List
// Hide Similar Problems (E) Swap Nodes in Pairs

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        head = dummy;
        for (int i = 0; i < size / k; i++) {
            head = reverse(head, k);
        }
        return dummy.next;
    }
    
    // reverse next k nodes
    // before: head -> n1->n2->...->nk->next
    // after:  head -> nk-nk-1->...->n1->next;
    // return: n1
    private ListNode reverse(ListNode head, int k) {
        ListNode n1 = head.next;
        ListNode prev = head;
        ListNode curr = n1;
        //next = n1.next; // s1
        // previously did s1 and s2 rather than s3, caused nullpointerexception problem when i == k - 1. Refer to the end for the reverse linkedlist code template
        for (int i = 0; i < k; i++) {  // note there is k so prev, curr, next cannot exceed k and the list need to be as the after format
            ListNode next = curr.next;  // s3
            curr.next = prev;
            prev = curr;
            curr = next;
            //next = next.next;  // s2
        }
        n1.next = curr;
        head.next = prev;
        //System.out.println(n1.val);
        return n1;
    }
}

// code template for reversing linked list
public class Solution {
    public ListNode reverseLinkedList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
}