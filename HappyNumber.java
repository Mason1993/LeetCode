// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
// Credits:
// Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table Math
// Hide Similar Problems (E) Add Digits (E) Ugly Number

// Standard solution
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        
        // during iterations, if the new number never occurs before, it will be added into set; If it does, check if it's 1. If it isn't 1, then this number will enter in a infinite loop (During the period that this number generated twice, 1 does not occur).
        // ref: http://www.cnblogs.com/grandyang/p/4447233.html
        while(!set.contains(n)) {
            set.add(n);
            n = getSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    
    public int getSum(int n) {
        int Sum = 0;
        char[] arr = Integer.toString(n).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            Sum += (arr[i] - '0') * (arr[i] - '0');
        }
        return Sum;
    }
}

// Initial Try, brute force. If it's still not happy number after 100 iterations, then it will be considered as not a happy number.
// Actually, when the threshold is 6, it can pass all 401 test cases. Faster than 86.99% algorithms.
public class Solution {
    public boolean isHappy(int n) {
        return isHappyHelper(n, 0);
    }
    
    public boolean isHappyHelper(int n, int count) {
        if (count > 100) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int nextNum = 0;
        char[] arr = Integer.toString(n).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            nextNum += (arr[i] - '0') * (arr[i] - '0');
        }
        return isHappyHelper(nextNum, ++count);
    }
}