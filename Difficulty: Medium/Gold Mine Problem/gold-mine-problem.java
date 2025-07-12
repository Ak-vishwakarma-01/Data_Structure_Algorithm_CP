class Solution {
    int[][] dp;

    private int dfs(int row, int col, int[][] mat, int r, int c) {
        if (row < 0 || row >= r || col < 0 || col >= c) return 0;
        if (dp[row][col] != -1) return dp[row][col];

        int didown = dfs(row + 1, col + 1, mat, r, c);
        int right = dfs(row, col + 1, mat, r, c);
        int diup = dfs(row - 1, col + 1, mat, r, c);

        int localans = Math.max(Math.max(didown, right), diup);
        return dp[row][col] = mat[row][col] + localans;
    }

    public int maxGold(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        dp = new int[r][c];
        for (int[] de : dp) Arrays.fill(de, -1);

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            int localans = dfs(i, 0, mat, r, c);
            ans = Math.max(ans, localans);
        }
        return ans;
    }
}
