// Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int prev = nums[0];
        for (int i = 1; i < length; i++) {
            if (prev == nums[i]) {
                return true;
            } else {
                prev = nums[i];
            }
        }
        return false;
    }
}