// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

// For example:

// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?

// Hint:

// A naive implementation of the above process is trivial. Could you come up with other methods?
// What are all the possible results?
// How do they occur, periodically or randomly?
// You may find this Wikipedia article useful.
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Math
// Show Similar Problems

// O(1), the results iterate again in every 9 numbers
// 1    1
// 2    2
// 3    3
// 4    4
// 5    5
// 6    6
// 7    7
// 8    8    
// 9    9    
// 10    1
// 11    2
// 12    3    
// 13    4
// 14    5
// 15    6
// 16    7
// 17    8
// 18    9
// 19    1
// 20    2
public class Solution {
    public int addDigits(int num) {
        if (num < 0) {
            return -1;
        }
        return (num - 1) % 9 + 1; // to handle when num == 9 || num % 9 == 0.
    }
}
// O(n), recursion
public class Solution {
    public int addDigits(int num) {
        if (num < 0) {
            return -1;
        }
        String str = Integer.toString(num);
        char[] c = str.toCharArray();
        num = 0;
        for (char i : c) {
            num += i - '0';
        }
        if (num < 10) {
            return num;
        } else {
            return addDigits(num);
        }
    }
}