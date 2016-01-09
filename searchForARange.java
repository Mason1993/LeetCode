// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

// Tags Array Binary Search
// Similar Problems (E) First Bad Version
// Next challenges: (M) Construct Binary Tree from Preorder and Inorder Traversal (M) Construct Binary Tree from Inorder and Postorder Traversal (E) Shortest Word Distance.

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            result[0] = -1;
            result[1] = 1;
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        // get the left bound first
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // case 1
            if (nums[mid] == target) {
                end = mid;
            // case 2
            } else if (nums[mid] < target) {
                start = mid;
            // case 3
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            result[0] = start;
        } else if (start + 1 < nums.length && nums[start + 1] == target) {
            result[0] = start + 1;
        } else if (nums[end] == target) {
            result[0] = end;
        } else {             // can't find the target, return [-1, -1];
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        // then find the right bound, the only two differences to finding left bound are:
        // 1. for case 1, start = mid rather than end = mid;
        // 2. in the last, determine which one among start, end - 1 (start + 1), end is right bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // case 1
            if (nums[mid] == target) {
                start = mid;
            // case 2
            } else if (nums[mid] < target) {
                start = mid;
            // case 3
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            result[1] = end;
        } else if (end - 1 < nums.length && nums[end - 1] == target) {
            result[1] = end - 1;
        } else if (nums[start] == target) {
            result[1] = start;
        } else {             // can't find the target, return [-1, -1];
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        return result;
    }
}