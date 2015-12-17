/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        } else 
        {
        ListNode nodeA = headA, nodeB = headB;
        int lengthA = 0, lengthB = 0;
        for (;nodeA != null; nodeA = nodeA.next) {
            lengthA++;
        }
        for (;nodeB != null; nodeB = nodeB.next) {
            lengthB++;
        }
        nodeA = headA;
        nodeB = headB;
        int diff;
        if (lengthA < lengthB) {
            diff = lengthB - lengthA;
            for (int n = 0; n < diff; n++) {
                nodeB = nodeB.next;
            }
        } else {
            diff = lengthA - lengthB;
            for (int n = 0; n < diff; n++) {
                nodeA = nodeA.next;
            }
        }
        while (nodeA != null && nodeB != null) {
            if (nodeA.val == nodeB.val) {
                return nodeA;
            } else {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }
        return null;
        }
    }
}