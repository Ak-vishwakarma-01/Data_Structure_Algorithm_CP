//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the line of integers (prices)
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        
        dp[n][0] = dp[n][1] = 0;

        
        for (int ind = n - 1; ind >= 0; ind--) {
            // If we haven't purchased yet, we can either buy or skip
            dp[ind][0] = Math.max(-prices[ind] + dp[ind + 1][1], dp[ind + 1][0]);

            // If we have purchased, we can either sell or skip
            dp[ind][1] = Math.max(prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
        }

        return dp[0][0];
    }
}