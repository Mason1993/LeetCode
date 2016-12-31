// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

// Hide Company Tags LinkedIn
// Hide Tags Array
// Hide Similar Problems (M) Shortest Word Distance II (M) Shortest Word Distance III

// T: O(n), S: O(1) extra space
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            
            if (words[i].equals(word2)) {
                p2 = i;
            }
            
            // it handles duplicated word1 and word2 situation very well;
            // For calculating distance betweeen word1 and word2, if word2 is after word1 and word1', word1 position can be replaced by word1' which is after word1 as the distances between word1' and word2 is definitely smaller
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
}