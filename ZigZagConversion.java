// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
// Subscribe to see which companies asked this question

// Hide Tags String

/*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
*/

// the following is a creative and easy way, not the regular way, which should be mastered as well.
public class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {// vertically down
                sb[idx].append(c[i++]);
            }
            for (int idx = numRows-2; idx >= 1 && i < len; idx--){ // obliquely up
                sb[idx].append(c[i++]);
            }
        }
        
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}