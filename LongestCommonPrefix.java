// Write a function to find the longest common prefix string amongst an array of strings.

// Subscribe to see which companies asked this question

// Hide Tags String

// T: O(L*n), where L is the length of shortest string and n == strs.length
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int end = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (i < s.length()) {
                  if (c != s.charAt(i)) {
                    end = i;
                    String result = strs[0].substring(0, i);
                    return result;
                    }  
                } else {
                    return s;
                }
                
            }
        }
        return strs[0];
    }
}