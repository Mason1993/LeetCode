// Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

// For example,
// 123 -> "One Hundred Twenty Three"
// 12345 -> "Twelve Thousand Three Hundred Forty Five"
// 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// Hint:

// Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
// Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
// There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
// Subscribe to see which companies asked this question

// Hide Tags Math String
// Company Tags: Microsoft
// Hide Similar Problems (M) Integer to Roman

public class Solution {
    private final String[] LESS_THAN_20 = new String[] {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private final String[] TENS = new String[] {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety ", "Hundred "};
    private final String[] THOUSANDS = new String[] {"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (num != 0) {
            int remainder = num % 1000;
            stack.push(remainder);
            num /= 1000;
        }
        while (!stack.isEmpty()) {
            String number = coverter(stack.poll());
            sb.append(number);
            if (!number.equals("")) {
                sb.append(THOUSANDS[stack.size()]);
            }
        }
        return sb.toString().trim();
    }
    
    private String coverter (int n) {
        //String number = String.valueOf(n);
        StringBuilder res = new StringBuilder ();
        if (n / 100 != 0) { // >100
            res = res.append(LESS_THAN_20[(n / 100)] + "Hundred ");
        } 
        if ((n % 100) / 10 >= 2) { // 20 ~ 90
            res = res.append(TENS[(n % 100) / 10]);
            res = res.append(LESS_THAN_20[(n % 100) % 10]);
        } else { 
            res = res.append(LESS_THAN_20[(n % 100)]);
        }
        return res.toString();
    }
}