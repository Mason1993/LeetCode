// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
// A solution is:

// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]
// Hide Company Tags Google Uber
// Hide Tags Hash Table String
// Hide Similar Problems (M) Group Anagrams

// T: O(n * k), where k is the average length of string in strings, S: O(n)
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            // it handles one char case as key == ""
            for (int i = 1; i < chars.length; i++) {
                sb.append(chars[i] - chars[i - 1] >= 0 ? chars[i] - chars[i - 1] : chars[i] - chars[i - 1] + 26); // to handle situation that "az" and "ba". Convert all offsets to positive
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(new String (chars));
            } else {
                List<String> value = new ArrayList<String>();
                value.add(new String (chars));
                map.put(key, value);
            }
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}