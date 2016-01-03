/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode preNode = dummy;
            ListNode aftNode = head.next;
            while (preNode.next != null && preNode.next.val < head.val) {
                preNode = preNode.next;
            }
            head.next = preNode.next;
            preNode.next = head;
            head = aftNode;
        }
        return dummy.next;
    }
}


// previous solution, failed
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// public class Solution {
//     public ListNode insertionSortList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode temp1, temp2;
//         head = dummy;
//         ListNode pointer = head.next.next;
//         while (pointer != null) {
//             while (head.next != null && head.next.val < pointer.val) {
//                 head = head.next;
//             }
//             temp2 = head.next;
//             head.next = pointer;
//             temp1 = pointer.next;
//             pointer.next = temp2;
//             if (temp1 != null) {
//               temp2.next = temp1;
//               pointer = temp1;
//               head = dummy;               
//             } else {
//                 temp2.next.next.next = null;
//             }
//         }
//         return dummy.next;
//     }
// }