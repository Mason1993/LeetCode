// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Example 2:

// 11000
// 11000
// 00100
// 00011
// Answer: 3

// Test case format: ["11110","11010","11000","00000"]
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Depth-first Search Breadth-first Search Union Find
// Hide Similar Problems (M) Surrounded Regions (M) Walls and Gates (H) Number of Islands II (M) Number of Connected Components in an Undirected Graph

// Idea: when '1' occurs, count++ then mark all '1' directly connected (including itself) as water, then recursively apply this method to calculate the updated 2D array
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    markAsWater(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    // mark all cells that are directly connected to grid[x][y]
    public void markAsWater (char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if (x >= 0 && y + 1 >= 0 && x < grid.length && y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            markAsWater(grid, x, y + 1);
        }
        if (x >= 0 && y - 1 >= 0 && x < grid.length && y - 1 < grid[0].length && grid[x][y - 1] == '1') {
            markAsWater(grid, x, y - 1);
        }
        if (x + 1 >= 0 && y >= 0 && x + 1 < grid.length && y < grid[0].length && grid[x + 1][y] == '1') {
            markAsWater(grid, x + 1, y);
        }
        if (x - 1 >= 0 && y >= 0 && x - 1 < grid.length && y < grid[0].length && grid[x - 1][y] == '1') {
            markAsWater(grid, x - 1, y);
        }
    }
}