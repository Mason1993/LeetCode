// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.

//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// time complexity: O(n^2)
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE;   // get the max possible value of this data type
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length -2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(target - sum);
                if (diff == 0) {
                    return sum;
                } else {
                    if (diff < min) {
                        min = diff;    // use min variable to store the current minimum value
                        result = sum;
                    } 
                    if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
               }
            }
        }
        return result;
    }
}