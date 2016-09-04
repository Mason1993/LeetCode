// Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

// optimal solution, with condition that the dictionary is not too large
// T: (n * L), where n is the length of string s and L is the maxSegLength.
// However, the slide indicates that the time complexity is O(n*L^2), which I don't understand
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        int maxSegLength = 0;
        int strLength = s.length();
        for (String sub: wordDict) {
            maxSegLength = Math.max(maxSegLength, sub.length());
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= i ; j++) {
                if (i - j <= maxSegLength) {
                    if (wordDict.contains(s.substring(j,i)) && result[j]) {
                        result[i] = true;
                        break;
                    }
                }
            }
        }
        return result[s.length()];
    }
}



// first try, dynamic programming
// T: O(n^2)
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        //System.out.println(s.substring(0, s.length()));
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j,i)) && result[j]) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}