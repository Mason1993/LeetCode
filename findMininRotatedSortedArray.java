// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Tags Array Binary Search
// Similar Problems (H) Search in Rotated Sorted Array (H) Find Minimum in Rotated Sorted Array II


// best solution 
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];
        
        // find the smallest element must be among pivot point and nums[nums.length - 1]. 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {         // guarantee that end element alway on the lower part.
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] <= target) {    // nums[start] <= target indicates that nums[start] on the lower part. In that case, nums[start] must be less than nums[end] since it's sorted
            return nums[start];
        } else {
            return nums[end];  // end element always on the lower part and only goes left (decreasing)
        } 
    }
}

// initial solution
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int result = Integer.MAX_VALUE;    // we can use nums[nums.length - 1] as inital since under every circumstance result should be less than it.
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // on the side above nums[0]
            if (nums[mid] > nums[0]) {
                start = mid;
            // on the side below nums[0]
            } else {
                if (nums[mid] < result) {
                    result = nums[mid];      // don't need to update the result every time. Just narrow down the range and compare in the last.
                }
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            if (nums[end] < result) {
                result = nums[end];
            }
        } else {
            if (nums[start] < result) {
                result = nums[start];
            }
        }
        if (result < nums[0]) {
            return result;
        } else {
            return nums[0];
        }
        
    }
}