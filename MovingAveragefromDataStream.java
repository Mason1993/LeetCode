// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

// For example,
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3
// Hide Company Tags Google
// Hide Tags Design Queue

// Optimal solution, T: O(1), S: O(n) space
public class MovingAverage {
    Queue<Integer> queue;
    int size;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        } else {
            int deleted = queue.poll();
            queue.offer(val);
            sum += val - deleted;
            return sum / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

// original solution, T: O(n), where n is the size, S: O(n) space
public class MovingAverage {
    Queue<Integer> queue;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        queue.offer(val);
        if (queue.size() > size) {
            queue.poll();
        }
        double sum = 0;
        for (int i : queue) {
            sum += i;
        }
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */