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

// VFS LPPP
// Visited, Frontier, Seed Loop(pop, process, push[neighbors])

//https://www.youtube.com/watch?v=hTM3phVI6YQ 

class Solution {
    // BFS Solution
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.add(root);
        }

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size(); // off bat we are searching level by level with the queue
            for (int i = 0; i < size; i++) {

                // This is rehydration after a level. IF there are children, then we add them to the queue but don't process until the NEXT level
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }
/*
Time: O(n) -> Each element in the tree processed/added to the root
Space: O(n) -> Queue
*/
}
