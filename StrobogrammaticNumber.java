public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        if (num.length() == 1) {
            return (num).equals("0") || (num).equals("1") || (num).equals("8");
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for (int i = 0; i <= num.length() / 2; i++) {
            char start = num.charAt(i), end = num.charAt(num.length() - i - 1);
            if (map.containsKey(start) && map.containsKey(end)) {
                if (i == num.length() - i - 1) {
                    return map.containsKey(start);
                }
                if (map.get(start) != end) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}