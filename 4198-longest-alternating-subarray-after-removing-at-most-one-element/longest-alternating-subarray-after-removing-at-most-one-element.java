class Solution {

    public int longestAlternating(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                dp[n - 1][i][j] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int is_gre = 0; is_gre < 2; is_gre++) {
                for (int is_rem = 0; is_rem < 2; is_rem++) {

                    int ans = 1;

                    boolean check = false;
                    if (is_gre == 1 && nums[i + 1] > nums[i]) check = true;
                    if (is_gre == 0 && nums[i + 1] < nums[i]) check = true;

                    if (check) {
                        ans = Math.max(ans, 1 + dp[i + 1][is_gre ^ 1][is_rem]);
                    }

                    if (is_rem == 0) {
                        ans = Math.max(ans, dp[i + 1][is_gre][1]);
                    }

                    dp[i][is_gre][is_rem] = ans;
                }
            }
        }

        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i][0][0]);
            res = Math.max(res, dp[i][1][0]);
        }
        return res;
    }
}
