//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        if(n<=2) return 0;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],arr[i]);
            
        }
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(arr[i],right[i+1]);
            
        }
        int ans = 0;
        for(int i=1;i<n-1;i++){
            int max = Math.max(left[i],right[i]);
            int cal = max - Math.abs(left[i]-right[i])-arr[i];
            ans += cal>0?cal:0;
        }
        return ans;
    }
}
