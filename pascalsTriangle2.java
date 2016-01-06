// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?

// solution 1, O(k) extra space used. only two lists are generated.
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>> ();  // List<List<Integer>> cannot be initialized
        List<Integer> firstRow = new ArrayList<Integer> ();
        firstRow.add(1);
        if (rowIndex == 0) {
            return firstRow;
        }
        // generate the second row, namely k = 1;
        firstRow.add(1);
        if (rowIndex == 1) {
            return firstRow;
        }
        List<Integer> preRow = firstRow;
        // generate i-th row
        for (int i = 2; i < rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<Integer> (i + 1);
            // have to initialize the ArrayList before set elements;
            for (int j = 0; j < i + 1; j++) {
                temp.add(-1);
            }
            temp.set(0, 1);
            temp.set(i, 1);
            // generate the 2nd element to (i-1)th element since the first and last elements are fixed to 1;
            for (int j = 1; j < i; j++) {
                temp.set(j, preRow.get(j - 1) + preRow.get(j));
            }
            if (i == rowIndex) {
                return temp;
            }
            preRow = temp;
        }
        return null;
    }
}


// solution 2, O(k^2) space is used. In total, (1+k)*k/2 = O(k^2) lists are generated.
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>> ();  // List<List<Integer>> cannot be initialized
        List<Integer> firstRow = new ArrayList<Integer> ();
        firstRow.add(1);
        if (rowIndex == 0) {
            return firstRow;
        }
        //pascalTriangle.add(firstRow);
        // generate i-th row
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<Integer> (i + 1);
            // have to initialize the ArrayList before set elements;
            for (int j = 0; j < i + 1; j++) {
                temp.add(-1);
            }
            temp.set(0, 1);
            temp.set(i, 1);
            // generate the 2nd element to (i-1)th element since the first and last elements are fixed to 1;
            List<Integer> preRow = pascalTriangle.get(i - 1);  // based on the previous row's elements to compute the current row's elements;
            for (int j = 1; j < i; j++) {
                temp.set(j, preRow.get(j - 1) + preRow.get(j));
            }
            if (i == rowIndex) {
                return temp;
            }
            pascalTriangle.add(temp);
        }
        return null;
    }
}