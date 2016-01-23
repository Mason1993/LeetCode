// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

// Tags Array Dynamic Programming

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        if (triangle.get(0) == null || triangle.get(0).size() == 0) {
            return -1;
        }
        // Dynamic Programming, 4 element: state, initialization, function and answer
        // state to store the each element's result.
        int n = triangle.size();
        int[][] distance = new int[n][n]; // distance[row][column]
        
        // initialization
        distance[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            distance[i][0] = distance[i - 1][0] + triangle.get(i).get(0);
            distance[i][i] = distance[i - 1][i - 1] + triangle.get(i).get(i);
        }
        
        // function
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                distance[i][j] = Math.min(distance[i -1][j - 1], distance[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        
        // answer
        Arrays.sort(distance[n - 1]);
        int result = distance[n - 1][0];
        return result;
    }
}

// wrong solution, greedy algorithm is not applied here. consider the following structure:
// [
//      [2],
//     [3,4],
//    [9,9,10],
//   [100,100,100,1]
// ]
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        if (triangle.get(0) == null || triangle.get(0).size() == 0) {
            return -1;
        }
        
        int curr = triangle.get(0).get(0);
        int result = curr;
        int k = 0;
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 1; i < triangle.size(); i++) {
            row = triangle.get(i);
            // dynamic programming function
            if (row.get(k + 1) > row.get(k)) {
                result += row.get(k + 1);
                k++;
            } else {
                result += row.get(k);
            }
        }
        return result;
        
    }
}