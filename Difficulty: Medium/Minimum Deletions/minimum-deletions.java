class Solution {

    static int minDeletions(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString(); // reverse the string
        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // no match
                }
            }
        }

        return n - dp[n][n]; // min deletions = total length - longest palindromic subsequence
    }
}
