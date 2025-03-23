//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    private int le(int ind, String dig, int n, int[] dp) {
        if (ind == n) return 1;
        if (dig.charAt(ind) == '0') return 0; 
        if (dp[ind] != -1) return dp[ind]; 
        
        int ans = le(ind + 1, dig, n, dp);
        
        if (ind < n - 1) { 
            int num = Integer.parseInt(dig.substring(ind, ind + 2)); 
            if (num >= 10 && num <= 26) {
                ans += le(ind + 2, dig, n, dp); 
            }
        }
        
        return dp[ind] = ans;
    }

    public int countWays(String digits) {
        int n = digits.length();
        int[] dp = new int[n]; 
        Arrays.fill(dp, -1); 
        return le(0, digits, n, dp);
    }
}