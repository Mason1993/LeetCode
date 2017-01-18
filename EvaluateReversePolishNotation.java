// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
// Hide Company Tags LinkedIn
// Hide Tags Stack
// Hide Similar Problems (H) Basic Calculator (H) Expression Add Operators

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Set<String> ops = new HashSet<String>();
        ops.add("+");
        ops.add("*");
        ops.add("/");
        ops.add("-");
        for (int i = 0; i < tokens.length; i++) {
            if (!ops.contains(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}