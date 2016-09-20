// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

// Subscribe to see which companies asked this question

// Hide Tags Stack String
// Hide Similar Problems (M) Generate Parentheses (H) Longest Valid Parentheses (H) Remove Invalid Parentheses


// optimal solution, clearer logic
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("([{".contains(String.valueOf(c))) {
                st.push(c);
            } else if (!st.isEmpty() && isValidHelper(st.peek(), c)) {
                st.pop();
            } else { // isEmpty: unbalanced paretheses, right > left OR invalid
                return false;
            }
        }
        return st.isEmpty();
    }
    
    private boolean isValidHelper (char a, char b) {
        return (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}');
    }
}

// 1st try, use if else to distinguish different cases, not clean
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (st.size() != 0) {
                char out = (char)st.pop(); // need to cast it to char since by default stack doesn't take primitive type
                if (out == '(') {
                    if (c != ')') {
                        return false;
                    }
                } else if (out == '[') {
                    if (c != ']') {
                        return false;
                    }
                } else if (out == '{') {
                    if (c != '}') {
                        return false;
                    }
                }
            } else { // unbalanced paretheses, right > left
                return false;
            }
        }
        if (st.size() != 0) { // unbalanced paretheses, left > right
            return false;
        } else {
            return true;
        }
    }
}