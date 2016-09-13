// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".

// Subscribe to see which companies asked this question

// Hide Tags Two Pointers String
// Hide Similar Problems (E) Reverse Vowels of a String

// Optimal solution, iterate half of array. According to online solution, the time complexity is O(n/2), however, I think it should be O(3n/2) since there is 3 O(1) operation inside the loop if T can be calculated in this way. Otherwise T is still O(n) in my opinion since 1/2 is a constant
public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        char[] charArr = s.toCharArray();

        int halfLength = charArr.length / 2;
        for (int i = 0; i < halfLength; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - i - 1];
            charArr[charArr.length - i - 1] = temp;
        }
        
        return new String(charArr) ;
    }
}

// first try. exceeded time limit. T: O(n)
public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        char[] charArr = s.toCharArray();
        String result = "";
        
        for (int i = charArr.length - 1; i >= 0 ; i--) {
            result += charArr[i];
        }
        
        return result;
    }
}