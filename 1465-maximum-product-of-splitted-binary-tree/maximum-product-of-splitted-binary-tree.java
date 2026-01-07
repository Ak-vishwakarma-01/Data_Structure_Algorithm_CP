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
    int mod = 1_000_000_007;
    long totalSum;
    long ans = Long.MIN_VALUE;
    private long total(TreeNode root){
        if(root==null) return 0;
        return  (root.val + total(root.left)+total(root.right));
    }
    private long dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        long l = dfs(root.left);
        long r = dfs(root.right);
        long rv = root.val;
        long sbt = l + r + rv;
        long mxp = (totalSum-sbt)*sbt;
        ans = Math.max( mxp, ans);
        return sbt;
    }
    public int maxProduct(TreeNode root) {
        totalSum = total(root);
        dfs(root);
        return (int)(ans%mod);
    }
}