class Solution {
    int[][][] dp;

    private int dfs(int i, int j, int k, String s1, String s2, String s3, int il, int jl, int kl) {
        if (i >= il || j >= jl || k >= kl) return 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];

        int ans = 0;

        if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
            ans = 1 + dfs(i + 1, j + 1, k + 1, s1, s2, s3, il, jl, kl);
        } else {
            int op1 = dfs(i + 1, j, k, s1, s2, s3, il, jl, kl);
            int op2 = dfs(i, j + 1, k, s1, s2, s3, il, jl, kl);
            int op3 = dfs(i, j, k + 1, s1, s2, s3, il, jl, kl);
            ans = Math.max(op1, Math.max(op2, op3));
        }

        return dp[i][j][k] = ans;
    }

    int lcsOf3(String s1, String s2, String s3) {
        int il = s1.length();
        int jl = s2.length();
        int kl = s3.length();
        dp = new int[il][jl][kl];

        for (int i = 0; i < il; i++) {
            for (int j = 0; j < jl; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, 0, 0, s1, s2, s3, il, jl, kl);
    }
}
