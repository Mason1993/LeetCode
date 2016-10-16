// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

// click to show spoilers.

// Have you thought about this?
// Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

// If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

// Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

// Update (2014-11-10):
// Test cases had been added to test the overflow behavior.

// Subscribe to see which companies asked this question

// Hide Tags Math
// Hide Similar Problems (E) String to Integer (atoi)

// be careful to overflow conditons, like x == -2147483648 (integer range [-2147483648, 2147483647]) or the reversed int will cause overflow
public class Solution {
    public int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        // x < 0 case can be integered into the regular case. -12 / 10 = -1. -12 % 10 = -2
        // if (x < 0) {
        //     return -1 * reverse(-1 * x);
        // }
        long result = 0;
        while (x != 0) { // be careful to the exit condition, not x / 10 != 0.
            if (result * 10 + x % 10 > Integer.MAX_VALUE || result * 10 + x % 10 < Integer.MIN_VALUE) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (int)result;
    }
}