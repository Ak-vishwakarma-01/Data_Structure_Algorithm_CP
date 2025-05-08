//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] res = new int[n];
        Arrays.fill(res, 0);  // simulate super source

        for (int i = 0; i < n; i++) {
            for (int[] edg : edges) {
                int u = edg[0];
                int v = edg[1];
                int w = edg[2];

                if (res[u] + w < res[v]) {
                    if (i == n - 1) return 1;
                    res[v] = res[u] + w;
                }
            }
        }
        return 0;
    }
}

