class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][2][3];
        for (int i[][] : dp) {
            for (int de[] : i)
                Arrays.fill(de, 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int purchased = 0; purchased <= 1; purchased++) {
                for (int transactions = 1; transactions <= 2; transactions++) {
                    if (purchased == 1) { // purchased
                        dp[i][purchased][transactions] = Math.max(prices[i] + dp[i+1][0][transactions-1] , dp[i+1][1][transactions]);
                    } else { // not purchased
                        dp[i][purchased][transactions] = Math.max( -prices[i] + dp[i+1][1][transactions], dp[i+1][0][transactions]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}