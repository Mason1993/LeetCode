// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return false.

// Hide Company Tags Facebook
// Hide Tags Sort
// Hide Similar Problems (H) Merge Intervals (M) Meeting Rooms II

// T: O(nlogn), S: O(1) extra space
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare (Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}