// Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

// Subscribe to see which companies asked this question

// Hide Tags String
// Hide Similar Problems (H) Shortest Palindrome (E) Palindrome Permutation (H) Palindrome Pairs

// idea: find the center of substring first then start pointer goes left and end pointer goes right until the chars they point to do not match
// T: O(n ^ 2) find center n (abcba type) and n - 1 (abba type). helper function n/2 worst. so t = (2n - 1) * n/2 = O(n^2)
// brute force time complexity O(n^3). choose start of substring: n, choose end of substring: n, check if it's palindrome: n worst
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int maxLength = Integer.MIN_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            temp = helper(s, i, i);
            if (temp.length() > maxLength) {
                maxLength = temp.length();
                res = new String(temp);
            }
            temp = helper(s, i, i + 1);
            if (temp.length() > maxLength) {
                maxLength = temp.length();
                res = new String(temp);
            }
        }
        return res;
    }
    
    private String helper (String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}