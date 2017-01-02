// Given an integer array, heapify it into a min-heap array.

// For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
// Have you met this question in a real interview? Yes
// Clarification
// What is heap?

// Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

// What is heapify?
// Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

// What if there is a lot of solutions?
// Return any of them.
// Example
// Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

// Challenge 
// O(n) time complexity

// Tags 
// LintCode Copyright Heap


// T: O(n), S: O(1) extra space

// 楼主看这里：https://en.wikipedia.org/wiki/Binary_heap#Building_a_heap

// 中心思想是：首先把head想做树，如果从下往上数（倒数）第h层的所有点已经是heapified的了，那么让倒数第h+1层的一个点heapify所需要的操作数最多是h步（最坏情况，最小堆里这个数是最大的，所以需要把它一层一层往下转移直到最底层）。所以对每一个h+1层的点（node）来说，复杂度O(h)。h+1层有这么多点：n/2^(k+1)，所以总得复杂度就是O(h) * (n/2^(k+1)) 再对所有层数求和。最终结果就是个O(n)的。
// 具体公式请到wikipedia查看，注意这句：This uses the fact that the given infinite series h / 2h converges to 2.

// 对于siftup其实是那个straight forward的算法
// 每拿出来一个数放进数组（可以想象成queue）的最后，然后和他的father比较大小。
// 对于每个数是log(n)的时间（worst case）总共有n个数

// 道理确实是一样的，intuitively，不同的地方在于：假设h代表第几层，你的方法随着h增加，每层的点数也在增加，h最大的时候，也就是switch有可能最多的时候，点数是一层是2^h个点。但是lz得方法随着h的增加（倒数），每层的点数在减小，h最大的时候只有一个点。
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = A.length / 2; i>= 0; i--) {
            shiftDown(A, i);
        }
    }
    
    // heapify the node indexed k 
    private void shiftDown (int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if (2 * k + 1 < A.length && A[2 * k + 1] < A[smallest]) {
                smallest = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2 * k + 2] < A[smallest]) {
                smallest = 2 * k + 2;
            }
            if (smallest == k) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;
            
            k = smallest;
        }
    }

// Version 2: shiftup This cost O(nlogn)
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    private void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) / 2;
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;
            
            k = father;
        }
    }
    
    public void heapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }
}
}