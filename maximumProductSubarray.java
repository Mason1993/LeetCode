// Find the contiguous subarray within an array (containing at least one number) which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

// Subscribe to see which companies asked this question

// Tags Array Dynamic Programming
// Similar Problems (M) Maximum Subarray (E) House Robber (M) Product of Array Except Self

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // case 1
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            // case 2
            } else if (nums[i] < 0) {
                max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            // case 3, nums[i] == 0.
            } else {
                max[i] = min[i]  = nums[i];
            }
            result = Math.max(max[i], result);
        }
        return result;
    }
}