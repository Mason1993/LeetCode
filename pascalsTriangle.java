// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();  // List<List<Integer>> cannot be initialized
        if (numRows == 0) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<Integer> ();
        firstRow.add(1);
        result.add(firstRow);
        
        // generate i-th row
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer> (i + 1);
            // have to initialize the ArrayList before set elements;
            for (int j = 0; j < i + 1; j++) {
                temp.add(-1);
            }
            temp.set(0, 1);
            temp.set(i, 1);
            // generate the 2nd element to (i-1)th element since the first and last elements are fixed to 1;
            List<Integer> preRow = result.get(i - 1);  // based on the previous row's elements to compute the current row's elements;
            for (int j = 1; j < i; j++) {
                temp.set(j, preRow.get(j - 1) + preRow.get(j));
            }
            result.add(temp);
        }
        return result;
    }
}