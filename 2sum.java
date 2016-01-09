// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

// in this problem, index1 and index2 has to be different number.
// time complexity O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // in hashmap, the difference (namely the expected nums[index2] value) between nums[i] and target is stored. 
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {  // if nums[i] can matach any difference in hashmap, then the index pair is found
                result[0] = map.get(nums[i]) + 1; // the index of the matched difference should be smaller, so it is index1.
                result[1] = i + 1;
            } else {                          // if nums[i] didnt match all difference in hashmap, add its difference between target to hashmap
                map.put(target - nums[i], i);  // the value that can help to reach the target is stored in hashmap
            }
        }
        return result;
    }
}