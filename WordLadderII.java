// Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the word list
// For example,

// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]
// Return
//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]
// Note:
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// Subscribe to see which companies asked this question

// Hide Tags Array Backtracking Breadth-first Search String

// incomplete, too much details to consider and process
public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> currList = new ArrayList<String>();
        //currList.add(beginWord);
        helper(beginWord, endWord, wordList, currList, res);
        return res;
    }
     
    private void helper(String currWord, String endWord, Set<String> wordList, List<String> currList, List<List<String>> res) {
        if (currWord.equals(endWord)) {
            List<String> list = new ArrayList<String>(currList);
            res.add(list);
            return;
        }
        
        if (wordList.size() == 0) {
        	return;
        }
         
        Set<String> set = new HashSet<String> (wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.add(currWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            String str = queue.poll();
            for (int count = 0; count < size; count++) {
            	for (int i = 0; i < str.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] arr = str.toCharArray();
                        arr[i] = c;
                        String temp = new String (arr);
                        for (String s : set) {
                            if (s.equals(temp)) {
                                currList.add(temp);
                                set.remove(s);
                                helper(temp, endWord, set, currList, res);
                                currList.remove(currList.size() - 1);
                            }
                        }
                    }
                }
            }            
        }
    }
}
