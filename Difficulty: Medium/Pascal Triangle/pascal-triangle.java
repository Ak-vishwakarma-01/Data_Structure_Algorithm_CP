//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        ArrayList<Integer> ans = new ArrayList<>();
        int len = 1;
        while(len<n){
            ans.add(1);
            for(int i=0;i<len-1;i++){
                ans.add(first.get(i)+first.get(i+1));
            }
            ans.add(1);
            
            first = ans;
            ans = new ArrayList<>();
            len++ ;
            
        }
        
        return first;
    }
}