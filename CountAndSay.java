// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

// Subscribe to see which companies asked this question

// Hide Tags String
// Hide Similar Problems (M) Encode and Decode Strings


public class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return null;
        }
        String actualNum = "1";
        if (n == 1) {
            return "1";
        }
        for (int i = 2; i <= n; i++) {
            String readNum = "";
            char[] charArr = actualNum.toCharArray();
            for (int j = 0; j < charArr.length ; j++) {
                int count = 1;
                while (j < charArr.length - 1 && charArr[j] == charArr[j + 1]) {
                    count++;
                    j++;
                }
                // For unique digit, it does not get into the while loop. Mark the count as one, then add it into readNum.
                readNum += count + "" + charArr[j] + "";
                actualNum = readNum;  // assigning readNum to actualNum in the end is better than placing it the begining of for (i) loop
                // previous implementation, does not work. Cannot handle the single (not continous digits, like 11) situation well.
                // if (charArr[j] == charArr[j + 1]) {
                //     count++;
                //     if (j == charArr.length - 1) {
                //         readNum += count + "" + charArr[j] + "";
                //     }
                //     continue;
                // }
                // readNum += count + "" + charArr[j] + "";
            }
        }
        return actualNum;
    }
}