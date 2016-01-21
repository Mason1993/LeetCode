// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

// Subscribe to see which companies asked this question

// Tags Array
// Similar Problems (H) Trapping Rain Water (M) Maximum Product Subarray (H) Paint House II

//solution 1
//Note: for output[i] is equal to the product of all the elements of nums except for itself. It does not ask you to output all possible product generated from the elements from nums.
// supposed given an array nums = [a1,a2,a3,a4], the expected output is result = [a2a3a4,a1a3a4,a1a2a4,a1a2a3].
// We can consider the result is the product of two arrays, arr1 = [1, a1, a1a2, a1a2a3], arr2 = [a2a3a4, a3a4, a4, 1]. So we can observe that arr1 is obtained forwards, and arr2 is obtained backwards.
// Space is O(n)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        arr1[0] = 1;
        arr2[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            arr1[i] = nums[i - 1] * arr1[i - 1];  // generate arr1
            arr2[nums.length - i - 1] = nums[nums.length - i] * arr2[nums.length - i];  // generate arr2.
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = arr1[i] * arr2[i];
        }
        return result;
    }
}

// solution 2. Space is O(1). Here we use right to store the temp result of backward multiplication
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return result;
        }
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            result[i] *= right;
        }
        return result;
    }
}

