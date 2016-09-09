// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.

// click to show follow up.

// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

// Could you come up with an one-pass algorithm using only constant space?

// Hide Tags Array Two Pointers Sort
// Hide Similar Problems (M) Sort List (M) Wiggle Sort (M) Wiggle Sort II

//optimal solution, T: O(n), Space: O(1). One pass.
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        // leftPointer is the right bound of element 0 while rightPoiner is the left bound of element 1. Elements with Index < leftPointer and Index > rightPointer are sorted already.
        int leftPointer = 0, rightPointer = nums.length - 1, currPointer = 0;
        
        while (currPointer <= rightPointerpublic class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int leftPointer = 0, rightPointer = nums.length - 1, currPointer = 0;
        
        // If the currPointer is located in (0, leftPointer) or (rightPointer, nums.length), the sort is done since there two areas are sorted based on the above comments. currPointer >= leftPointer always holds. So no need to check it.
        // Note: the area range is exclusive so do check when currPointer == rightPointer condition
        while (currPointer <= rightPointer) { 
            if (nums[currPointer] == 0) {
                swap(nums, leftPointer, currPointer);
                currPointer++;
                leftPointer++;
            } else if (nums[currPointer] == 2) {
                swap(nums, currPointer, rightPointer);
                rightPointer--;
            } else {
                currPointer++;
            }
        }
        
    }
    
    private void swap (int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}) { // if curr
            if (nums[currPointer] == 0) {
                swap(nums, leftPointer, currPointer);
                currPointer++;
                leftPointer++;
            } else if (nums[currPointer] == 2) {
                swap(nums, currPointer, rightPointer);
                //currPointer++;
                rightPointer--;
            } else {
                currPointer++;
            }
        }
        
    }
    
    private void swap (int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}

// 1st try, O(n), simple implementation. Key idea, count each color number then fill nums[]
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int redNum = 0, whiteNum = 0, blueNum = 0;
        for (int color : nums) {
            switch (color) {
                case 0:
                    redNum++;
                    break;
                case 1:
                    whiteNum++;
                    break;
                case 2:
                    blueNum++;
                    break;
            }
        }

        for (int i = 0; i < redNum; i++) {
            nums[i] = 0;
        }
        for (int i = redNum; i < redNum + whiteNum; i++) {
            nums[i] = 1;
        }
        for (int i = redNum + whiteNum; i < redNum + whiteNum + blueNum; i++) {
            nums[i] = 2;
        }
    }
}