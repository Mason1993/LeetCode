// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the word list
// For example,

// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.


// be careful to the length, which is not the number of replacement
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int count = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(endWord)) {
                    return count;
                }
                for (int pos = 0; pos < temp.length(); pos++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                    	char[] arr = temp.toCharArray();
                        arr[pos] = c;
                        String str = new String (arr);
                        if (str.equals(endWord)) {
                            return count + 1;
                        }
                        if (!temp.equals(str) && wordList.contains(str)) {
                            queue.add(str);
                            wordList.remove(str);  // remember to reomove it from the set to avoid infinate loop
                        }
                    }
                } 
            }
            count++;
        }
        return 0;
    }
}