// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

// Hide Tags Divide and Conquer Linked List Heap
// Hide Similar Problems (E) Merge Two Sorted Lists (M) Ugly Number II

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Exmaple Input: [[1],[0]], Output: [0,1]
public class Solution {
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare (ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            }
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for (ListNode node: lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while(!heap.isEmpty()) {
            ListNode currNode = heap.poll();
            if (currNode.next != null) {
                heap.add(currNode.next);
            }
            pointer.next = currNode;
            pointer = pointer.next;
        }
        return dummy.next;
    }
}