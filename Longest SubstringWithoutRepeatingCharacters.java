// Given a string, find the length of the longest substring without repeating characters.

// Examples:

// Given "abcabcbb", the answer is "abc", which the length is 3.

// Given "bbbbb", the answer is "b", with the length of 1.

// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table Two Pointers String
// Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters

// T: O(n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            //int currLength = 1;
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            int currLength = j - i + 1;
            maxLength = Math.max(currLength, maxLength);
            map.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }
}

// two pointers, T: O(n^2)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = Integer.MIN_VALUE;
        for (int start = 0; start < s.length(); start++) {
            HashSet<Character> set = new HashSet<Character>();
            set.add(s.charAt(start));
            int currLength = 1;
            if (start == s.length() - 1) {
                maxLength = Math.max(1, maxLength);
                break;
            }
            for (int end = start + 1; end < s.length(); end++) {
                if (set.contains(s.charAt(end))) {
                    maxLength = Math.max(currLength, maxLength);
                    break;
                } else {
                    set.add(s.charAt(end));
                    currLength++;
                    if (end == s.length() - 1) {
                        maxLength = Math.max(currLength, maxLength);
                        break;
                    }
                }
            }
        }
        return maxLength;
    }
}