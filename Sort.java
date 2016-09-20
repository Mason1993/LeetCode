import java.util.*;

public class Sort {
	/**
	 * The implementation of quicksort algorithm is as follows.   
	 * It operates in-place on a given array. After sorting, the 
	 * elements of array will be in ascending order.
	 *
	 * @param   nums  an integer array
	 * @param   start the index in nums where quicksort starts
	 * @param   end   the index in nums where quicksort ends
	 * @return  void
	 */
	public static void quickSort (int[] nums, int start, int end) {
		// check if it's a valid array
		if (nums == null || nums.length == 0) {
			return;
		}

        // exit condition
		if (start >= end) {
			return;
		}
		
		int left = start, right = end;
		int pivot = nums[start + (end - start) / 2];
		
		while (left <= right) {
			while (left <= right && nums[left] < pivot) {
				left++;
			}
			while (left <= right && nums[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}

        // call quickSort recursively
		quickSort(nums, start, right);
		quickSort(nums, left, end);
	}
	
	private static void swap (int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 5, 12, 7, 8, 2, 5, 3, 17, 20, 19, 13};
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

}
