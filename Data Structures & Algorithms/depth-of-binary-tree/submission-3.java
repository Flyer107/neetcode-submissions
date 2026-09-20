/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    // Iterative DFS: https://www.youtube.com/watch?v=hTM3phVI6YQ
    // "in-order" DFS would be the usual DFS
    // This is "pre-order" DFS which is easier to write for DFS. We will record the node and the depth
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;

        while(!stack.isEmpty()) {
            // Notice the difference of how we pop first and then process the children.
            Pair<TreeNode, Integer> curr = stack.pop();
            TreeNode node = curr.getKey();
            int depth = curr.getValue();

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return res;
    }

    /*
    Time: O(n)
    Space: O(n)
    */
}
