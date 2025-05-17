//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        int minRange = Integer.MAX_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, 0, arr[i][0]));
            maxVal = Math.max(maxVal, arr[i][0]);
        }

        while (true) {
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int minVal = p.val;

            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                start = minVal;
                end = maxVal;
            }

            if (col + 1 >= n) {
                break;
            }

            int nextVal = arr[row][col + 1];
            pq.add(new Pair(row, col + 1, nextVal));
            maxVal = Math.max(maxVal, nextVal);
        }

        return new ArrayList<>(Arrays.asList(start, end));
    }
}

class Pair {
    int row;  
    int col;  
    int val;

    public Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}


