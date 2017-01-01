// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

// Example:
// Given a = 1 and b = 2, return 3.

// Credits:
// Special thanks to @fujiaozhu for adding this problem and creating all test cases.

// Hide Company Tags Hulu
// Hide Tags Bit Manipulation
// Hide Similar Problems (M) Add Two Numbers

// "&" AND operation, for example, 2 (0010) & 7 (0111) => 2 (0010)

// "^" XOR operation, for example, 2 (0010) ^ 7 (0111) => 5 (0101)

// 1111 is -1, in two's complement

// Reference:

// https://en.wikipedia.org/wiki/Two%27s_complement

// https://www.cs.cornell.edu/~tomf/notes/cps104/twoscomp.html

// For this, problem, for example, we have a = 1, b = 3,

// In bit representation, a = 0001, b = 0011,

// First, we can use "and"("&") operation between a and b to find a carry.

// carry = a & b, then carry = 0001

// Second, we can use "xor" ("^") operation between a and b to find the different bit, and assign it to a,

// Then, we shift carry one position left and assign it to b, b = 0010.

// Iterate until there is no carry (or b == 0)

// Be aware that we can do bitwise ops like & or ^ to integer directly (when doing bitwise ops, decimal numbers are treated like binary), no need to convert decimal integer to binary number first
public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        
        return a;
    }
}