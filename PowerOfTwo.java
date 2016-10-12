// Given an integer, write a function to determine if it is a power of two.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Math Bit Manipulation
// Hide Similar Problems (E) Number of 1 Bits (E) Power of Three (E) Power of Four

// Bit Manipulation. If n is power of 2, then in binary form n has and only has ONE (most significant) digit with all remaining digits 0. Therefore n & n-1 should be 0
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }
}

// Iterative way
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n % 2 == 0) {
            n = n / 2;
        }
        
        return n == 1;
    }
}

// Recursive solution
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 2) { // Can be combined to n == 1 only since n will become 1 eventaully if n === 2.
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }       
        return isPowerOfTwo(n / 2);
    }
}