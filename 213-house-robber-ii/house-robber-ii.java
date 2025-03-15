class Solution {
    private int count(int ind, int[] nums, int n, int []dp){
        if(ind>=n) return 0;
        if(dp[ind] !=-1) return dp[ind];
        int take = nums[ind] + count(ind+2,nums, n, dp);
        int notTake = count(ind+1, nums, n, dp);
        return dp[ind] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int take0 = nums[0] + count(2,nums,n-1,dp1);
        int notTake = count(1, nums, n, dp2);
        return Math.max(take0, notTake);
    }
}