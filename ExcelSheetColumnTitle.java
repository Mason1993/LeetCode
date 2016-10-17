// Given a positive integer, return its corresponding column title as appear in an Excel sheet.

// For example:

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
// Credits:
// Special thanks to @ifanchu for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Math
// Hide Similar Problems (E) Excel Sheet Column Number

// recursive
public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        return convertToTitle((n - 1)/ 26) + (char)('A' + (n - 1) % 26);
    }
}

// iterative
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();
        while (n != 0) {
            int reminder = (n - 1) % 26;
            n = (n - 1) / 26;
            str = str.insert(0, (char)(reminder + 'A'));
        }
        return str.toString();
    }
}