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
    if(candidates == null || candidates.length == 0)
        return result;
 
    Arrays.sort(candidates);            
 
    ArrayList<Integer> temp = new ArrayList<Integer>();    
    getCombination(candidates, 0, target, temp, result);
 
    HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);
 
    //remove duplicate lists
    result.clear();
    result.addAll(set);
 
    return result;
}
 
public void getCombination(int[] candidates, int start, int target, ArrayList<Integer> temp, List<List<Integer>> result){
    if(target == 0){
        ArrayList<Integer> t = new ArrayList<Integer>(temp);
        result.add(t);
        return;
    }
 
    for(int i=start; i<candidates.length; i++){
        if(target < candidates[i])
            continue;
 
        temp.add(candidates[i]);
        getCombination(candidates, i+1, target-candidates[i], temp, result);
        temp.remove(temp.size()-1);
    }
}
}