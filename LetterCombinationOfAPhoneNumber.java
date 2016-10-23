// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.

// Subscribe to see which companies asked this question

// Hide Tags Backtracking String
// Hide Similar Problems (M) Generate Parentheses (M) Combination Sum (E) Binary Watch

// Backtracking solution
public class Solution {
    private Map<Integer, String> map;
    private String number;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        map = new HashMap<Integer, String>();
        number = digits;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        helper(res, new StringBuilder(), 0, number.length());
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, int pos, int digitsLeft) {
        if (digitsLeft == 0) {
            res.add(sb.toString());
            return;
        }
        
        int digit = number.charAt(number.length() - digitsLeft) - '0';
        if (map.containsKey(digit)) {
            String value = map.get(digit);
            while (pos < value.length()) {
                helper(res, sb.append(value.charAt(pos)), 0, digitsLeft - 1);
                pos++;
                sb.setLength(sb.length() - 1); // important! remember to revoke last operation before add another char from map.value
            }
        }
        
    }
}