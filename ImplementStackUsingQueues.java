// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.
// Notes:
// You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
// Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
// You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
// Update (2015-06-11):
// The class name of the Java function had been updated to MyStack instead of Stack.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Stack Design
// Hide Similar Problems (E) Implement Queue using Stacks


class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public MyStack() {
        queue1 = new LinkedList<Integer> ();
        queue2 = new LinkedList<Integer> ();
    }
    
    // since queue1 and queue2 are defined in the class, they can be accessed directly. No need to define method like this 
    // swapQueue(Queue<Integer> queue1, Queue<Integer> queue2), waste of memory
    private void swapQueue () {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    private void moveQueue() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        moveQueue();
        queue1.poll();
        swapQueue();
    }

    // Get the top element.
    public int top() {
        moveQueue();
        int result = queue1.poll();
        swapQueue();
        queue1.offer(result);
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}