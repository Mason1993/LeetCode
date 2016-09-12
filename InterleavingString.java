// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

// Hide Tags Dynamic Programming String

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }  
        
        int n = s1.length();
        int m = s2.length();
        boolean[][] dpState = new boolean[n + 1][m + 1];
        dpState[0][0] = true;  // if s1, s2, s3 are all empty string, it's true
        
        for (int i = 1; i < n + 1; i++) {
            // in first try I wrote: dpState[i][0] = s1.equals(s3) since I ignored that we should compare the substrings of s1 and s3 only
            dpState[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dpState[i - 1][0];  
        }
        for (int j = 1; j < m + 1; j++) {
            dpState[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dpState[0][j - 1];
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dpState[i][j] = (dpState[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dpState[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dpState[n][m];
        
    }
}