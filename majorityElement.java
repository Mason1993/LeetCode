// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.

//Solution 1, Linear Time Majority Vote Algorithm, O(n)
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int candidate = 0;
        int count = 0;
        // Linear Time Majority Vote Algorithm, O(n)
        // since given that majority element always exists and at most only one can exist (since it requires more than a half.). we can subtract one for count if next element is not same as candidate and keep doing until traverse the whole array. Finally, we return cadidate since it indicates that count is positive (If count is still positive, then candidate won't be replaced). We can prove in this way. If candidate is majority, the number of remaining elements must be less than the number of candidate, so the count of candidate will be positive in the last.
        for (int i = 0; i < length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--; 
            }
        }
        return candidate;
    }
}


//Solution 2, basic solution, O(nlogn) time complexity
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        Arrays.sort(nums);
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (candidate == nums[i]) {
                count++;
                if (count > length/2) {
                    return candidate;
                }
            } else {
                candidate = nums[i];
                count = 1;
            }
        }
        return 0;
    }
}

// Solution 3, simplified solution 2, O(nlogn) time complexity
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length/2];  // since the number of majority element has to be more than n/2 and majority element exists, the middle of the sorted array nums is guaranteed to be the majority.
    }
}