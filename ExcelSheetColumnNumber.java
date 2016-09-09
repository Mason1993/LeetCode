// Related to question Excel Sheet Column Title

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Hide Tags Math
// Hide Similar Problems (E) Excel Sheet Column Title

public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int length = s.length();
        int result = 0;
        
        for (int i = 0; i < length; i++) {
            result += Math.pow(26, length - i - 1) * (s.charAt(i) - 'A' + 1);
        }
        
        return result;
    }
}