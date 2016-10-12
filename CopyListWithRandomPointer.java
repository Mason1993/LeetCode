// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table Linked List
// Hide Similar Problems (M) Clone Graph


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// Note: random pointer ONLY points to any node in the list or null, which means that the random pointer won't point to the node outside the list

// T: O(n) but it will iterate the linkedlist twice
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();  // a hashmap is used to store the mapping between original nodes and copied nodes
        
        while (head != null) {
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        
        head = dummy.next;
        
        while (head != null) { // at the beginning I wrote the exit condition as head.next != null which will ignore the tail node.
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        
        return map.get(dummy.next);
    }
}