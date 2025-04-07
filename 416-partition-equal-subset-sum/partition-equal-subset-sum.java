class Solution {
    int[][] dp;

    private boolean dfs(int i, int[] nums, int insum, int target, int n) {
        if (insum == target) return true;
        if (i >= n || insum > target) return false;

        if (dp[i][insum] != -1) return dp[i][insum] == 1;

        boolean take = dfs(i + 1, nums, insum + nums[i], target, n);
        boolean notTake = dfs(i + 1, nums, insum, target, n);

        dp[i][insum] = (take || notTake) ? 1 : 0;
        return dp[i][insum] == 1;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;
        dp = new int[n + 1][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, nums, 0, target, n);
    }
}
