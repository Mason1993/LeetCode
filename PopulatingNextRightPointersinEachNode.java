// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      /    / \
//     4    6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      /    / \
//    4->NULL6->7 -> NULL
// Subscribe to see which companies asked this question

// Hide Tags Tree Depth-first Search
// Hide Similar Problems (H) Populating Next Right Pointers in Each Node II (M) Binary Tree Right Side View


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// Calculate the height of perfect binary tree: Geometric progression. height = log(n + 1) / log2

// solutions: 1 > 3 > 2 criteria: the time and space complexity

// solution 1: iterative
// Space Complexity: O(1), Time Complexity: O(n) - O(logn) = O(n) (Connect every node on every level. Suppose the number of nodes on the current level is x , then there are x - 1 connect operations (alway less than number of nodes by 1). The height of a perfect binary tree is logn, so the time complexity is O(n) - O(logn)
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode head = root.left;  // the first node on the current row
        while (head != null) {
            TreeLinkNode curr = root.left;  // curr: current node, which is one row lower than root
            curr.next = root.right;
            curr = curr.next;
            root = root.next;
            if (root != null) {       
                curr.next = root.left;  // perfect binary tree, root must have left and right children on the same level as current node
            } else {              // the tail of current row, move to next row. Set root to the begining of next row
                root = head;
                head = head.left;
            }
        }
    }
}

// solution 2: iterative

// Space Complexity: O(n/2) (the number of nodes on the last level is (n + 1)/2 )
// Time Complexity: O(n) 
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
     
        LinkedList<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
        LinkedList<Integer> depthQueue = new LinkedList<Integer>();
     
        if(root!=null){
            nodeQueue.offer(root);
            depthQueue.offer(1);
        }
     
        while(!nodeQueue.isEmpty()){
            TreeLinkNode topNode = nodeQueue.poll();
            int depth = depthQueue.poll();
     
            if(depthQueue.isEmpty()){  // last node on the last row, no more nodes to be connected 
                topNode.next = null;
            }else if(depthQueue.peek()>depth){  // last node on the current row, the remaining nodes in queue are from next row
                topNode.next = null;
            }else{                     // the node on the current row (not last node )
                topNode.next = nodeQueue.peek();
            }
            
            // if not the last row
            if(topNode.left!=null){   
                nodeQueue.offer(topNode.left);
                depthQueue.offer(depth+1);
            }
     
            if(topNode.right!=null){
                nodeQueue.offer(topNode.right);
                depthQueue.offer(depth+1);
            }        
        }
    }
}

// solution 3: recursive
// Space Complexity: O(logn) using stack 
// Time Complexity: O(n). For time complexity of recursive algorithms, please refer to https://www.cs.duke.edu/~ola/ap/recurrence.html 
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
    }
}
// I was thinking using binary search with queue, however, when inserting nodes (especially the bottom level ones), the queue is not of constant space anymore. So this solution is not doable, plus it's kinda complicated
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode currNode = start;
            while (currNode != null) {
                if (currNode.left != null) {
                    currNode.left.next = currNode.right;
                }
                if (currNode.next != null && currNode.right != null) {
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next;
            }
            start = start.left;
        }
    }

    public static void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode curr = root;
        while (curr != null) {
            TreeLinkNode head = curr;
            while (curr != null) {
                if (curr.left != null) { // if curr.left != null then curr.right != null since it's perfect bianry tree;
                    curr.left.next = curr.right;

                    if (curr.next != null) {
                        curr.right.next = curr.next.left;
                    }
                }
                curr = curr.next;
            }
            curr = head.left;
        }
    }
}