// Given a 2D board and a list of words from the dictionary, find all words in the board.

// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

// For example,
// Given words = ["oath","pea","eat","rain"] and board =

// [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// Return ["eat","oath"].
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

// click to show hint.

// You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

// If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.

// Hide Company Tags Microsoft Google Airbnb
// Hide Tags Backtracking Trie
// Hide Similar Problems (M) Word Search

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isEnd = false;
    }
}
	
class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
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
    
    public boolean search (String word) {
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
    
    public boolean startWith (String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = curr.children.get(word.charAt(i));
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return true;
    }
}

// Time Limit Exceed, and why in the marked (search mark) place, does not need to reset back after another recursion (add reset also correct, confusing). Actually even in recursion string was changed but when out of recursion, next recursion still takes the same string rather than modified string in the previous recursion

// need to optimize this solution
public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s: words) {
            trie.insert(s);
        }
        List<String> list = new ArrayList<String>();
        //StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                helper(set, trie, "", board, row, col);
            }
        }
        return new ArrayList<String> (set);
    }
    
    private void helper (Set<String> set, Trie trie, String str, char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
             
        str += board[row][col]; // <= mark
        if (!trie.startWith(str)) {
            //str.substring(0, str.length() - 1);
            return;
        }
        //System.out.println(startWith(root, "a"));

        // remember do not return when a word is found, it possible that this word is an another valid word's prefix
        if (trie.search(str)) {
            set.add(str);
            //sb.deleteCharAt(sb.length() - 1); // <= mark
            //return;
        }

        board[row][col] = '.'; // mark visited
        //sb.append(board[row][col])
        helper(set, trie, str, board, row, col + 1);
        helper(set, trie, str, board, row, col - 1);
        helper(set, trie, str, board, row + 1, col);
        helper(set, trie, str, board, row - 1, col);
        
        board[row][col] = str.charAt(str.length() - 1);
        //str.substring(0, str.length() - 1); // <= mark

    }

// my original solution
public class Solution {
	
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s: words) {
            trie.insert(s);
        }
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                helper(set, trie, sb, board, row, col);
            }
        }
        return new ArrayList<String> (set);
    }
    
    private void helper (Set<String> set, Trie trie, StringBuilder sb, char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
             
        sb.append(board[row][col]);
        //System.out.println(startWith(root, "a"));
        if (trie.search(sb.toString())) {
            set.add(sb.toString());
	        //sb.deleteCharAt(sb.length() - 1);
            //return;
        }
        
        if (!trie.startWith(sb.toString())) {
	        sb.deleteCharAt(sb.length() - 1);
            return;
        }
        
        
        
        board[row][col] = '.'; // mark visited
        //sb.append(board[row][col])
        helper(set, trie, sb, board, row, col + 1);
        helper(set, trie, sb, board, row, col - 1);
        helper(set, trie, sb, board, row + 1, col);
        helper(set, trie, sb, board, row - 1, col);
        
        board[row][col] = sb.charAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

    }
}