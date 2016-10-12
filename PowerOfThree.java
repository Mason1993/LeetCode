// Given an integer, write a function to determine if it is a power of three.

// Follow up:
// Could you do it without using any loop / recursion?

// Credits:
// Special thanks to @dietpepsi for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Math
// Hide Similar Problems (E) Power of Two (E) Power of Four

// Math Solution, slow. if n is not power of 3 then it loses precision when calculating Math.round(Math.log(n) / Math.log(3))
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}

// Iterative way, fastest
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }       
        return n == 1;
    }
}

// Recursive solution, faster
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 3) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }       
        return isPowerOfThree(n / 3);
    }
}