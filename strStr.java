public class Solution {
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                // if we do if target.charAt(j) == source.charAt(i + j), it would be more complicated, see solution 2.
                if (target.charAt(j) != source.charAt(i + j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }  
        }
        return -1;
    }
}

// solution 2
public class Solution {
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }
        // need to consider target.length() == 0 && source.length() != 0 seperately, otherwise it will return -1 since program will not go into the second for loog
        if (target.length() == 0) {
            return 0;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (target.charAt(j) == source.charAt(i + j)) {
                    if ( j == target.length() - 1 ) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}