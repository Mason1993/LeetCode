// Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int length = nums.length;
        int prev = nums[0];
        int l = 0;
        if (k == 1) {
            for (int i = 1; i < length; i++) {
                if (prev == nums[i]) {
                    return true;
                } else {
                    prev = nums[i];
                }
            }
            return false;
        }
        if (k > length) {
            Arrays.sort(nums);
            for (int i = 1; i < length; i++) {
            if (prev == nums[i]) {
                return true;
            } else {
                prev = nums[i];
            }
            }
            return false;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; i + j * k + k < length; j++) {
                for (l = 1; l <= k; l++ ) {
                   if (prev == nums[i + j * k + l]) {
                      return true;
                   } else {
                      prev = nums[i + j * k + l];
                   } 
                }
            }
        }
        return false;
    }
}