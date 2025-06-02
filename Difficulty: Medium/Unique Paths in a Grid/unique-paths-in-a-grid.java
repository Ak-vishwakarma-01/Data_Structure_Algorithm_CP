class Solution {
    int dp[][];
    int dfs(int r, int c, int grid[][], int row, int col){
        if(r>=row || c>= col || grid[r][c]==1 ) return 0;
        if(r==row-1 && c==col-1) return 1;
        if(dp[r][c]!= -1) return dp[r][c];
        int right = dfs(r+1, c , grid , row, col);
        int left = dfs(r , c+1, grid, row ,col);
        return dp[r][c] = left + right;
    }
    public int uniquePaths(int[][] grid) {
        // code here
        int r = grid.length;
        int c = grid[0].length;
        dp = new int[r+1][c+1];
        for(int i=0;i<r;i++) Arrays.fill(dp[i], -1);
        return dfs(0 , 0 ,grid, r , c);
        
    }
};