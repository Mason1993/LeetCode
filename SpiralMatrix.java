// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

// Subscribe to see which companies asked this question

// Hide Tags Array
// Hide Similar Problems (M) Spiral Matrix II

// Basic idea: keep going while i, j is within row range and column range
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rowBegin = 0, rowEnd = matrix.length - 1, columnBegin = 0, columnEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && columnBegin <= columnEnd) { // be attention it allows begin == end
            for (int j = columnBegin; j <= columnEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][columnEnd]);
            }
            columnEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = columnEnd; j >= columnBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][columnBegin]);
                }
                columnBegin++;
            }
        }
        return res;
    }
}