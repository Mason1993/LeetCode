// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

// Note:
// The vowels does not include the letter "y".

// Subscribe to see which companies asked this question

// Hide Tags Two Pointers String
// Hide Similar Problems (E) Reverse String

// do not forget to consider upper cases
public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // string can be used to replace hashset
        // String vowels = "aeiouAEIOU";
        // if (string.contains(arr[i]))
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] arr = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            for (; start < end; start++) { // make sure start < end all the time otherwise the word will be reversed back, for example hello => holle => hello
                if (set.contains(arr[start])) {
                    break;
                }
            }
            for (; end > start; end--) {
                if (set.contains(arr[end])) {
                    break;
                }
            }
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}