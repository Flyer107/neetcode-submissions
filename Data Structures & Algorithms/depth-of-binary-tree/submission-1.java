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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // if (root.left == null && root.right == null)  {
        //     return 0;
        // }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
    Time complexity: 
O
(
n
)
O(n)
Space complexity: 
O
(
h
)
O(h)

n is the number of nodes in the tree
h is the height of the tree
    */
}
