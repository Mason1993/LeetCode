// Rotate an array of n elements to the right by k steps.
// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
// Hint:
// Could you do it in-place with O(1) extra space?
// Related problem: Reverse Words in a String II



// solution 1, O(1) space (temp), O(n) time (2n)
public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        k = k % length;
        reverse(nums, 0, length - k - 1);
        reverse(nums, length - k, length - 1);
        reverse(nums, 0, length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}

// solution 2, read imput nums twice, O(n) extra space used
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        int length = nums.length;
        k = k % length;
        int[] result = new int[length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[length - k + i];
        }
        for (int i = 0; i < length - k; i++) {
            result[i + k] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, length);
    }
}