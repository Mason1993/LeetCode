// Note: This is an extension of House Robber.

// After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Credits:
// Special thanks to @Freezen for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming
// Hide Similar Problems (E) House Robber (M) Paint House (E) Paint Fence (M) House Robber III

// consider this problem is the follow up question to hosue robber I. Since now all houses are in a circle, first and last house cannot be robbered at the same time. Therefore, we consider convert this problem to rob houses from 0 to n - 2 and from 1 to n - 1 (n == nums.length), then return the bigger one as result
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int res = Math.max(helper(nums, 0), helper(nums, 1));
        return res;
    }
    
    private int helper (int[] nums, int start) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = 0;
        res[1] = nums[start];
        for(int i = 2; i < n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i-1+start]);
        }
        return res[n - 1];
    }
}