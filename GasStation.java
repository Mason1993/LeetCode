// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

// Note:
// The solution is guaranteed to be unique.

// Hide Tags Greedy

// Greedy solution, T: O(n), S: O(1) extra space
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }
        // refer to this idea: 
        // If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
        // If the total number of gas is bigger than the total number of cost. There must be a solution.
        int len = gas.length;
        int sum = 0, total = 0, index = 0;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i]; // if total < 0, then there is no fessible solution
            if (sum < 0) { // if sum < 0, it indicates that any car left before gas[i] cannot make to gas[i], including those stations that have reset sum to 0.
                index = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : index;
    }
}

// Original Solution, Brute Force. T; O(n ^ 2), S: O(n) extra space
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }
        
        int len = gas.length;
        int[] remain = new int[len + 1]; // the remaining gas remain[i]: when it just get the gas station i;
        for (int start = 0; start < len; start++) {
            boolean isSuccess = true;
            remain[start] = 0;
            for (int i = 0; i < len; i++) {
                int currPos = start + i >= len ? start + i - len : start + i;
                int nextPos = currPos + 1 >= len ? currPos + 1 - len : currPos + 1;
                
                remain[nextPos] = remain[currPos] + gas[currPos] - cost[currPos];
                if (remain[nextPos] < 0) {
                    isSuccess = false;
                    break;
                }
            }
            if (isSuccess) {
                return start;
            }
        }
        return -1;
    }
}