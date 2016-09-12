// Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

//  Notice

// You can not divide any item into small pieces.

// Have you met this question in a real interview? Yes
// Example
// If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

// You function should return the max size we can fill in the given backpack.

// Challenge 
// O(n x m) time and O(m) memory.

// O(n x m) memory is also acceptable if you do not know how to optimize memory.

// Tags 
// LintCode Copyright Dynamic Programming Backpack
// Related Problems 
// Medium Backpack VI 32 %
// Medium Backpack II  37%

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (m != 0 && (A == null || A.length == 0)) {
            return 0;
        }
        
        int n = A.length;
        boolean[][] dpState = new boolean[n + 1][m + 1];
        dpState[0][0] = true;
        
        for (int i = 1; i < n + 1; i++) {
            dpState[i][0] = true;
        }
        
        // can be left out
        // for (int j = 1; j < m + 1; j++) {
        //     dpState[0][j] = false;
        // }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (j >= A[i - 1]) {
                    dpState[i][j] = dpState[i - 1][j] || dpState[i - 1][j - A[i - 1]];
                } else {
                    dpState[i][j] = dpState[i - 1][j];
                }
            }
        }
        
        for (int j = m; j > 0; j--) {
            if (dpState[n][j]) {
                return j;
            }
        }
        
        return 0;
        
    }
}