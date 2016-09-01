// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

// Note: m and n will be at most 100.

// Hide Tags Array Dynamic Programming
// Hide Similar Problems (M) Unique Paths

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        
        int rowNum = obstacleGrid.length;
        int columnNum = obstacleGrid[0].length;
        int [][] result = new int [rowNum][columnNum];
        System.out.println(rowNum);
        System.out.println(columnNum);
        
        for (int i = 0; i < rowNum; i++) {
            if (obstacleGrid[i][0] == 1) {
                // dont need the following step since when initialize the array, all elements values are 0;
                // for (; i < rowNum; i++) {
                //     obstacleGrid[i][0] = 0;
                // }
                break;
            } else {
                result[i][0] = 1;
            }
        }
        for (int j = 0; j < columnNum; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                result[0][j] = 1;
            }
        }
        
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < columnNum; j++) {
                if (obstacleGrid[i][j] == 0) {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        
        return result[rowNum - 1][columnNum - 1];
    }
}