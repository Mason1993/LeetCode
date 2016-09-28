// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

// The largest rectangle is shown in the shaded area, which has area = 10 unit.
// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.

// Hide Tags Array Stack
// Hide Similar Problems (H) Maximal Rectangle

// T: O(n)
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        for (int minIndex = 0; minIndex <= heights.length; minIndex++) {
            int currH = minIndex == heights.length ? -1 : heights[minIndex];
            // use a ascending stack to get the first value smaller than current value on the left and on the right in O(n)
            // even though for some special cases, for example: arr = [1,2,3,4,5,6,0]. when push arr[6] into the stack, we need to pop all the elements in the stack which costs O(n). However the average time is still (1+1+1+1+1+1+6)/7 = O(1)
            while (!stack.isEmpty() && currH < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? minIndex : minIndex - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(minIndex);
        }
        return max;
    }
}