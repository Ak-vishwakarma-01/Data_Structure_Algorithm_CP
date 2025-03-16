//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int dp[];
    static int jump(int ind,int []arr, int n){
        if(ind>=n-1) return 0;
        if(arr[ind]==0) return Integer.MIN_VALUE;
        if(dp[ind]!=-1)return dp[ind]; 
        int le = ind+arr[ind];
        int ans = Integer.MAX_VALUE;
        int countCorrect = 0;
        for(int i=ind;i<le;i++){
            int de = jump(i+1, arr, n);
            if(de>=0){
                ans = Math.min(ans,1 + de);
                countCorrect++;
            }
        }
        if(countCorrect==0) return dp[ind] = Integer.MIN_VALUE;
        return dp[ind] = ans;
    }
    static int minJumps(int[] arr) {
        int n = arr.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = jump(0, arr, n);
    
        if(ans<0) return -1;
        return ans;
    }
}