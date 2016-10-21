// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

// Example:
// Given nums = [-2, 0, 3, -5, 2, -1]

// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
// Note:
// You may assume that the array does not change.
// There are many calls to sumRange function.
// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming
// Hide Similar Problems (M) Range Sum Query 2D - Immutable (M) Range Sum Query - Mutable (M) Maximum Size Subarray Sum Equals k

public class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        this.sum = helper(nums);
    }

    public int sumRange(int i, int j) {
        if (i < 0 || j < 0 || i >= sum.length || j >= sum.length || j < i) {
            return 0;
        }
        return i == 0 ? sum[j] : sum[j] - sum[i - 1];
    }
    
    // O(n)
    private int[] helper(int[] nums) {
        int[] sum = new int[nums.length];
        System.arraycopy(nums, 0, sum, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            sum[i] += sum[i - 1];
        }
        return sum;
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

// initial solution, time limit exceeded, O(n^2). Consider the time complexity of the brute force solution is O(n)
public class NumArray {
    private int[][] res;
    public NumArray(int[] nums) {
        this.res = helper(nums);
    }

    public int sumRange(int i, int j) {
        return res[i][j];
    }
    
    private int[][] helper(int[] nums) {
        int[][] res = new int[nums.length][nums.length];
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i][i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            for (start = 0; start + i < nums.length; start++) {
                res[start][start + i] = res[start][start + i - 1] + nums[start + i];
            }
        }
        return res;
    }
}