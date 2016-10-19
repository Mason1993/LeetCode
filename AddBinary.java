// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100".

// Subscribe to see which companies asked this question

// Hide Tags Math String
// Hide Similar Problems (M) Add Two Numbers (M) Multiply Strings (E) Plus One

// Correct solution, idea: use the basic idea of addition, p, q, and carry 
public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        int len = Math.max(aLen, bLen);
        int p = 0, q = 0, carry = 0;
        String result = "";
        for (int i = 0; i < len; i++) {
            if (i >= aLen) {
                p = 0;
            } else {
                p = a.charAt(aLen - i - 1) - '0';
            }
            if (i >= bLen) {
                q = 0;
            } else {
                q = b.charAt(bLen - i - 1) - '0';
            }
            int temp = p + q + carry;
            carry = temp / 2;
            temp %= 2;
            result = String.valueOf(temp) + result;
        }
        if (carry != 0) {
            result = "1" + result;
        }
        return result;
        
    }
}

// Wrong solution, idea: convert binary to decial, calculate the result, then convert the result to binary. However, the input could be out of Integer type range, even long type range
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return null;
        }
        
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        long aVal = 0, bVal = 0;
        
        for (int i = 0; i < aChar.length; i++) {
            aVal += (aChar[i] - '0') * Math.pow(2, aChar.length - i - 1);
        }
        for (int i = 0; i < bChar.length; i++) {
            bVal += (bChar[i] - '0') * Math.pow(2, bChar.length - i - 1);
        }
        //aVal = aVal < Integer.MAX_VALUE ? aVal : Integer.MAX_VALUE;
        //bVal = bVal < Integer.MAX_VALUE ? bVal : Integer.MAX_VALUE;
        long res = aVal + bVal;
        //System.out.println(aVal);
        //System.out.println(bVal);
        String result = res == 0 ? "0" : "";
        while (res != 0) {
            long reminder = res % 2;
            res /= 2;
            result = String.valueOf(reminder) + result;
        }
        return result;
        
    }
}