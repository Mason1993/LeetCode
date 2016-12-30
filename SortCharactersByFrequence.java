// Given a string, sort it in decreasing order based on the frequency of characters.

// Example 1:

// Input:
// "tree"

// Output:
// "eert"

// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input:
// "cccaaa"

// Output:
// "cccaaa"

// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input:
// "Aabb"

// Output:
// "bbAa"

// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
// Hide Company Tags Amazon Google
// Hide Tags Hash Table Heap
// Hide Similar Problems (M) Top K Frequent Elements


// T: O(nlogn), be aware of that using bucket sort is O(n), very similar to lc 347 top k frequent element
public class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        // Max Heap
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>(map.size(), new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare (Map.Entry<Character, Integer> pair1, Map.Entry<Character, Integer> pair2) {
                return pair2.getValue() - pair1.getValue();  //descending order
            }
        });

        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            pq.add(pair);
        }
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> pair = pq.poll();
            Character c = pair.getKey();
            int freq = pair.getValue();
            for (int j = 0; j < freq; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}