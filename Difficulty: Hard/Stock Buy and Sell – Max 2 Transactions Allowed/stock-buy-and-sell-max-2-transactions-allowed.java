//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int dp[][][];
    static int count(int ind, int prices[], int purchased, int times, int n){
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
    static int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][2];
        for(int i[][]: dp){
            for(int de[]:i) Arrays.fill(de,-1);
        }
        return count(0, prices, 0,2, n);
    }
}