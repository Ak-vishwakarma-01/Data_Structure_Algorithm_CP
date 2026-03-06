class Solution {
    static int dp[][];

    static int solve(int n, int m, int sum){
        if(sum < 0 || n < 0) return 0;

        if(sum == 0 && n == 0){
            return 1;
        }

        if(dp[n][sum] != -1) return dp[n][sum];

        int curr_sum = 0;

        for(int i = 1; i <= m; i++){
            curr_sum += solve(n - 1, m, sum - i);
        }

        return dp[n][sum] = curr_sum;
    }

    static int noOfWays(int m, int n, int x) {
        dp = new int[51][51];

        for(int j = 0; j < 51; j++){
                Arrays.fill(dp[j], -1);
            }

        return solve(n, m, x);
    }
}