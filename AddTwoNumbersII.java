// You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Follow up:
// What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

// Example:

// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7
// Subscribe to see which companies asked this question

// Hide Tags Linked List
// Hide Similar Problems (M) Add Two Numbers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// optimal solution (the actual run time is bigger than mine though). Create the linkedlist while calculating each bit
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        
        Deque<Integer> s1 = new ArrayDeque<Integer>();
        Deque<Integer> s2 = new ArrayDeque<Integer>();
        
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode node = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.poll();
            }
            if (!s2.isEmpty()) {
                sum += s2.poll();
            }
            node.val = sum % 10;
            ListNode head = new ListNode(0);
            head.next = node;
            node = head;
            sum /= 10;
        }
        if (sum == 0) {
            return node.next;
        } else {
            node.val = sum;
            return node;
        }
    }
}

// my original solution, using third stack to store numbers in each bit.
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        
        Deque<Integer> s1 = new ArrayDeque<Integer>();
        Deque<Integer> s2 = new ArrayDeque<Integer>();
        
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        int sum = 0;
        Deque<Integer> s3 = new ArrayDeque<Integer>();
        while (!s1.isEmpty() && !s2.isEmpty()) {
            carry = calcBit(s1, s2, s3, carry);
        } 
        
        while (!s1.isEmpty()) {
            carry = calcBit(s1, null, s3, carry);
        }
        
        while (!s2.isEmpty()) {
            carry = calcBit(null, s2, s3, carry);
        }
        
        if (carry != 0) {
            s3.push(carry);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(s3.poll());
        dummy.next = head;
        while (!s3.isEmpty()) {
            ListNode node = new ListNode(s3.poll());
            head.next = node;
            head = node;
        }
        return dummy.next;
    }
    
    // calculate the current bit, return the carry number and push the remaining number to stack s3
    private int calcBit (Deque<Integer> s1, Deque<Integer> s2, Deque<Integer> s3, int carry) {
        int sum = 0;
        if (s1 != null && s2 != null) {
            sum = s1.poll() + s2.poll() + carry;
        } else if (s1 != null) {
            sum = s1.poll() + carry;
        } else if (s2 != null) {
            sum = s2.poll() + carry;
        }
        int curr = sum % 10;
        carry = sum / 10;
        s3.push(curr);
        return carry;
    }
}