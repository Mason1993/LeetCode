// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Subscribe to see which companies asked this question

// Tags Array Dynamic Programming
// Similar Problems (M) Unique Paths (H) Dungeon Game

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int M = grid.length;     // # of rows
        int N = grid[0].length;  // # of columns
        // System.out.println(M);
        // System.out.println(N);
        // Dynamic Programming
        // state
        int[][] distance = new int[M][N];
        
        // initialization
        distance[0][0] = grid[0][0];
        for (int i = 1; i < N; i++) {
            distance[0][i] = distance[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < M; j++) {
            //System.out.println(grid[j][0]);
            distance[j][0] = distance[j - 1][0] + grid[j][0];
        }
        
        //function
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                distance[i][j] = Math.min(distance[i - 1][j], distance[i][j - 1]) + grid[i][j];
            }
        }
        
        //answer
        return distance[M - 1][N - 1];
    }
}