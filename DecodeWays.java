// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming String

// refer to 九章 solution, my initial solution was too complicated and did not work.
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }
            
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[s.length()];
    }
}

// initial solution, 244 / 259 passed, one of failed case: 10
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (Integer.valueOf(s.substring(i - 2, i)) <= 26 && s.charAt(i - 2) != '0' && s.charAt(i - 1) != '0') {
                res[i] = res[i - 1] + res[i - 2];
            } else if (s.charAt(i - 2) == '0' && s.charAt(i - 1) == '0') {
                res[i] = 0;
            } else if (s.charAt(i - 2) == '0' || s.charAt(i - 1) == '0') {
                res[i] = 0;
            } else {
                res[i] = res[i - 1];
            }
        }
        return res[s.length()];
    }
}