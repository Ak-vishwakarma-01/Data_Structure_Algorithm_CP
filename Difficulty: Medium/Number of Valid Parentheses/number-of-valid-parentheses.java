class Solution {
    int ans = 0;
    private void dfs(int n, int count){
        if(n<0 || count<0) return;
        if(n==0 && count==0) ans++;
        dfs(n-1,count+1);
        dfs(n-1,count-1);
        return;
    }
    int findWays(int n) {
        // code here
        dfs(n,0);
        return ans;
    }
}
