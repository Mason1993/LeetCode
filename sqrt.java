// Implement int sqrt(int x).

// Compute and return the square root of x.

// Tags Math Binary Search
// Similar Problems (M) Pow(x, n)


public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int start = 0;
        int end = x;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (x / middle == middle) {
                return middle;
            } else if (x / middle < middle) {
                end = middle;
            } else {
                start = middle;
            }
        }
        if (x / end == end) {
            return end;
        } else {             // since for any sqrt(x) in (start, end) should return start
            return start;
        }
    }
}