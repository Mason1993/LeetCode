// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
// Subscribe to see which companies asked this question

// Hide Tags Backtracking String
// Hide Similar Problems (M) Letter Combinations of a Phone Number (E) Valid Parentheses

//Backtracking, be aware that left paretheses number in current string must be always larger or equal to the right parentheses number
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        helper(res, "", n, n);
        return res;
    }
    
    private void helper(List<String> res, String str, int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            res.add(str);
            return;
        }
        
        if (leftNum > 0) {
            helper(res, str + "(", leftNum - 1, rightNum);
        }
        if (rightNum > 0 && leftNum < rightNum) {
            helper(res, str + ")", leftNum, rightNum - 1);
        }
    }
}