// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

// click to show spoilers.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Array Binary Search

// find pass the special case, no peak
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (nums[middle] > nums[middle - 1] && nums[middle] < nums[middle + 1]) {
                start = middle;
            } else if (nums[middle] < nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                end = middle;
            } else if (nums[middle] < nums[middle - 1] && nums[middle] < nums[middle + 1]) {
                start = middle;
            } else {
                return middle;
            }
        }
        
        if (nums[start] < nums[end]) {
            return end;
        } else if (nums[start] > nums[end]) {
            return start;
        }
        return 0;
    }
}