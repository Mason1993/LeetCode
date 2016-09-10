// Given two strings, find the longest common subsequence (LCS).

// Your code should return the length of LCS.

// Have you met this question in a real interview? Yes
// Clarification
// What's the definition of Longest Common Subsequence?

// https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
// http://baike.baidu.com/view/2020307.htm
// Example
// For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

// For "ABCD" and "EACB", the LCS is "AC", return 2.

// Tags 
// LintCode Copyright Longest Common Subsequence Dynamic Programming
// Related Problems 
// Medium Edit Distance 29 %
// Medium Longest Common Substring


public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        
        int n = A.length(), m = B.length();
        int[][] result = new int [n + 1][m + 1];
        
        for (int i = 0; i < n + 1; i++) {
            result[i][0] = 0;
        }
        
        for (int i = 0; i < m + 1; i++) {
            result[0][m] = 0;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        
        return result[n][m];
    }
}
