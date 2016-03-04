class BinarySearchTree {
	boolean canRepresentBST(int pre[], int n) {
		// Create an empty stack
		Stack<Integer> s = new Stack<Integer>();

		// Initialize current root as minimum possible
		// value
		int root = Integer.MIN_VALUE;
		// Traverse given array
		for (int i = 0; i < n; i++) {
			// If we find a node who is on right side
			// and smaller than root, return false
			if (pre[i] < root) {
				return false;
			}

			// If pre[i] is in right subtree of stack top,
			// Keep removing items smaller than pre[i]
			// and make the last removed item as new
			// root.
			while (!s.empty() && s.peek() < pre[i]) {
				root = s.peek();
				s.pop();
			}

			// At this point either stack is empty or
			// pre[i] is smaller than root, push pre[i]
			s.push(pre[i]);
		}
		return true;
	}
}

// Solution:
class BinarySearchTree {
	boolean canRepresentBST(int pre[], int n) {
		if (pre == null) {
			return true;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int root = Interger.MIN_VALUE;

		for (int i = 0; i < n; i++){
			if(pre[i] < root) {
				System.out.println("NO");
			}

			while (!stack.empty() && pre[i] > stack.peek()) {
				root = s.pop();
			}

			s.push(pre[i]);
		}
		System.out.println("YES");
	}
}
