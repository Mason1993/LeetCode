// Given a non-negative number represented as an array of digits, plus one to the number.
//The digits are stored such that the most significant digit is at the head of the list.
// e.g. [9] => [1,0], [0] => [1]
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int rst = 1;
        int mod;
        if (digits.length == 1 && digits[0] < 9) {
            digits[0]++;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            mod = (rst + digits[i]) % 10;
            rst = (rst + digits[i]) / 10;
            digits[i] = mod;
        }
        if ( rst != 0 ) {
            int[] result = new int[digits.length + 1];
            result[0] = rst;
            for (int i = 1; i <= digits.length; i++) {
                result[i] = digits[i-1];
            }
            return result;
        } else {
            return digits;
        }
    }
}