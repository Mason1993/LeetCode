// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Hide Company Tags Google
// Hide Tags Dynamic Programming Breadth-first Search Math
// Hide Similar Problems (E) Count Primes (M) Ugly Number II

// T: O(n), S: O(n) extra space
public class Solution {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 1; i * i < n + 1; i++) {
            // if (isPerfectSquareNum(i)) {
            //     res[i] = 1;
            // }
            res[i * i] = 1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; i + j * j < n + 1; j++) {
                res[i + j * j] = Math.min(res[i] + 1, res[i + j * j]);
            }
        }
        return res[n];
    }
    
    // private boolean isPerfectSquareNum (int n) {
    //     int temp = (int) Math.sqrt(n);
    //     return temp * temp == n;
    // }
}