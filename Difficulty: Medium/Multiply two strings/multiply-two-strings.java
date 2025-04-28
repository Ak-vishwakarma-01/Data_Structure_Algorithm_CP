//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static final BigInteger TEN = new BigInteger("10");
    
    public String multiplyStrings(String s1, String s2) {
        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("0");
        boolean minus = false;
        int i = 0;
        
        char c = s1.charAt(i);
        if (c == '-' || c == '+') {
            if (c == '-') minus = true;
            i++;
        }
        int len = s1.length();
        for (; i < len; i++) {
            int digit = s1.charAt(i) - '0';
            num1 = num1.multiply(TEN).add(BigInteger.valueOf(digit));
        }
        if (minus) num1 = num1.negate();
        
        minus = false;
        i = 0;
        c = s2.charAt(i);
        if (c == '-' || c == '+') {
            if (c == '-') minus = true;
            i++;
        }
        len = s2.length();
        for (; i < len; i++) {
            int digit = s2.charAt(i) - '0';
            num2 = num2.multiply(TEN).add(BigInteger.valueOf(digit));  // <-- no new BigInteger(TEN)
        }
        if (minus) num2 = num2.negate();
        
        return num1.multiply(num2).toString();
        
    }
}