// Given a string and an offset, rotate string by offset. (rotate from left to right)

// Example
// Given "abcdefg".

// offset=0 => "abcdefg"
// offset=1 => "gabcdef"
// offset=2 => "fgabcde"
// offset=3 => "efgabcd"
// Challenge 
// Rotate in-place with O(1) extra memory.

// Tags 
// String
// Related Problems 
// Medium Rotate List 25 %
// Medium Rotate Image 35 %
// Easy Recover Rotated Sorted Array


// similar to the recoverrotatedsortedlist, use 3 steps rotatation method 
// T: O(n), Space: O(1)
public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
     
    private void reverse (char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    } 
    
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
}