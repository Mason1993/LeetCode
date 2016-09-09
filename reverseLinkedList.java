/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Reverse a singly linked list.

// click to show more hints.

// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

// Hide Tags Linked List
// Hide Similar Problems (M) Reverse Linked List II (M) Binary Tree Upside Down (E) Palindrome Linked List

// optimal solution
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        // head: current node; temp: later node; prev: previous node.
        // each iteration reverse head and previous node and use temp to keep track of later node
        while (head != null) {
            ListNode temp = head.next;   // temp is referenced to head.next, shallow copy, if head.next node changed, temp would change correspondingly.
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}


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