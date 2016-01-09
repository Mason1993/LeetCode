// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
//     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

//     A solution set is:
//     (-1,  0, 0, 1)
//     (-2, -1, 1, 2)
//     (-2,  0, 0, 2)

// just a general reminder: hashset.contains() will consider [1,2,3] differs from [3,2,1]
// for every k-sum problem, the best algorithm's time complexity would be O(n^(k-1)). for 4sum, O(n^3)

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int k = nums.length - 1;
                while (l < k) {   // like 3sum problem, l => start, k => end
                    // case 1
                    if (nums[i] + nums[j] + nums[l] + nums[k] == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[k]);
                        l++;
                        k--;
                        if (!set.contains(temp)) {  // different than 3sum problem, we use hashset to avoid duplicates
                            result.add(temp);
                            set.add(temp);
                        }
                    // case 2
                    } else if (nums[i] + nums[j] + nums[l] + nums[k] < target) {
                        l++;
                    // case 3
                    } else {
                        k--;
                    }
                } 
            }
        }
        return result;
    }
}