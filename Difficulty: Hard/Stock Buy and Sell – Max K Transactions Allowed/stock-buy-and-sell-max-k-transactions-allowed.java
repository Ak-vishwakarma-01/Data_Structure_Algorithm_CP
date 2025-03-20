//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int dp[][][];
    public int maxProfit(int prices[], int k) {
        int n = prices.length;
        dp = new int[n + 1][2][k+1];
        for (int i[][] : dp) {
            for (int de[] : i)
                Arrays.fill(de, 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int purchased = 0; purchased <= 1; purchased++) {
                for (int transactions = 1; transactions <= k; transactions++) {
                    if (purchased == 1) { // purchased
                        dp[i][purchased][transactions] = Math.max(prices[i] + dp[i+1][0][transactions-1] , dp[i+1][1][transactions]);
                    } else { // not purchased
                        dp[i][purchased][transactions] = Math.max( -prices[i] + dp[i+1][1][transactions], dp[i+1][0][transactions]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}