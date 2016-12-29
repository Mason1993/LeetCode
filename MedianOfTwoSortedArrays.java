// There are two sorted arrays nums1 and nums2 of size m and n respectively.

// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

// Example 1:
// nums1 = [1, 3]
// nums2 = [2]

// The median is 2.0
// Example 2:
// nums1 = [1, 2]
// nums2 = [3, 4]

// The median is (2 + 3)/2 = 2.5
// Hide Company Tags Google Zenefits Microsoft Apple Yahoo Dropbox Adobe
// Hide Tags Binary Search Array Divide and Conquer

// Brute force, Time complexity: O( (m+n)log(m+n) )
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] total = new int[len];
        System.arraycopy(nums1, 0, total, 0, nums1.length);
        System.arraycopy(nums2, 0, total, nums1.length, nums2.length);
        Arrays.sort(total);
        if (len % 2 == 0) {
            return (total[len / 2 - 1] + total[len / 2]) / 2.0;
        } else {
            return total[(len - 1) / 2];
        }
    }
}