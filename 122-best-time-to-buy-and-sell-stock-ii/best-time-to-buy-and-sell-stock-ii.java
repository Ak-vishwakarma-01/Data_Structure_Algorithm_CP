class Solution {
    int dp[][];
    int count(int ind, int prices[], int purchased, int n){
        if(ind>=n)return 0;
        if(dp[ind][purchased] != -1)return dp[ind][purchased];
        int localTransaction = Integer.MIN_VALUE;
        if(purchased==1){ // purchased
            int sell = prices[ind] + count(ind + 1, prices ,0, n);
            int notSell = count(ind +1, prices, 1, n);
            localTransaction = Math.max(sell, notSell);
        }else{ // not purchased
            int buy = -prices[ind] + count(ind +1,prices, 1,  n);
            int notBuy = count(ind +1, prices , 0, n);
            localTransaction = Math.max(localTransaction,Math.max(buy, notBuy));
        }
        return dp[ind][purchased] = localTransaction;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int []i:dp)Arrays.fill(i, -1);
        return count(0, prices,0, n);
    }
}