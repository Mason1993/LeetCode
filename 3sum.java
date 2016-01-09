// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.
//     For example, given array S = {-1 0 1 2 -1 -4},

//     A solution set is:
//     (-1, 0, 1)
//     (-1, -1, 2)

// time complexity O(n^2)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // i, start and end have to be distinct numbers. So the boundary condition for i, start and end is as follows:
        // start, end: have to be larger than i, so start > i && end > start >i;
        // i: since both start and end are larger than i && all three index should be distinct. So i < nums.length - 2;
        // Question: in this case, do we miss the situation that nums[start] + nums[end] == nums[length - 2] || nums[length - 1]?
        // Answer: No. the above situations are belong to start || end == length -1 || length - 2. We have already traverse all possible situations based on the above assumptions. This is sum question, i, start, and end actually have the equal positions.
        for (int i = 0; i < nums.length -2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {  // aviod duplicates
                int sum = -nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    // case 1
                    if (nums[start] + nums[end] == sum) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    start++; 
                    end--;
                    //avoid duplicates. 
                    while (start < nums.length && nums[start] == nums[start - 1]) { 
                        start++;
                    }
                    while(end >= 0 && nums[end] == nums[end] + 1) {
                        end--;
                    }
                    // case 2
                    } else if (nums[start] + nums[end] < sum)  {
                        start++;
                    // case 3
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}