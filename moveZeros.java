// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

// solution 1, double pointer
public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        if (start <= length) {
            for (int i = start; i < length; i++) {
                nums[i] = 0;
            }
        }
    }
}

// solution 2, not in place
public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                result[j] = nums[i];
                j++;
            } 
        }
        System.arraycopy(result, 0, nums, 0, length);
    }
}