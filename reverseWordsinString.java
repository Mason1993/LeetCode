// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // parsing the string according to " ".
        String[] attr = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = attr.length - 1; i >= 0; --i) {
            if (!attr[i].equals("")) {
                str.append(attr[i] + " ");
            }
        }
        String result = str.toString();
        int length = str.length();
        if (length == 0) {
            return "";
        }
        return result.substring(0, length - 1);   
    }
}