public class Solution {
	public int replaceDigitWithAvg (int X) {
		if (X < 10 || X > 1000000000) {
			return -1;
		}

		int max = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder(String.valueOf(X));
		for (int i = 0; i < sb.length() - 1; i++) {
			char prev = sb.charAt(i);
			char curr = sb.charAt(i + 1);
			int avg = (int) Math.ceil((double)((prev - '0' + curr - '0') / 2 ));
			StringBuilder temp = new StringBuilder(sb);
			temp.deleteCharAt(i + 1);
			temp.setCharAt(i, (char)(avg + '0'));
			max = Math.max(max, Integer.valueOf(String.valueOf(temp)));
		}
		return max;
	}
}