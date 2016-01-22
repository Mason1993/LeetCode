// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 
// Tags Array Backtracking
// Similar Problems (M) Letter Combinations of a Phone Number (M) Combination Sum II (M) Combinations (M) Combination Sum III (M) Factor Combinations

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> cmb = new ArrayList<Integer> ();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, cmb, result);
        return result;
    }
    
    private void combinationSumHelper(int[] candidates, int target, int start, List<Integer> cmb, List<List<Integer>> result) {
        // exit condition 
        if (target == 0) {
            // print all elements in list
            // for (int j = 0; j < cmb.size(); j++) {
            //     System.out.println(cmb.get(j));
            // }
            result.add(new ArrayList<Integer>(cmb));  // why need to initialize a new ArrayList here?
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // candidates[i] > target, which means that the current solution is invalid
            if (candidates[i] > target) {
                break;
            }
            // remove duplicates
            if (i != start && candidates[i] == candidates[i -1]) {
                continue;
            }
            cmb.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, cmb, result); // need to set start index == i since it is allowed that same element can be used multiple times
            cmb.remove(cmb.size() - 1); // each time add new element into the temp result, cmb, we also need to remove it in the last so that we can get a empty cmb in next for loop iteration.
        }
    }
}