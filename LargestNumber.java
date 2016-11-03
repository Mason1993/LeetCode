Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

Hide Tags Sort

// learn how to use Comparactor Interface
class NumbersComparator implements Comparator<String> {
    @Override
    public int compare (String str1, String str2) {
        return (str2 + str1).compareTo(str1 + str2); // the usual comparator with Arrays.sort, it will place str1 behind str2 if the comparing result is positive number (in ascending order). However, in our case, we want put str1 before str2 if comparing result is positive. That's way we return (str2 + str1).compareTo(str1 + str2)
    }
}

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strs[i]);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res; // could return "0" after sorting by using if (strs[0].equals("0")) return "0" to save time.
    }
}
