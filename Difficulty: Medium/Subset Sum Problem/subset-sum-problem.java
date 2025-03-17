//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int dp[][];
    static boolean dfs(int i, int arr[], int sum, int n){
        if(sum==0) return true;
        if(i>=n || sum<0) return false;
        if(dp[i][sum] != -1 )return dp[i][sum]==1;
        boolean take = dfs(i+1, arr, sum-arr[i], n);
        boolean notTake = dfs(i+1, arr, sum, n);
        dp[i][sum] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        dp = new int[n+1][sum+1];
        for(int i[]:dp) Arrays.fill(i, -1);
        return dfs(0, arr, sum , n);
    }
}