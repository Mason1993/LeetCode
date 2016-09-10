// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Here is an example:
// S = "rabbbit", T = "rabbit"

// Return 3.

// Hide Tags Dynamic Programming String


public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        
        int n = s.length(), m = t.length();
        int[][] dpState = new int [n + 1][m + 1];
        
        for (int i = 0; i < n + 1; i++) {
            dpState[i][0] = 1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dpState[i][j] = dpState[i - 1][j];
                } else {
                    dpState[i][j] = dpState[i - 1][j - 1] + dpState[i - 1][j];
                }
            }
        }
        
        return dpState[n][m];
    }
}