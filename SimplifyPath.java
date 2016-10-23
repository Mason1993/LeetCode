// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.

// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".
// Subscribe to see which companies asked this question

// Hide Tags Stack String

// if use stack, remember to use Deque to implement. Otherwise, when it does not follow FILO when iterating stack.
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        
        StringBuilder res = new StringBuilder() ;
        LinkedList<String> stack = new LinkedList<String>();
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == 0 || arr[i].equals(".")) {
                continue;
            } else if (arr[i].equals("..")) {
                if (stack.size() != 0) {
                    stack.removeLast();
                }
            } else {
                stack.add(arr[i]);
            }
        }
        for (String s : stack) {
            res.append("/" + s);
        }
        return stack.isEmpty() ? "/" : res.toString();
    }
}