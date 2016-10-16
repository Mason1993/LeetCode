// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
// e.g. [1,2,3,4,5,99,99,99] 5 [3,4] 2 => [1,2,3,3,4,4,5,99]

// use the idea that nums1 array has sufficient space (nums1.length >= m + n - 1)
// cannot generate a new array and then assign it to nums1 by using nums1 = result. It requires merging into nums1 so we have to check the value that nums1 refers to instead of making nums1 refer to another value
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        for (; index >= 0 && i >= 0 && j >= 0; index--) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}