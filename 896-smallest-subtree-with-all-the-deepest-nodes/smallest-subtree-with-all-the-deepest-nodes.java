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
    int maxDepth = 0;
    TreeNode result = null;
    private int dfs(TreeNode root, int depth){
        if(root==null) return depth;

        int left = dfs(root.left , depth+1);
        int right = dfs(root.right, depth+1 );
        if(left==right){
            maxDepth = Math.max(maxDepth , left);
            if(maxDepth==left) result  = root;
        }
        return Math.max(left ,right);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root , 0);
        return result;
    }
}