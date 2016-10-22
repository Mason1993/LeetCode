// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.
// Subscribe to see which companies asked this question

// Hide Tags Binary Search Hash Table Two Pointers Sort
// Hide Similar Problems (E) Intersection of Two Arrays II


//optimized hashset solution, O(n). This problem can also be done using two pointer or binary search with complexity O(nlogn)
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //int[] res = new int[Math.min(nums1.length, nums2.length)];
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> interset = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if(set1.contains(i)) {
               interset.add(i); 
            }
        }
        int[] res = new int[interset.size()];
        int j = 0;
        for (int i : interset) {
            res[j] = i;
            j++;
        }
        return res;
    }
}

// Initial Solution, using hashset
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //int[] res = new int[Math.min(nums1.length, nums2.length)];
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i : set1) {
            if (set2.contains(i)) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}