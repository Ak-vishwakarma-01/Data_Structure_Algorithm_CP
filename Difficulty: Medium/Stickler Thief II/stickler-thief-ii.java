//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private int dfs(int ind, int []arr, int n, int dp[]){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int take  = arr[ind] + dfs(ind+2,arr,n,dp);
        int notTake = dfs(ind+1,arr,n,dp);
        return dp[ind] = Math.max(take,notTake);
    }
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        int dp1[] = new int[n+1];
        int dp2[] = new int[n+1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int take = arr[0] + dfs(2,arr,n-1, dp1);
        int notTake = dfs(1,arr, n, dp2);
        return Math.max(take,notTake);
    }
}
