// Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

//  Notice

// There is at least one subarray that it's sum equals to zero.

// Have you met this question in a real interview? Yes
// Example
// Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);  // read comment in if first. If there is subarray's sum equal to 0, this subarray must start at 0. so 0 - 1 = -1.
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
             if (map.containsKey(sum)) {    // if it's true, it indicates that the sum in subarray (map.get(sum), i] is 0
                ans.add(map.get(sum) + 1);  // so start index should be map.get(sum) + 1
                ans.add(i);
                return ans;
            }
            map.put(sum, i);
        }
        
        return null;
    }
}