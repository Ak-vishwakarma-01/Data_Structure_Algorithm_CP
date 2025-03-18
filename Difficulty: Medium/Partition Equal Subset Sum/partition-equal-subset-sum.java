//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static Boolean dp[][];
    static boolean dfs(int i, int arr[], int sum, int n){
        if(sum==0) return true;
        if(i>=n || sum<0) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        boolean take = dfs(i+1, arr, sum-arr[i], n);
        boolean notTake = dfs(i+1, arr, sum, n);
        return dp[i][sum] = take || notTake;
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        int sum =0;
        for(int i: arr) sum += i;
        if(sum%2 != 0) return false;
        dp = new Boolean[n+1][sum/2+1];
        return dfs( 0, arr, sum/2, n);
    }
}