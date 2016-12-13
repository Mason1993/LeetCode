// Given four one digit number (0 ~ 9), get the latest time using them


// first solution: backtracking, similar to the leetcode permutation solution
// second solution, brute force. Since the input size is constant. Both of them have O(1) time complexity
public class Solution {
	
	public static String getTime (int a, int b, int c, int d) {
		String res = "";
		int[] nums = new int[] {a, b, c, d};
		int max = -1;
		boolean[] isUsed = new boolean[4];
		List<String> list = new ArrayList<String>();
		getPermute(nums, isUsed, 0, new StringBuilder(), list);
		for (String time : list) {
			if (isValid(time) && Integer.valueOf(time) > max) {
				max = Integer.valueOf(time);
				res = time;
			}
		}
		return res == "" ? "NOT POSSIBLE" : res.substring(0, 2) + ":" + res.substring(2);
	}
	
	private static void getPermute(int[] nums, boolean[] isUsed, int startIndex, StringBuilder time, List<String> res) {
		if (time.length() == 4) {
			res.add(time.toString());
			return;
		}
		for (int i = startIndex; i < 4; i++) {
			for (int j = 0; j < isUsed.length; j++) {
				if(!isUsed[j]) {
					isUsed[j] = true;
					time.append(String.valueOf(nums[j]));
					getPermute(nums, isUsed, i + 1, time, res);
					isUsed[j] = false;
					time.deleteCharAt(time.length() - 1);
				}
			}
		}		
	}

	public static String bruteForce (int a, int b, int c, int d) {
		String res = "";
		int[] nums = new int[] {a, b, c, d};
		int max = -1;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(nums[i]));
			for (int j = 0; j < 4; j++) {
				if (j == i) {
					continue;
				}
				sb.append(String.valueOf(nums[j]));
				for (int k = 0; k < 4; k++) {
					if (k == j || k == i ) {
						continue;
					} else {
						sb.append(String.valueOf(nums[k]));
					}
					for (int l = 0; l < 0; l++) {
						if (l == i || l == j || l == k) {
							continue;
						} else {
							sb.append(String.valueOf(nums[l]));
							list.add(sb.toString());
						}
					}
				}
			}
		}
		
		for (String time : list) {
			if (isValid(time) && Integer.valueOf(time) > max) {
				max = Integer.valueOf(time);
				res = time;
			}
		}
		return res == "" ? "NOT POSSIBLE" : res.substring(0, 2) + ":" + res.substring(2);
	}
	
	private static boolean isValid (String time) {
		if (Integer.valueOf(time.substring(0, 2)) >= 24 || Integer.valueOf(time.substring(2, 4)) >= 60) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTime(0,0,0,0));  //00:00
		System.out.println(getTime(2,3,5,9));  //23:59
		System.out.println(getTime(2,3,6,0));  //23:06
		System.out.println(getTime(2,4,0,0));  //20:40
		System.out.println(getTime(0,0,8,1));  //18:00
		System.out.println(getTime(2,8,1,3));  //23:18
		System.out.println(getTime(9,1,2,9));  //19:29
		System.out.println(getTime(9,1,8,9));  //NOT POSSIBLE
	}

}