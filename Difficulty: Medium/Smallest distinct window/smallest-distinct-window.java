//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        int n = str.length();
        Map<Character,Integer> st = new HashMap<>();
        for(char c: str.toCharArray()){
            st.put(c, st.getOrDefault(c,0)+1);
        }
        int len = st.size();
        if(len==1) return 1;
        st =  new HashMap<>();
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        while(i<=j && j<n){
            st.put(str.charAt(j), st.getOrDefault(str.charAt(j),0)+1);
            while(st.size()>=len){
                ans = Math.min(ans, j-i+1);
                int v = st.get(str.charAt(i));
                if(v==1) st.remove(str.charAt(i));
                else st.put(str.charAt(i),v-1);
                i++;
            }
            j++;
        }
        return ans;
    }
}