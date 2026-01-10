class Solution {
    int[][] dp;

    private int dfs(int i, int j, String s1, String s2) {
        if (i == s1.length() && j == s2.length()) return 0;

        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) sum += s2.charAt(k);
            return sum;
        }

        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) sum += s1.charAt(k);
            return sum;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = dfs(i + 1, j + 1, s1, s2);
        } else {
            int deleteS1 = s1.charAt(i) + dfs(i + 1, j, s1, s2);
            int deleteS2 = s2.charAt(j) + dfs(i, j + 1, s1, s2);
            dp[i][j] = Math.min(deleteS1, deleteS2);
        }

        return dp[i][j];
    }

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(0, 0, s1, s2);
    }
}