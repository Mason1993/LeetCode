
// Implement a MinQueue Class that supports offer, remove and getMin in O(1), similar to leetcode minstack problem
// 4 -> 3 -> 2-> 5
// begin: 2, 2(after remove 5), 3(after remove 2), 4(after remove 3)
// 5;5   5,2; 2      5,2,3; 2,3     5,2,3,4; 2,3,4
class MinQueue {
        
        Queue<Integer> queue;
        Deque<Integer> deque;

        public MinQueue() {
                queue = new LinkedList<Integer>();
                deque = new ArrayDeque<Integer>();
        }
        public void offer(int x) {
                if (queue.size() == 0) {
                        queue.offer(x);                      
                        deque.offer(x);
                }
                else {
                        queue.offer(x);
                        // iterate the deque in reverse order. Using Queue can't implement this
                        for (Iterator<Integer> it = deque.descendingIterator(); it.hasNext();) {
                                if (it.next() > x) {
                                        it.remove();
                                }
                        }
                        deque.offer(x);
                }
        }

        public int remove() {
                if (queue.size() == 0) return -1;
                int val = 0;
                if (queue.peek() == deque.peek()) {
                        val = queue.remove();
                        deque.remove();
                }
                else {
                        val = queue.remove();
                }
                return val;
        }

        public int getMin() {
                return deque.getFirst();
        }
}