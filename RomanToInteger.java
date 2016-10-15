// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

// Subscribe to see which companies asked this question

// Hide Tags Math String
// Hide Similar Problems (M) Integer to Roman

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            switch (arr[i]) {
                case 'I' :
                    if (res >= 5) {
                        res--;
                    } else {
                        res++;
                    }
                    break;
                case 'V' :
                    res += 5;
                    break;
                case 'X' :
                    if (res >= 50) {
                        res -= 10;
                    } else {
                        res += 10;
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if (res >= 500) {
                        res -= 100;
                    } else {
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}