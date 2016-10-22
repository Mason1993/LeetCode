public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[1];
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
        res = list.toArray(new int[]);
        return res;
    }
}