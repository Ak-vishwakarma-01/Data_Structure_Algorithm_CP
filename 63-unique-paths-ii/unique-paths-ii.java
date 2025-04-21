class Solution {
    int dp[][];
    private int dfs(int i, int j, int[][] obs, int r, int c){
        if(i<0 || i>=r || j<0 || j>=c || obs[i][j]!=0  ) return 0;
        if(i==r-1 && j==c-1 ) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int right = dfs(i, j+1, obs, r, c);
        int down = dfs(i+1, j, obs, r,c);
        return dp[i][j] = right + down;
    }
    public int uniquePathsWithObstacles(int[][] obs) {
        int r = obs.length;
        int c = obs[0].length;
        dp = new int[r+1][c+1];
        for(int i[]: dp) Arrays.fill(i,-1);
        return dfs(0, 0, obs, r, c);
    }
}