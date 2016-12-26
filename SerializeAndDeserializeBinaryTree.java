// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// For example, you may serialize the following tree

//     1
//    / \
//   2   3
//      / \
//     4   5
// as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

// Credits:
// Special thanks to @Louis1992 for adding this problem and creating all test cases.

// Hide Company Tags LinkedIn Google Uber Facebook Amazon Microsoft Yahoo Bloomberg
// Hide Tags Tree Design
// Hide Similar Problems (M) Encode and Decode Strings (M) Serialize and Deserialize BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private final String SPLITER = ",";
    private final String PLACEHOLDER = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // if (root == null) {
        //     return PLACEHOLDER;
        // }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    // preorder traversal
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(PLACEHOLDER).append(SPLITER);
            return;
        }
        sb.append(String.valueOf(root.val)).append(SPLITER);
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(SPLITER);
        Queue<String> queue = new LinkedList<String>(); // always use queue or stack when using bfs/dfs in iterating binary tree
        queue.addAll(Arrays.asList(strs));
        TreeNode root = desHelper(queue);
        return root;
    }
    
    private TreeNode desHelper(Queue<String> queue) {
        String str = "";
        if (!queue.isEmpty()) {
            str = queue.poll();
        } else {
            return null;  // it would never go into this condition (execute the exact same time of poll as the total number of nodes), actually no need to check if queue is empty.
        }
        if (str.equals(PLACEHOLDER)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = desHelper(queue);
        node.right = desHelper(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));