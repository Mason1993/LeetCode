public class PathLength {
	public int getPath (String s) {
		if (s == null || s.length() == 0 || !(s.contains(".jpeg") || s.contains(".png") || s.contains(".gif"))) {
			return 0;
		}

		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(0);
		int maxLength = 0;
		String[] parts = s.split("\n");
		for (String str : parts) {
			int level = str.lastIndexOf("\t") + 1;
			while (level + 1 < stack.size()) {
				stack.pop();
			}
			if (s.contains(".jpeg") || s.contains(".png") || s.contains(".gif")) {
				maxLength = Math.max(maxLength, stack.peek());
			} else {
				int length = stack.peek() + str.length() - level + 1;
				stack.push(length);
			}
		}
		return maxLength;
	}
}