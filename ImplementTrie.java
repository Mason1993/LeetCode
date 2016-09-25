// Implement a trie with insert, search, and startsWith methods.

// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

// Subscribe to see which companies asked this question

// Hide Tags Design Trie
// Hide Similar Problems (M) Add and Search Word - Data structure design

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    // Initialize your data structure here.
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = curr.children.get(word.charAt(i));
            if (node == null) {
                node = new TrieNode();
                curr.children.put(word.charAt(i), node);
            }
            curr = node;
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = curr.children.get(word.charAt(i));
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return curr.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode node = curr.children.get(prefix.charAt(i));
            if (node == null) {
                return false;
            }
            curr = node;
        }
        boolean result = (curr.children.size() == 0 ? false : true) || curr.isEnd;
        return result;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");