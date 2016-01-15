// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

// click to show more practice.

// More practice:
// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

// Subscribe to see which companies asked this question

// Tags Divide and Conquer Array Dynamic Programming
// Similar Problems (M) Best Time to Buy and Sell Stock (M) Maximum Product Subarray

// dynamic programming
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
    }
}