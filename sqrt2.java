// Implement int sqrt(int x).  with n digit precision

// Compute and return the square root of x.

// Tags Math Binary Search
// Similar Problems (M) Pow(x, n)


public class Solution {
    public double mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        double start = 0;
        double end = (double)(x);
        double middle = 0;
        while (end - start > 1e-4) {
            middle = start + (end - start) / 2;
            if (x / middle == middle) {
                System.out.println(middle);
                return middle;
            } else if (x / middle < middle) {
                end = middle;
            } else {
                start = middle;
            }
        }
        System.out.println(middle);
        return middle;
    }
}