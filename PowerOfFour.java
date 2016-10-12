// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

// Example:
// Given num = 16, return true. Given num = 5, return false.

// Follow up: Could you solve it without loops/recursion?

// Credits:
// Special thanks to @yukuairoy for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Bit Manipulation
// Hide Similar Problems (E) Power of Two (E) Power of Three

// Recursive way. Iterative way refer to PowerOfTwo or PowerOfThree
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1 || num == 4) {
            return true;
        }
        if (num % 4 != 0) {
            return false;
        }       
        return isPowerOfFour(num / 4);
    }
}