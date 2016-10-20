// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
// Each row must have the numbers 1-9 occuring just once. 
// Each column must have the numbers 1-9 occuring just once. 
// And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table
// Hide Similar Problems (H) Sudoku Solver

// tricky place: handle the grid situation. Use divde / and mod % to determine the row and column number
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        for (int i = 0; i < 9; i++) {
            Set<Character> setRow = new HashSet<Character>();
            char[] row = board[i];
            for (char c : row) {
                if (c != '.') {
                    if (setRow.contains(c)) {
                        return false;
                    } else {
                        setRow.add(c);
                    }
                }
            }
        }
        
        for (int j = 0; j < 9; j++) {
            Set<Character> setColumn = new HashSet<Character>();
            char[] column = new char[9];
            for (int i = 0; i < 9; i++) {
                column[i] = board[i][j];
            }
            for (char c : column) {
                if (c != '.') {
                    if (setColumn.contains(c)) {
                        return false;
                    } else {
                        setColumn.add(c);
                    }
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            Set<Character> setGrid = new HashSet<Character>();
            char[] grid = new char[9];
            for (int i = k/3*3; i < k/3*3+3; i++) {
               for (int j = (k%3)*3; j < (k%3)*3+3; j++) {
                   if (board[i][j] != '.') {
                       if (setGrid.contains(board[i][j])) {
                           return false;
                       } else {
                           setGrid.add(board[i][j]);
                       }
                   }
               }
           }
        }
        return true;
    }
}