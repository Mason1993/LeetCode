// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.

// Hide Tags Array Greedy

// optimal solution, greedy algorithm, always save the farest positon it can reach
// T: O(n)
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int farest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= farest && nums[i] + i > farest) {  // to ensure that position i is reachable and it can reach farthur position at position i
                farest = nums[i] + i;
            }
        }
        
        return farest >= nums.length - 1;
    }
}

// 1st try, dynamic programing
// T: O(n^2)
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int length = nums.length;
        boolean[] result = new boolean[length];
        System.out.println(result[0]);
        result[0] = true;
        
        for (int i = 1; i < length; i++) {
            boolean canJumpLocal = false;
            for (int j = i - 1; j >= 0; j--) {
                if (result[j] == true ) {
                    if (nums[j] >= i - j) {
                        result[i] = true;
                        break;
                    }
                } else {
                    return false;
                }
            }
        }
        return result[length - 1];
    }
}