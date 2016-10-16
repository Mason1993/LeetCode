// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?

// Subscribe to see which companies asked this question

// Hide Tags Hash Table Sort
// Hide Similar Problems (M) Group Anagrams (E) Palindrome Permutation

// O(n) solution
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }
        
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            arr[index]--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

// O(nlogn) solution
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return false;
        }
        
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        return Arrays.equals(sCharArr, tCharArr);
    }
}