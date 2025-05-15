//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            int result = ob.countSubstring(s);

            System.out.println(result);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countSubstring(String s) {
        // code here
        int n = s.length();
        int ans = n;
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = mp.getOrDefault(s.charAt(i),0);
            ans += val;
            mp.put(s.charAt(i) ,val+1);
        }
        return ans;
    }
}