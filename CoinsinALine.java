class Solution {
public:
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    bool firstWillWin(vector<int> &values) {
        // write your code here
        int n = values.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, -1));
        int sum = 0;
        for (auto v : values) sum += v;
        return sum < 2 * dfs(dp, values, 0, n - 1);
    }
    int dfs(vector<vector<int>> &dp, vector<int> &values, int left, int right) {
        if (dp[left][right] != -1) return dp[left][right];
        if (left == right) {
            dp[left][right] = values[left];
        } else if (left > right) {
            dp[left][right] = 0;
        } else {
            int take_left = min(dfs(dp, values, left + 2, right), dfs(dp, values, left + 1, right - 1)) + values[left];
            int take_right = min(dfs(dp, values, left, right - 2), dfs(dp, values, left + 1, right - 1)) + values[right];
            dp[left][right] = max(take_left, take_right);
        }
        return dp[left][right];
    }
};