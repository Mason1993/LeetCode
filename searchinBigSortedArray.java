// Given a big sorted array with positive integers sorted by ascending order. 
// The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

// Return -1, if the number doesn't exist in the array.

// Notice

// If you accessed an inaccessible index (outside of the array), ArrayReader.get will return -1.

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if (target == reader.get(0)) {
            return 0;
        }
        
        int tail = 1;
        while (target > reader.get(tail) && reader.get(tail) != -1) {
            tail = tail * 2;
        }
        int start = 1;
        int end = tail;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target == reader.get(mid) && reader.get(mid) != -1) {
                end = mid;
            } else if (target > reader.get(mid) && reader.get(mid) != -1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target == reader.get(start)) {
            return start;
        } else if (target == reader.get(end)) {
            return end;
        } else {
            return -1;
        }
    }
}