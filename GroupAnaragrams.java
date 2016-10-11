// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table String
// Hide Similar Problems (E) Valid Anagram (E) Group Shifted Strings

// Be attention to the initialization of Object<Object>. Here we have to declare List<List<String>> in this way: List<List<String>> result = new ArrayList<List<String>>(); The outside list type should be arraylist which is not an abstract type. The nested list type does not have to be declared here otherwise may cause incompatible type (left and right types do not matach) problem.
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if (map.containsKey(str)) {
                map.get(str).add(s);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(str, list);
            }
        }
        
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        
        return result;
    }
}