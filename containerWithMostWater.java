// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container.

// the height of max area is determined by lowest height
// solution 1, O(n), always feel like it miss some situation, for example, [1,5,7,2,5,6], pair (1,4) missed, although it is somehow always smaller than the previous maximum value, e.g. (2,5)
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        int start = 0;
        int end = length - 1;
        // in this case, start and end are initialized at the head and tail, so the distance between them can only decrease.
        while (start < end) {
            int area = 0;
            if (height[start] < height[end]) {
                area = (end - start) * height[start];
                start++;  // since the distance between start and end always decrease, the only possiblity to increase the max area is to move the lower board to see if its height can be increase thereby increase the max area
            } else {
                area = (end - start) * height[end];
                end--;
            }
            if (area > max) {
                max = area;
            }
             
        }
        return max;
    }
}

// solution 2, O(n^2/2) = O(n^2)
public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int max = Integer.MIN_VALUE;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = 0;
                if (height[i] < height[j]) {
                    temp = height[i] * Math.abs(i - j);
                } else {
                    temp = height[j] * Math.abs(i -j);
                }
                if (temp > max) {
                    max = temp;
                    result = temp;
                }
            }
        }
        return result;
    }
}