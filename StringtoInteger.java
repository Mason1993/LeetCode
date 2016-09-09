// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

// spoilers alert... click to show requirements for atoi.

// Hide Tags Math String
// Hide Similar Problems (E) Reverse Integer (H) Valid Number

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        double result = 0;
        str = str.trim();
        int index = 0;
        
        char flag = '+';
        if (str.charAt(index) == '+') {
            flag = '+';
            index++;
        } else if (str.charAt(index) == '-') {
            flag = '-';
            index++;
        }
        
        for (; index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'; index++ ) {
            result = result * 10 + (str.charAt(index) - '0');  // the return data type of char minus char is int, int add double return double since int will be automatically promoted to double before adding. double = double + int, correct. However, int  = double + int, wrong, double cannot be converted to int automatically.
        }
        
        if (flag == '-') {
            result = -1 * result;
        }
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
        
    }
}