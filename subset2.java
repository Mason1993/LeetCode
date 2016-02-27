// Given a collection of integers that might contain duplicates, nums, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If nums = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
// Tags Array Backtracking

// combination of permutation2 and subset
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if (nums == null) {
            return res;
        }
        
        List<Integer> list = new ArrayList<Integer> ();
        int [] visited = new int[nums.length];
        int index = 0;
        Arrays.sort(nums);
        helper(res, list, nums, index, visited);
        return res;
    }
    
    public void helper (List<List<Integer>> res, List<Integer> list, int[] nums, int index, int[] visited) {
        if (list.size() <= nums.length) {
            res.add(new ArrayList<Integer>(list));
            if (list.size() == nums.length) {
                return;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || i < index || i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            list.add(nums[i]);
            index = i;
            visited[i] = 1;
            helper(res, list, nums, index, visited);
            visited[i] = 0;
            index = i;
            list.remove(list.size() - 1);
        }
    }
}