// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Hide Tags Dynamic Programming


// since the function is now = last + lastlast, we don't need to record all answers of each stair. So we can use only 3 int than a int array.
public class Solution1 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        
        int now = 0, last = 2, lastlast = 1;
        for (int i = 3; i <= n; i ++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        
        return now;
    }
}

public class Solution2 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int [] result = new int [n];
        result[0] = 1;
        result[1] = 2;
        
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        
        return result[n - 1];
    }
}