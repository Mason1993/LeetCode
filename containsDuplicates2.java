//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  // Hashpmap is used, first element is key, second element is value
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prev = map.get(nums[i]);
                if (i - prev <= k ) {  // always compare the difference between the current and previous element, since the diff between prev of prev and current is always larger
                    return true;
                } 
            }
            map.put(nums[i], i);  // if doesnt contain that key, add it into hashmap.
        }
        return false;
    }
}