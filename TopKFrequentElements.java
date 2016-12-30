// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
// Hide Company Tags Pocket Gems Yelp
// Hide Tags Hash Table Heap
// Hide Similar Problems (M) Word Frequency (M) Kth Largest Element in an Array (M) Sort Characters By Frequency

// Bucket sort O(n)
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i : map.keySet()) {
            int freq = map.get(i);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (res.size() < k && buckets[i] != null ) {
                res.addAll(buckets[i]);
            }
        }
        return res;
    }
}

// Priorty Queue + HashMap, T: (n * logK) use priority queue with size k to reduce the insertion time
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        // Min Heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare (Map.Entry<Integer, Integer> pair1, Map.Entry<Integer, Integer> pair2) {
                return pair1.getValue() - pair2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            pq.add(pair);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}