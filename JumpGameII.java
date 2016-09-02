// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// For example:
// Given array A = [2,3,1,1,4]

// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

// Note:
// You can assume that you can always reach the last index.

// Hide Tags Array Greedy

// optimal solution, greedy algorithm
// T: O(n)
// 二指针问题，最大覆盖区间。
// 从左往右扫描，维护一个覆盖区间，每扫过一个元素，就重新计算覆盖区间的边界。比如，开始时区间[start, end], 遍历A数组的过程中，不断计算A[i]+i最大值（即从i坐标开始最大的覆盖坐标），并设置这个最大覆盖坐标为新的end边界。而新的start边界则为原end+1。不断循环，直到end> n.
// ref: http://fisherlei.blogspot.com/2012/12/leetcode-jump-ii.html
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = 0, jumps = 0;
        int farest = 0;
        while (farest < nums.length - 1) {
            jumps++;
            for (int i = start; i <= end; i++) {
                if (i + nums[i] > farest) {
                    farest = i + nums[i];
                }
            }
            start = end + 1;
            end = farest;
        }
        return jumps;
    }
}

// 1st try, dynamic programming, Time limit excceeds
// T: O(n^2)
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] result = new int[nums.length]; // the min jumps count to reach each index
        result[0] = 0;
        
        for (int i = 1; i < nums.length; i++) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i && result[j] != Integer.MAX_VALUE) { 
                    result[i] = result[j] + 1;  // since given i > j, result[i] must bigger or equal to result[j] (a jump with max_length == 4 doesnt mean a jump length have to be 4, it can be any non negative number smaller than 4). Therefore, we start from the small index to large index. As long as we can jump from i to j, we don't need to calculate the jump from i + 1, i + 2, etc. to j since it must take at least same (or even more) jumps to j. 
                    break;
                }
            }
        }
        
        return result[nums.length - 1];
    }
}