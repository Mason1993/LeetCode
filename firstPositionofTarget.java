// First Position of Target

// For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

// If the target number does not exist in the array, return -1.

// If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

// similar to basic binary search. We just to remove if (target == nums[middle]) return middle situation.
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
        	return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start + 1 < end) {
        	middle = start + (end - start) / 2;
        	if (target < nums[middle]) {
        		end = middle;
        	} else {
        		start = middle;
        	}
        }
        if (target == nums[start]) {   // must check start index first since required to return first target index
        	return start;
        } else if (target == nums[end]) {
        	return end;
        } else {
        	return -1;
        }
    }
}
// my initial algorithm, could be very slow if there are lots of duplications.
// worse case, nums = [1,1,1,..., 1,1,1] target = 1. O(n)
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
        	return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start + 1 < end) {
        	middle = start + (end - start) / 2;
        	if (target == nums[middle]) {
        		return getFirstDup(nums, middle);
        	} else if (target < nums[middle]) {
        		end = middle;
        	} else {
        		start = middle;
        	}
        }
        if (target == nums[start]) {
        	return getFirstDup(nums, start);
        } else if (target == nums[end]) {
        	return getFirstDup(nums, end);
        } else {
        	return -1;
        }
    }

    public int getFirstDup(int[] nums, int index) {
    	for (int i = index; i > 0; i--) {
    		if (nums[i] == nums[i - 1]) {
    			continue;
    		}
    		return i;
    	}
    	return index;
    }
}