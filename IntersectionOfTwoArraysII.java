// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
// Subscribe to see which companies asked this question

// Hide Tags Binary Search Hash Table Two Pointers Sort
// Hide Similar Problems (E) Intersection of Two Arrays

// Initial solution, using hashmap, O(n), but there is better solution using two hashmaps, similar to intersectionoftwoarrays problem. check if interset hashmap contains int i : nums2
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Map <Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map <Integer, Integer> map2 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> interset = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (map2.containsKey(i)) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }
        
        int size = 0;
        for (int i : map1.keySet()) {
            if (map2.containsKey(i)) {
                int count = Math.min(map1.get(i), map2.get(i));
                size += count;
                interset.put(i, count);
            }
        }
        int[] res = new int[size];
        int j = 0;
        for (int i : interset.keySet()) {
            int count = interset.get(i);
            while (count > 0) {
                res[j] = i;
                j++;
                count--;
            }
        }
        return res;
    }
}