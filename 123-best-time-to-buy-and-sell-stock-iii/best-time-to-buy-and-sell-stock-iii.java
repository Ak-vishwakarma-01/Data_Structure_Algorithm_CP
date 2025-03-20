class Solution {
    int dp[][][];
    int count(int ind, int prices[], int purchased, int times, int n){
        if(times==0)return 0;
        if(ind>=n)return 0;
        if(dp[ind][purchased][times-1] != -1) return dp[ind][purchased][times-1];
        int localTransaction = Integer.MIN_VALUE;
        if(purchased==1){ // purchased
            int sell = prices[ind] + count(ind + 1, prices, 0,times-1, n);
            int notSell = count(ind +1, prices, 1,times, n);
            localTransaction = Math.max(sell, notSell);
        }else{ // not purchased
            int buy = - prices[ind] + count(ind +1,prices, 1,times, n);
            int notBuy = count(ind +1, prices , 0,times, n);
            localTransaction = Math.max(localTransaction,Math.max(buy, notBuy));
        }
        return dp[ind][purchased][times-1]=localTransaction;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][2];
        for(int i[][]: dp){
            for(int de[]:i) Arrays.fill(de,-1);
        }
        return count(0, prices, 0,2, n);
    }
}