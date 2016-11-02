// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// click to show follow up.

// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

// Subscribe to see which companies asked this question

// Hide Tags Array
// Hide Similar Problems (M) Game of Life

// better solution, use first row and column as mark arrays, time complexity: O(m * n)
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean firstRowZeros = false;
        boolean firstColumnZeros = false;
        int m = matrix.length, n = matrix[0].length;
        
        // check if there is zero in first row and column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZeros = true;
                break;
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZeros = true;
                break;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
        			matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // set first row and column to zeros if necessary
        if (firstColumnZeros) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (firstRowZeros) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}

// initial solution, time complexity: O(2 * m * n * (m + n)), can be considered as O(n ^ 3)
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    mark(i, j, matrix);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] == 21745 ? 0 : matrix[i][j];
            }
        }
    }
    
    private void mark(int row, int column, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = matrix[i][column] == 0 ? 0 : 21745;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = matrix[row][i] == 0 ? 0 : 21745;
        }
    }
}