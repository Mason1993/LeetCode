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


// Optimal Solution, Binary search, divide and conquer, O(log(m + n)), refer to http://www.cnblogs.com/yuzhangcmu/p/4138184.html
// 1. 我们借用findKthNumber的思想。先实现findKthNumber，如果是偶数个，则把中间2个加起来平均，奇数就用中间的。

// 2. 为了达到LOG级的复杂度，我们可以这样：

// 每次在A，B取前k/2个元素。有以下这些情况：

// 1).  A的元素不够k/2. 则我们可以丢弃B前k/2. 反之亦然

// 证明：

// 我们使用反证法。

// 假设第K大在B的前k/2中，例如位置在索引m(m <= k/2-1)那么A必然拥有前k中的k -(m+1)个元素，而

// m <= k/2-1,则 m+1 <= k/2  , k - (m+1) > k/2与条件：A的元素不够k/2矛盾，所以假设不成立，得证。

// 举个栗子：

// A: 6 7 8

// B: 1 2 3 4 5

// 找第8大的数字，

// 2). A[mid] < B[mid] (mid是k/2 -1索引处的元素）。

// 这种情况下，我们可以丢弃A前k/2。

// 证明：

// 我们使用反证法。

// 假设第K大在A的前k/2中记为maxK，例如位置在索引m(m <= k/2-1)那么B必然拥有前k中的k -(m+1)个元素，而

// m <= k/2-1,则 m+1 <= k/2  , k - (m+1) > k/2

// 推出B[mid] <= maxK

// 而A[mid] >= maxK 推出 A[mid]>=B[mid], 与题设矛盾。所以假设不能成立。

// 举个栗子：

// A: 1 2

// B: 4 5 6 7 8

// 找第四大的数字 我们就可以首先排除1，2.

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKthElement(nums1, 0, nums2, 0, len / 2) + findKthElement(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKthElement(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }
    
    private int findKthElement (int[] nums1, int nums1Start, int[] nums2, int nums2Start, int k) {
        if (nums1Start > nums1.length - 1) {
            return nums2[nums2Start + k - 1];
        }
        
        if (nums2Start > nums2.length - 1) {
            return nums1[nums1Start + k - 1];
        }
        if (k == 1) { // cannot place this at the begining as the nums1Start and nums2Start may be larger than their lengths
            return Math.min(nums1[nums1Start], nums2[nums2Start]);
        }
        int mid1 = nums1Start + k / 2 - 1 < nums1.length ? nums1[nums1Start + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = nums2Start + k / 2 - 1 < nums2.length ? nums2[nums2Start + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (mid1 < mid2) { // start index is nums1Start + k / 2 rather than nums1Start + k / 2 - 1 !! 
            return findKthElement(nums1, nums1Start + k / 2, nums2, nums2Start, k - k / 2); // use k - k / 2 is to avoid the error caused by lossing precision (k / 2). If k / 2 was removed, then the remaining part would be k - k / 2
        } else {
            return findKthElement(nums1, nums1Start, nums2, nums2Start + k / 2, k - k / 2);
        }
    }
}

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