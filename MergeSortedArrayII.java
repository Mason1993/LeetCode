// Language 
// MasonZhou 
//  Merge Two Sorted Arrays

//  Description
//  Notes
//  Testcase
//  Judge
// Merge two given sorted integer array A and B into a new sorted integer array.

// Have you met this question in a real interview? Yes
// Example
// A=[1,2,3,4]

// B=[2,4,5,6]

// return [1,2,2,3,4,4,5,6]

// Challenge 
// How can you optimize your algorithm if one array is very large and the other is very small?

// Tags 
// Sorted Array Array
// Related Problems 
// Easy Intersection of Two Arrays II 21 %
// Easy Intersection of Two Arrays 24 %
// Easy Merge Two Sorted Lists 38 %
// Medium Merge k Sorted Lists 28 %
// Easy Merge Sorted Array

// the following is the basic case
// for followup question, maybe use binary search to find the insertion index in A[i] for B[j]. Time Complexity is klogn + n
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    private void reverse (ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
    
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0 || nums.size() == 1) {
            return;
        } 
        
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                reverse(nums, 0, i - 1);
                reverse(nums, i, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
}