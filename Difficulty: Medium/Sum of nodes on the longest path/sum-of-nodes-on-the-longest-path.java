/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    int maxh = 0;
    int ans;
    private void dfs(Node root, int sum , int h){
        if(root.left==null && root.right==null){
            sum += root.data;
            if(h>maxh) {
                ans = sum;
                maxh = h;
            }
            if(h==maxh) ans = Math.max(ans, sum);
            return;
        }
        if(root.left != null) dfs(root.left, sum + root.data, h+1);
        if(root.right != null) dfs(root.right, sum + root.data, h+1);
    }
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        dfs(root , 0 , 0);
        return ans;
    }
}