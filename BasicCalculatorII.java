// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// You may assume that the given expression is always valid.

// Some examples:
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
// Note: Do not use the eval built-in library function.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags String
// Hide Similar Problems (H) Basic Calculator (H) Expression Add Operators

public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0 ) {
            return 0;
        }
        //s = s.replaceAll("\\s",""); // remove white space. If using this, then no need to check if c == ' '
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char sign = '+';
        int len = s.length(), num = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + s.charAt(i) - '0';
            } 
            if (!Character.isDigit(c) && c != ' ' || i == s.length() -1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }
}