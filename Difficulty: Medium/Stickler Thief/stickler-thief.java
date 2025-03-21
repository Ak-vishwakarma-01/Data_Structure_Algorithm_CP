//{ Driver Code Starts
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

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int dp[];
    private int dfs(int ind, int []arr, int n){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int take  = arr[ind] + dfs(ind+2,arr,n);
        int notTake = dfs(ind+1,arr,n);
        return dp[ind] = Math.max(take,notTake);
    }
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(0, arr, n);
    }
}