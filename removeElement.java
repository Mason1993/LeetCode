// Given an array and a value, remove all instances of that value in place and return the new length.

//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null ) {
            return 0;
        }
        int i = -1; // since ++i is used later, and the situation that nums[0] == val should be considered as well.
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val ) {
                nums[++i] = nums[j];  // ++i: first increase i, then pass i to nums[]. we can also use i++ here, but we should initiate i = 0 and return i correspondingly.
            }
        }
        return i + 1;
    }
}