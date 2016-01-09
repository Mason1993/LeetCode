// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

// tag: array, binary search

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {     // if the condition is start < end, the loop may never terminate if nums[start] < target < nums[end] && start + 1 = end;
            int mid = start + (end - start) / 2;  // better than mid = (start + end) / 2 since (start + end) may exceed Integer.MAX_VALUE
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid; 
            }
        }
        // case 1
        if (nums[start] > target) {  // out of boundary, target smaller than head
            return 0;
        // case 2
        } else if (nums[end] < target) { // out of boudary, target smaller than tail
            return end + 1;  // or return nums.length
        // case 3
        } else if (nums[start] == target) { 
            return start;
        // case 4
        } else {   // no matter nums[end] == target or nums[start] < target < nums[end]
            return end;
        }
    }
}