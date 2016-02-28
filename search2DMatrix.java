// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.
// Tags Array Binary Search
// Similar Problems (M) Search a 2D Matrix II

// my two second tries, binary search once and binary search twice
// binary search once
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (target == matrix[middle / column][middle % column]) {
                return true;
            } else if (target < matrix[middle / column][middle % column]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        if (target == matrix[start / column][start % column] || target == matrix[end / column][end % column]) {
            return true;
        }
        return false;
    }
}

// binary search twice
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row - 1;
        int middle;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (target == matrix[middle][0]) {
                return true;
            } else if (target < matrix[middle][0]) {
                end = middle;
            } else {
                start = middle;
            }
        }

        // < startRow [...]
        // startRow:     [...]
        // endRow:       [...]
        // > endRow   [...]
        if (target >= matrix[end][0]) {           // for endRow & (> endRow)
            row = end;
        } else if (target >= matrix[start][0]) {  // for startRow
            row = start;
        } else {                                  // for (< startRow)
            return false;
        }
        
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            middle = start + (end - start) / 2;
            if (target == matrix[row][middle]) {
                return true;
            } else if (target < matrix[row][middle]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        if (target == matrix[row][start] || target == matrix[row][end]) {
            return true;
        }
        return false;
    }
}

// my initial algorithm, too slow, beats 2%. O(log(m * n))
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        ArrayList<Integer> list = new ArrayList<Integer> ();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                list.add(matrix[i][j]);
            }
            
        }
        
        int start = 0;
        int end = list.size() - 1;
        int middle;
        while (end > start + 1) {
            middle = start + (end - start) / 2;
            if (list.get(middle) == target) {
                return true;
            } else if (list.get(middle) < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        if (target == list.get(start) || target == list.get(end)) {
            return true;
        }
        return false;
    }
}