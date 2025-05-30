/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    int ans = Integer.MIN_VALUE;
    private void dfs(Node root, int k){
        if(root==null) return;
        if(root.data <= k ){
            ans = Math.max(ans , root.data);
        }
        if(root.data == k) return;
        if( k < root.data ){
            dfs(root.left, k);
        }
        else{
            dfs(root.right, k);
        }
    }
    public int findMaxFork(Node root, int k) {
        // code here.
        dfs(root, k);
        return ans==Integer.MIN_VALUE ? -1 : ans;
    }
}