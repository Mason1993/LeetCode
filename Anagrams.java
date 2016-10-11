// Given an array of strings, return all groups of strings that are anagrams.

//  Notice

// All inputs will be in lower-case

// Have you met this question in a real interview? Yes
// Example
// Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

// Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

// Challenge 
// What is Anagram?
// - Two strings are anagram if they can be the same after change the order of characters.

// Tags 
// String Hash Table Facebook Uber
// Related Problems 
// Easy Two Strings Are Anagrams


// T: O(n), for not too long strings (there is sorting char array). The brute force way is O(n^2), iterate strs twice. The first for loop generate the str, the nested for loop compare the str with the rest of str in strs
// One idea is to use the different characters and their count as hashmap key but it's too complicated (see ninechapter solution. The alternative way is sorting char array then use them as hashmap key)
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return null;
        }
        
        List<String> result = new ArrayList<String>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>> ();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = new String (arr);
            if (map.containsKey(str)) {
                map.get(str).add(s);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(str, list);
            }
        }
        
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            if (list.size() > 1) {
                result.addAll(list);
            }
        }
        return result;
    }
}