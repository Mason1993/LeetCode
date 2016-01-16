// Find the contiguous subarray within an array (containing at least one number) which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

// Subscribe to see which companies asked this question

// Tags Array Dynamic Programming
// Similar Problems (M) Maximum Subarray (E) House Robber (M) Product of Array Except Self

public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        min[0] = max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}