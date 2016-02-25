public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        if (nums.length == 1) {
            result.add(nums);
            return result;
        }
        
        List<Integer> temp = new ArrayList<Integer> ();
        int numofPermute = nums.length * nums.length / 2;
        Set<List<Integer>> set = new Hashset<List<Integer> ();
        for (int i = 0; i < numsofPermute + 1; i++) {
            
        }
    }
}