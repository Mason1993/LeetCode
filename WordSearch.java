// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
// Hide Company Tags Microsoft Bloomberg Facebook
// Hide Tags Array Backtracking
// Hide Similar Problems (H) Word Search II

// backtracking
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        
        StringBuilder sb = new StringBuilder();
        String res = "";
        //boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (helper(0, word, board, row, col)) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    
    // backtracking
    // return true if the characters after wordIndex(inclusive) mateched with the word after wordIndex
    // @wordIndex: the character index in word currently matching. All characters before wordIndex(exclusive) are mateched
    
    private boolean helper(int wordIndex, String word, char[][] board, int row, int col) {
        if (wordIndex == word.length() ) {
            // res = sb.toString();
            return true; 
        }
        
        //int len = sb.length();
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
            return false;
        }
        
        if (board[row][col] != word.charAt(wordIndex)) {
            return false;
        }
        
        board[row][col] = '.';  // mark this position as visited as '.' != any letter
        wordIndex++;
        
        boolean res = helper(wordIndex, word, board, row, col + 1) ||  // move right
                      helper(wordIndex, word, board, row, col - 1) ||  // move left
                      helper(wordIndex, word, board, row + 1, col) ||  // move up
                      helper(wordIndex, word, board, row - 1, col);    // move down
        board[row][col] = word.charAt(wordIndex - 1);
        wordIndex--;
        return res;
                      
        // // move right
        // if (col + 1 < board[row].length && !visited[row][col + 1] && board[row][col + 1] == word.charAt(len)) {
        //     sb.append(word.charAt(len));
        //     visited[row][col + 1] = true;
        //     helper(res, sb, word, board, row, col + 1, visited);
        //     visited[row][col + 1] = false;
        // // move left
        // } else if (col - 1 >= 0 && !visited[row][col - 1] && board[row][col - 1] == word.charAt(len)) {
        //     sb.append(word.charAt(len));
        //     visited[row][col - 1] = true;
        //     helper(res, sb, word, board, row, col - 1, visited);
        //     visited[row][col - 1] = false;
        // // move up
        // } else if (row + 1 < board.length && !visited[row + 1][col] && board[row + 1][col] == word.charAt(len)) {
        //     sb.append(word.charAt(len));
        //     visited[row + 1][col] = true;
        //     helper(res, sb, word, board, row + 1, col, visited);
        //     visited[row + 1][col] = false;
        // // move down
        // } else if (row - 1 >= 0 && !visited[row - 1][col] && board[row - 1][col] == word.charAt(len)) {
        //     sb.append(word.charAt(len));
        //     visited[row - 1][col] = true;
        //     helper(res, sb, word, board, row - 1, col, visited);
        //     visited[row - 1][col] = false;
        // }
        // if (sb.length() != len) {
        //     sb.deleteCharAt(sb.length()-1);    
        // }
    }
}