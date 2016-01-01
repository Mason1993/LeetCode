/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class ReturnArray {
        int length;
        ListNode tail;
        ReturnArray(int x) { length = x; }
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        int headVal = head.val;
        dummy.next = head;
        ReturnArray result = getLengthTail(head);
        int length = result.length;
        result.tail = dummy.next;
        head = dummy.next;
        
        k = k % length;
        int move = length - k;
        for (int i = 0; i < move - 1; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        //ListNode tail = newHead;
        //newHead = reverseList(newHead);
        return newHead;
    }
    
    private ReturnArray getLengthTail(ListNode head) {
        int length = 1;  // since if the length is 0, then [] will be returned at the beginning. Therefore, the length is at least 1.
        while (head != null && head.next != null) {
            length++;
            head = head.next;
        }
        ReturnArray result = new ReturnArray(length);
        result.tail = head;
        return result;
    }
}