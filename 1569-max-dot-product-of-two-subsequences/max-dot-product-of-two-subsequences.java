class Solution {
    int ans = Integer.MIN_VALUE;
    int dp[][];
    private int dfs(int i, int j, int []nums1, int []nums2, int n,int m){
        if(i>=n || j>=m) return Integer.MIN_VALUE;
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int de = nums1[i]*nums2[j] ;
        int first = dfs(i+1,j+1,nums1, nums2, n, m);
        if(first > 0) de += first;
        int second = dfs(i+1,j,nums1,nums2,n,m);
        int third = dfs(i,j+1,nums1,nums2,n,m);
        de = Math.max(de,Math.max(second,third));
        dp[i][j] = de;
        return de;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return dfs(0,0,nums1,nums2,n,m);
    }
}