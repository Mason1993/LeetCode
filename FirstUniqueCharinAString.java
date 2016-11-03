// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.
// Note: You may assume the string contain only lowercase letters.

// Subscribe to see which companies asked this question

// Have you met this question in a real interview? Yes  FactSet

public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     System.out.println(entry.getKey());
        //     System.out.println(entry.getValue());
        // }
        
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}