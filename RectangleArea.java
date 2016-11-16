// Find the total area covered by two rectilinear rectangles in a 2D plane.

// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

// Rectangle Area
// Assume that the total area is never beyond the maximum possible value of int.

// Credits:
// Special thanks to @mithmatt for adding this problem, creating the above image and all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Math

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F);
        int top = Math.max(Math.min(D, H), bottom);
        
        int overlap = (right - left) * (top - bottom); // overalpping area
        int res = (C - A) * (D - B) + (G - E) * (H - F) - overlap;
        return res;       
    }
}