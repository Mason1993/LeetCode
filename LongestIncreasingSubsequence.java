// Given an unsorted array of integers, find the length of longest increasing subsequence.

// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

// Your algorithm should run in O(n2) complexity.

// Follow up: Could you improve it to O(n log n) time complexity?

// Hide Tags Dynamic Programming Binary Search
// Hide Similar Problems (M) Increasing Triplet Subsequence (H) Russian Doll Envelopes


// optimal solution, binary search. Generate a LIS list and get the size
// T: O(nlogn). Considering the required time complexity, we naturally consider the binary search
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int num: nums) {
            if (list.size() == 0 || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int start = 0;
                int end = list.size() - 1;
                while (start + 1 < end) {
                    int mid = start + (end - start) / 2;
                    if (list.get(mid) < num) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
                if (list.get(start) > num) {
                    list.set(start, num);
                } else if (list.get(start) < num && list.get(end) > num) {
                    list.set(end, num);
                } // for other two senarios, list can just stay the same
            }
        }
        return list.size();
    }
}

// 1st try, dynamic programming
// T: O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] result = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1); // result[i] means starting from any index < i, the max number of increasing element with exact end at index == i.
                }
            }
            if (result[i] > max) {
                max = result[i];
            }
        }        
        return max;
    }
}