// Write a program to check whether a given number is an ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

// Note that 1 is typically treated as an ugly number.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Math
// Hide Similar Problems (E) Happy Number (E) Count Primes (M) Ugly Number II

// idea: Any integer has and only has one prime factorization(wiki). Then we can start from 2, and divide prime numbers 2, 3, 5 until it isn't divisible by them anymore. Return num == 1.

// Best practice
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        
        return num == 1;
    }
}

// Initial Try
public class Solution {
    public boolean isUgly(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        
        for (int i = 2; i <= num; i++) {  // waste so much time using i++ since prime numbers are not continuous.
            if (i >= 7) {
                return false;
            }
            while (num % i == 0) {
                num = num / i;
                if (num == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}