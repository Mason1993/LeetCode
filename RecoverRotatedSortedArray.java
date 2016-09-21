// Given a rotated sorted array, recover it to sorted array in-place.

// Have you met this question in a real interview? Yes
// Clarification
// What is rotated array?

// For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
// Example
// [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

// Challenge 
// In-place, O(1) extra space and O(n) time.

// Tags 
// Sorted Array Array
// Related Problems 
// Medium Sort Colors 34 %
// Easy Rotate String

// Optimal Solution, 
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

// first try, neither in-place nor O(1) space.
/** note: 1. arraylist.subList return a shallow copy of the original list's sublist
 *        2. For the deep copy of an arraylist, the only way is to iterate the whole
 *           list. Clone() method in the array is not available in arraylist
 */
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0 || nums.size() == 1) {
            return;
        }
        
        List<Integer> p1 = new ArrayList<Integer>();
        List<Integer> p2 = new ArrayList<Integer>();
        
        p1.add(nums.get(0));
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                for (int j = i; j < nums.size(); j++) {
                    p2.add(nums.get(j));
                }
                break;
            } else {
                p1.add(nums.get(i));
            }
        }
        //System.out.println(p2);
        //System.out.println(p1);
        nums = new ArrayList<Integer>();
        for (int i = 0; i < p2.size(); i++) {
            nums.add(p2.get(i));
            //System.out.println(nums);
        }
        for (int i = 0; i < p1.size(); i++) {
            nums.add(p1.get(i));
            //System.out.println(nums);
        }
        return;
    }
}