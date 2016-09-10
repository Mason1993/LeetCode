// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// a) Insert a character
// b) Delete a character
// c) Replace a character

// Hide Tags Dynamic Programming String
// Hide Similar Problems (M) One Edit Distance


// Optimal Solution, Dynamic Programming
// T: O(n^2)
// this function is convert word1 to word2
public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dpState = new int[n + 1][m + 1];
        dpState[0][0] = 0;
        
        for (int i = 1; i < n + 1; i++) {
            dpState[i][0] = i;
        }
        for (int j = 1; j < m + 1; j++) {
            dpState[0][j] = j;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // if x in word1 and y in word2 matches
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dpState[i][j] = dpState[i - 1][j - 1];
                } else {
                    int replace = dpState[i - 1][j - 1] + 1;  // replace x with y
                    int delete = dpState[i - 1][j] + 1;   // delete x from word1 so that this problem is now converted to convert word1(0, i-1) to word(0,j)
                    int insert = dpState[i][j - 1] + 1; // insert y to word2 so that this problem is now converted to convert word1(0,i) to word(-, j-1) and since word1[i] == word2[j], namely y, so insert == dpState[i+1][j]
                    int result = Math.min(replace, delete);
                    result = Math.min(result, insert);
                    dpState[i][j] = result;
                }
            }
        }
        
        return dpState[n][m];
    }
}