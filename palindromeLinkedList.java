/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        } else {
            int length = 0;
            int middleIndex;
            ListNode dummy = new ListNode(0);
            ListNode secHalfHead = new ListNode(0);
            dummy.next = head;
            for (; head != null; head = head.next) {
                length++;
            }
            head = dummy.next;
            switch (length) {
            case 1: 
                return true;
            case 2:
                if (head.val != head.next.val) {
                    return false;
                } else {
                    return true;
                }
            default:
            ListNode tail = dummy.next;
            if (length % 2 == 0) {
                middleIndex = length / 2;
                for (int i = 0; i < middleIndex - 1; i++) {
                    tail = tail.next;
                }
                secHalfHead = tail.next;
            } else {
                middleIndex = (length - 1) / 2;
                for (int i = 0; i < middleIndex; i++) {
                     tail = tail.next;
                    }
                secHalfHead = tail.next;
            }
            secHalfHead = reverseList(secHalfHead);
            head = dummy.next;
            for (int i = 0; i < middleIndex; i++) {
                //System.out.println(head.val);
                //System.out.println(secHalfHead.val);
                //System.out.println(Boolean.toString(head.val == secHalfHead.val));
                if (head.val != secHalfHead.val) {
                    return false;
                } else {
                    head = head.next;
                    secHalfHead = secHalfHead.next;
                    //System.out.println(head);
                    //System.out.println(secHalfHead);
                }
            }
            return true;                
            }
        }
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