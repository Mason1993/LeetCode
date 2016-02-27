public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        //HashSet<List<Integer>> set = new HashSet<List<Integer>> ();
        int[] visited = new int[nums.length];
        List<Integer> currPermute = new ArrayList<Integer> ();
        Arrays.sort(nums);
        helper(res, currPermute, nums, visited);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> currPermute, int[] nums, int[] visited) {
        if (currPermute.size() == nums.length) {
            //if (!res.contains(currPermute)) {  // time limit exceed if search res, so that is why we add additional condition for visited[] to handle two consecutive duplicated numbers situation
                res.add(new ArrayList<Integer>(currPermute));
                return;
            //}
        }
        
        for (int i = 0; i < nums.length; i++) {
            // to handle the two situations as follows, we just need to take care of the first situation and skip the recursion for the second situation. And the second visited conditions in if statement is the second recursion situation.
            // 跟 Permutations的解法一样，就是要考虑“去重”。先对数组进行排序，这样在DFS的时候，可以先判断前面的一个数是否和自己相等，相等的时候则前面的数必须使用了，自己才能使用，这样就不会产生重复的排列了。
            // 第一层递归            第二层递归            第三层递归
            // [1]                    [1,2]                [1,2,2]
            // 序号:[0]                 [0,1]            [0,1,2]
            // 这种都是OK的，但当第二层递归i扫到的是第二个"2"，情况就不一样了
            // [1]                    [1,2]                [1,2,2]            
            // 序号:[0]                [0,2]                [0,2,1]
            if (visited[i] == 1 || i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            currPermute.add(nums[i]);
            visited[i] = 1;
            //System.out.println(nums[i]);
            helper(res, currPermute, nums, visited);
            currPermute.remove(currPermute.size() - 1);
            visited[i] = 0;
        }
    }
}



// answer is right but time limit exceed.
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        //HashSet<List<Integer>> set = new HashSet<List<Integer>> ();
        int[] visited = new int[nums.length];
        List<Integer> currPermute = new ArrayList<Integer> ();
        helper(res, currPermute, nums, visited);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> currPermute, int[] nums, int[] visited) {
        if (currPermute.size() == nums.length) {
            if (!res.contains(currPermute)) {
                //set.add(new ArrayList<Integer>(currPermute));
                res.add(new ArrayList<Integer>(currPermute));
                return;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            currPermute.add(nums[i]); 
            // cannot do tif (currPermute.contains(nums[i])) anymore, since there may be multiple duplicates. so we need to think of another way to keep track of whether this element has been added/visted before.
            visited[i] = 1;
            //System.out.println(nums[i]);
            helper(res, currPermute, nums, visited);
            currPermute.remove(currPermute.size() - 1);
            visited[i] = 0;
        }
    }
}