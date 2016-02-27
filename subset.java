// Given a set of distinct integers, nums, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

// Tags Array Backtracking Bit Manipulation
// Similar Problems (M) Generalized Abbreviation


// just use backtracking template
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if (nums == null) {
            return res;
        }
        
        List<Integer> list = new ArrayList<Integer> ();
        Arrays.sort(nums);
        int index = 0;
        helper(res, list, nums, index);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        if (list.size() <= nums.length) {   // note: different from permutation, we need to get its subsets. So don't do size == length here.
            res.add(new ArrayList<Integer>(list));
            if (list.size() == nums.length) {
                return;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i < index || list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            index = i;
            helper(res, list, nums, index);
            list.remove(list.size() - 1);    // undo changes
            index = i;                       // undo changes
        }
    }
}