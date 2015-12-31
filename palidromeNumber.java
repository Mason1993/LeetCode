// Determine whether an integer is a palindrome. Do this without extra space.
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverseNumber(x);
    }
    
    private int reverseNumber(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse;
    }
}