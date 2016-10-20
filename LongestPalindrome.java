// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

// This is case sensitive, for example "Aa" is not considered a palindrome here.

// Note:
// Assume the length of given string will not exceed 1,010.

// Example:

// Input:
// "abccccdd"

// Output:
// 7

// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
// Subscribe to see which companies asked this question

// Hide Tags Hash Table
// Hide Similar Problems (E) Palindrome Permutation

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            result += entry.getValue() % 2 == 0 ? entry.getValue() : entry.getValue() - 1;
        }
        return result < s.length() ? result + 1 : result;
    }
}