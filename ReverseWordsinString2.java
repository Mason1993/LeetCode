// Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

// The input string does not contain leading or trailing spaces and the words are always separated by a single space.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Could you do it in-place without allocating extra space?

// Related problem: Rotate Array

// Hide Company Tags Amazon Microsoft Uber
// Hide Tags String
// Hide Similar Problems (M) Reverse Words in a String (E) Rotate Array


public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        
        // key idea: reverse the entire string first, then reverse the words seperately so the characters in words are in correct order.
        int start = 0, end = s.length - 1;
        reverseWordsHelper(s, start, end);

        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseWordsHelper(s, start, i - 1);
                start = i + 1;
            }
            // if pointer i point to the last char, then the it should be considered as a whole word as well thereby reverse it
            if (i == s.length - 1) {
            	reverseWordsHelper(s, start, i);
            }
        }
    }
    
    private void reverseWordsHelper(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}