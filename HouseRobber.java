// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Credits:
// Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming
// Hide Similar Problems (M) Maximum Product Subarray (M) House Robber II (M) Paint House (E) Paint Fence (M) House Robber III


public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] res = new int[n+1];
        
        res[0] = 0;
        res[1] = nums[0];
        for(int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i-1]); // res[i-1] does not guarantee that nums[i-2] will be robbed
        }
        return res[n];
    }
}