// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Heap Divide and Conquer
// Hide Similar Problems (M) Wiggle Sort II (M) Top K Frequent Elements (E) Third Maximum Number


import java.util.concurrent.ThreadLocalRandom;
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k < 0) {
            return -1;
        } 
        //shuffle(nums);
        int res = quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
        return res;
    }
    
    // return the k-th smallest element from nums
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pos = partition(nums, left, right);
        if (pos + 1 == k) {
            return nums[pos];
        } else if (pos + 1 < k) {
            return quickSelect(nums, pos + 1, right, k);
        } else {
            return quickSelect(nums, left, pos - 1, k);
        }
    }
    
    // return the index of pivot, which is bigger than the elements on its left and smaller than the elements on its right
    private int partition(int[] nums, int start, int end) {
        //int random = ThreadLocalRandom.current().nextInt(start, end + 1);
        // Random random = new Random();
        // int rand = random.nextInt(end - start + 1) + start;
        int left = start, right = end, pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
         }
         nums[left] = pivot;
         return left;
    }
    
    // private void shuffle (int[] nums) {
    //     Random random = new Random ();
    //     for (int i = 0; i < nums.length; i++) {
    //         int r = random.nextInt(i + 1);
    //         swap(nums, i, r);
    //     }
    // }
    
    // private void swap (int[] nums, int left, int right) {
    //     int temp = nums[left];
    //     nums[left] = nums[right];
    //     nums[right] = temp;
    // }
}