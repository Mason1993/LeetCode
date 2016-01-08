// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

// Hint:

// How many majority elements could it possibly have?

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > nums.length/3) {
               result.add(entry.getKey());
            }    
        }
        return result;
    }
}