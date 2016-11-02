// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// For example,
// Given nums = [0, 1, 3] return 2.

// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Array Math Bit Manipulation
// Hide Similar Problems (H) First Missing Positive (E) Single Number (H) Find the Duplicate Number

// bit manipulation
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int res = nums.length;
        for (int i = 0; i < n; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}

// sum version
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        return n * (n + 1) / 2 - sum;
    }
}

// if the array was sorted, binary search can be used
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == start && nums[end] == end) {
            return end + 1;
        } else if (nums[start] == start) {
            return start + 1;
        } else {
            return start;
        }
    }
}
