// given a string with number and letter, return number only 
// "abc123bca" => 123
import java.util.*;

public class RemoveLetter {
	public int removeLetterFromString(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		String res = "";
		char[] arr = str.toCharArray();
		//boolean isSigned = false;
		for (int i = 0; i < arr.length; i++) {
			// if (!isSigned && (arr[i] == '+' || arr[i] == '-')) {
			// 	result += arr[i];
			// 	isSigned = true;
			// } else 
			if (arr[i] >= '0' && arr[i] <= '9') {
				res += arr[i];
			}
		}
		return Integer.valueOf(res);
	}
}