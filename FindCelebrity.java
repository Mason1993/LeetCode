// Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

// Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

// You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

// Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

// Hide Company Tags LinkedIn Facebook
// Hide Tags Array

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        // if fake celebrity (meet the following judgement) was behind true celebrity, then fake celebrity won't even become candidate
        // 1: 2,4
        // 2: null true celebrity
        // 3: 2,4
        // 4: 2

        // if fake celebrity was before true celebrity, then fake celebrity must know true celebrity then candidancy move to true celebrity from fake celebrity.
        // 1: 2,4
        // 2: 4   fake celebrity
        // 3: 2,4
        // 4: null

        // if there is no true celebrity and only fake celebrity, it would be removed by the verifying step
        // 1: 2,4
        // 2: 3,4
        // 3: 4
        // 4: 1 fake celebrity
        
        // find candidancy
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        
        // verify candidancy
        for (int i = 0; i < n; i++) {
            if ((!knows(i, candidate) || knows(candidate, i)) && candidate != i) {
                return -1;
            }
        }
        
        return candidate;
    }
}

// Graph version, using inDegree (number of people know you) and outDegree (number of people you know)
// Time Complexity: O(n^2), Space Complexity: O(n)
public int findCelebrity(int n) {
    int[] inDegree = new int[n];
    int[] outDegree = new int[n];
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i != j && knows(i,j)) {
                inDegree[j]++;
                outDegree[i]++;
            }
        }
    }
    
    for (int i = 0; i < n; i++) {
        if (inDegree[i] == n - 1 && outDegree[i] == 0) {
            return i;
        }
    }
    return -1;
}

// HashMap Version
// Time Complexity: O(n^2), Space Complexity: O(n^2)

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            map.put(i, set);
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    set.add(j);
                }
            }
        }
        
        int candidate = -1;
        for (int key : map.keySet()) {
            if (map.get(key).size() == 0) {
                candidate = key;
                for (int i : map.keySet()) {
                    if (i != candidate && !map.get(i).contains(candidate)) {
                        candidate = -1;
                        break;
                    }
                }
            }
        }
        
        return candidate;
    }
}