// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

// Tags Array Binary Search
// Similar Problems (M) Search in Rotated Sorted Array II (M) Find Minimum in Rotated Sorted Array


//                         0   |
//   (section 1)       0       |
//                 0           |
//             0               |
// - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//                             |              0   
//                             |           0
//                             |       0       (section 2)
//                             |    0
//                             | 0 

// The key thought of binary search is to decrease the problem size from O(n) to O(n/2).         
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null && nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // if the mid is in the section 1
            if (nums[mid] > nums[0]) {
                if (nums[mid] == target) {
                    return mid;
                // in the monotonically increasing part
                } else if (target < nums[mid] && target >= nums[0]) {   // use >=. be careful that the head should be included
                    end = mid;
                } else {
                    start = mid;
                }
            }
            else {  // if the mid is in the section 2
                if (nums[mid] == target) {
                    return mid;
                // in the monotonically increasing part
                } else if (target > nums[mid] && target <= nums[nums.length - 1]) {  // use <=. be careful that the tail should be included
                    start = mid;
                } else {
                    end = mid;
                } 
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}