//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Tn {
    Tn left;  
    Tn right; 
}

class Solution {

    private void insert(int num, Tn node) {
        Tn cr = node;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (cr.left == null) {
                    cr.left = new Tn();
                }
                cr = cr.left;
            } else {
                if (cr.right == null) {
                    cr.right = new Tn();
                }
                cr = cr.right;
            }
        }
    }

    private int maxVal(int num, Tn node) {
        int result = 0;
        Tn cr = node;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (cr.right != null) {
                    result |= 1 << i;
                    cr = cr.right;
                } else {
                    cr = cr.left;
                }
            } else {
                if (cr.left != null) {
                    result |= 1 << i;
                    cr = cr.left;
                } else {
                    cr = cr.right;
                }
            }
        }
        return result;
    }

    public int maxXor(int[] arr) {
        Tn node = new Tn();

        for (int i : arr) {
            insert(i, node);
        }

        int result = 0;
        for (int i : arr) {
            int get = maxVal(i, node);
            result = Math.max(result, get);
        }

        return result;
    }
}
