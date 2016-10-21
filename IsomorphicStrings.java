// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

// For example,
// Given "egg", "add", return true.

// Given "foo", "bar", return false.

// Given "paper", "title", return true.

// Note:
// You may assume both s and t have the same length.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table
// Hide Similar Problems (E) Word Pattern

// when it said a char can be mapped to itself means that it allows a -> a but does not allow a -> a in additon to a -> b since the mapping has to be unique. That's why s.charAt(i) == t.charAt(i) part is commented out 
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> index1 = new HashMap<Character, Integer>();
        Map<Character, Integer> index2 = new HashMap<Character, Integer>();
        for (Integer i = 0; i < s.length(); i++) {
            // if (s.charAt(i) == t.charAt(i)) {
            //     index1.put(s.charAt(i), i);
            //     index2.put(s.charAt(i), i);
            //     continue;
            // }
            if (index1.put(s.charAt(i), i) != index2.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}