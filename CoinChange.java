// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// Example 1:
// coins = [1, 2, 5], amount = 11
// return 3 (11 = 5 + 5 + 1)

// Example 2:
// coins = [2], amount = 3
// return -1.

// Note:
// You may assume that you have an infinite number of each kind of coin.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        int[] result = new int[amount + 1]; // number of coins needed
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if (i >= coin && result[i - coin] != Integer.MAX_VALUE) {
                    result[i] = Math.min(result[i - coin] + 1, result[i]);
                }
            }
        }
        return result[amount] >= Integer.MAX_VALUE ? -1 : result[amount];
    }
}