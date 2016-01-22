// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 

// Tags Array Backtracking
// Similar Problems (M) Combination Sum

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> cmb = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, cmb, result);
        return result;
    }
    
    private void combinationSum2Helper(int[] candidates, int target, int start, List<Integer> cmb, List<List<Integer>> result) {
        if (target == 0) {
            // for (int j = 0; j < cmb.size(); j++) {
            //     System.out.println(cmb.get(j));
            // }
            result.add(new ArrayList<Integer>(cmb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != start && candidates[i] == candidates[i - 1]) {
                //System.out.println(candidates[i] + " and " + candidates[i - 1]);
                continue;
            }
            cmb.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i + 1, cmb, result);
            cmb.remove(cmb.size() - 1);
        }
    }
}