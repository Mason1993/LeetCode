// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

// For example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// Note:
// You may assume that all words are consist of lowercase letters a-z.

// click to show hint.

// Subscribe to see which companies asked this question

// Hide Tags Backtracking Trie Design
// Hide Similar Problems (M) Implement Trie (Prefix Tree)

class TrieNode {
	Map<Character, TrieNode> children;
    boolean isEnd;
    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<Character, TrieNode>() ;
        isEnd = false;
    }
}

public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary () {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = curr.children.get(word.charAt(i));
            if (node == null) {
            	node = new TrieNode();  // handle the null pointer situation
                curr.children.put(word.charAt(i), node);
            }
            curr = node;
        }
        curr.isEnd = true;
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search (String word) {
        return searchHelper(word, root, 0);
    }
    
    public boolean searchHelper(String word, TrieNode node, int index) {
    	if(index == word.length()){
            if(node.children.size()==0) 
                return true; 
            else
                return false;
        }
        TrieNode curr = node;  // why time limit exceed if remove this line and change input name from node to curr
        Character ch = word.charAt(index);
        if (curr.children.containsKey(ch)) {
        	if (index == word.length() - 1 && curr.children.get(ch).isEnd) {
                return true;
            }
            curr = curr.children.get(ch);
            return searchHelper(word, curr, index + 1);
        } else if (ch == '.') {
        	boolean result = false;
            for (Character c : curr.children.keySet()) {
            	if (index == word.length() - 1 && curr.children.get(c).isEnd) {
                    return true;
                }
                if (searchHelper(word, curr.children.get(c), index + 1)) {
                    result = true;
                }
            }
            return result;
        } else {
            return false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");