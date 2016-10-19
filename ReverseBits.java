// Reverse bits of a given 32 bits unsigned integer.

// For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

// Follow up:
// If this function is called many times, how would you optimize it?

// Related problem: Reverse Integer

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Bit Manipulation
// Hide Similar Problems (E) Number of 1 Bits

// Basic Solution
public class Solution {
    // you need treat n as an unsigned value
    //private final HashMap<Byte
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++, n >>= 1) {
            result = result << 1 | (n & 1);
        }
        return result;
    }
}

// follow up
public class Solution {
    // you need treat n as an unsigned value
    private final HashMap<Byte, Integer> cache = new HashMap<Byte, Integer>();
    public int reverseBits(int n) {
        int result = 0;
        byte[] arr = new byte[4];
        for (int i = 0; i < 4; i++, n >>= 8) {
            arr[i] = (byte)(n & 0xFF);
        }
        for (int i = 0; i < 4; i++) {
            result = (result <<= 8) + reverseByte(arr[i]);
        }
        return result;
    }
    
    private int reverseByte(byte b) {
        Integer value = cache.get(b);
        if (value != null) {
            return value;
        }
        value = 0;
        byte temp = b; 
        for (int i = 0; i < 8; i++, temp >>= 1) {
            value = (value <<= 1) | (temp & 1);
        }
        cache.put(b, value); // remember to use temp to shift bits since here b will be inserted into hashmap as key
        return value;
    }
}