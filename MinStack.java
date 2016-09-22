// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.
// Subscribe to see which companies asked this question

// Hide Tags Stack Design
// Hide Similar Problems (H) Sliding Window Maximum

// Attention: getMin() always return the current minimum value in the stack and the stack changes when pop method is called.
// Therefore: for        stack     minStack
//                      | 5  |    | -1 |         
//                      | 3  |    | -1 |   
//                      | -1 |    | -1 |   
//                      | 4  |    | 4  |   
//   getMin() = -1. Then pop(), getMin() = -1. pop(),getMin() = -1. pop(), getMin() = 4.
public class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
       this.stack = new Stack<Integer>();
       this.minStack = new Stack<Integer>(); 
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */