// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

// Hide Company Tags LinkedIn Google Facebook Twitter Microsoft Bloomberg Yelp
// Hide Tags Array Sort
// Hide Similar Problems (H) Insert Interval (E) Meeting Rooms (M) Meeting Rooms II

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// did it in short time by myself as it's kinda similar to LC452 Minimum Number of Arrows to Burst Balloons. Some bugs fixed by referring to the top solution in lc discussion forum
public class Solution {
    private class Comp implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start != i2.start) {
                return i1.start - i2.start;
            } else {
                return i1.end -i2.end;
            }
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        if (intervals.size() == 1) {
            return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comp());
        int start = intervals.get(0).start , end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (end >= intervals.get(i).start) {
                end = Math.max(intervals.get(i).end, end);  // note that add Math.max in case intervals.get(i).end < end
            } else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        res.add(new Interval(start, end)); // add the last interval  
        return res;
    }
}