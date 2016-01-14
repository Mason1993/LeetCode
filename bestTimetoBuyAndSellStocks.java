// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Tags Array Dynamic Programming
// Similar Problems (M) Maximum Subarray (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock III (H) Best Time to Buy and Sell Stock IV (M) Best Time to Buy and Sell Stock with Cooldown

// solution 1, dynamic programming, O(n)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);   // since min is just the min value of traversed area which is [0, i], it can garantee that the bought data (which is index of min) is earlier than the sold data (which is current index, i)
            min = Math.min(min, prices[i]);  
        }
        return result;
    }
}

// solution 2, O(n^2), exceed time limit
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                int curr = prices[i] - prices[j];
                if (curr > result) {
                    result = curr;
                }
            }
        }
        return result;
    }
}