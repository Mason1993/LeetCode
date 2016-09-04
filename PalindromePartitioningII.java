// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return the minimum cuts needed for a palindrome partitioning of s.

// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

// Hide Tags Dynamic Programming
// Hide Similar Problems (M) Palindrome Partitioning

// optimal solution, dynamic programming
// T: O(n^2)
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        boolean[][] palindromeArray = isPalindrome(s);
        int[] minCut = new int[s.length() + 1];
        minCut[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            int minCutNum = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (palindromeArray[j][i - 1]) {
                    minCutNum = Math.min(minCutNum, minCut[j] + 1);
                }
            }
            minCut[i] = minCutNum;
        }
        
        return minCut[s.length()] - 1;
    }
    

    // use dynamic programming to generate an array to save isPalindrome results of all possible substrings from the input string s.
    private boolean[][] isPalindrome(String s) {
        boolean[][] result = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            result[i][i] = true;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            result[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        
        // the dp function can be duducted easily. Based on the function we can deduce that we need to get result[i + 1][j - 1] first then result[i][j]
        // given that we initialized result[i][i] and result[i][j], we need to calculate the 2d array elements from upper left to bottom right so that we always use the previous values to calculate the current values.
        // in that order, the substring length, namely end minus start, keeps the same 
        // so in the outside for loop, we iterate all possible substring length
        // in the nested for loop, we iterate the start and the termination condition is the end index always smaller than the input string length
        for (int length = 2; length <= s.length(); length++) {
            for (start = 0; start + length < s.length(); start++) {
                result[start][start + length] = result[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
         
        return result;

    }
}


// first try, dynamic programming
// T: O(n^3), it can be improved since isPalindrome is called multiple times for same substring sometimes. We shold store the immediate isPalindrome results.
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] minCut = new int[s.length() + 1];
        minCut[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            int minCutNum = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                //System.out.println(s.substring(j, i));
                //System.out.println(isPalindrome(s.substring(j, i)));
                if (isPalindrome(s.substring(j, i))) {
                    minCutNum = Math.min(minCutNum, minCut[j] + 1);
                }
            }
            minCut[i] = minCutNum;
        }
        
        return minCut[s.length()] - 1;
    }
    
    public boolean isPalindrome(String s) {
        boolean result = false;
        int start, end;
        
        for (int i = 0; i < s.length() / 2; i++) {
            start = i;
            end = s.length() - 1 - i;
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}