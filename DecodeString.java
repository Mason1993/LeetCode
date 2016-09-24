// Given an encoded string, return it's decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

// Examples:

// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
// Subscribe to see which companies asked this question

// Hide Tags Depth-first Search Stack

// optimal solution
public class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<String>();
        Stack<Integer> intStack = new Stack<Integer>();
        int count = 0;
        String curr = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
            	count = 10 * count + s.charAt(i) - '0';  // handle the multiple digits number condition
            } else if (s.charAt(i) == '[') {  // another string starts, store the current count and string
            	intStack.push(count);
            	strStack.push(curr);
            	curr = "";
            	count = 0;
            } else if (s.charAt(i) == ']') {  // current string ends, generate the string with count, then assign it to curr. (consider 2[a2[b]c] case, curr need to appended behind a and be appended by c).
            	String temp = curr;
            	curr = strStack.pop();
            	for (int j = intStack.pop(); j > 0 ; j--) {
            		curr += temp;
            	}
            } else {
            	curr += Character.toString(s.charAt(i));
            }
        }
        return curr;
    }
}