//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int direction[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] mat) {
        if (mat == null || mat.length == 0) return -1;

        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                } else if (mat[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        int time = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], t = curr[2];

            time = Math.max(time, t);

            for (int[] dir : direction) {
                int x = r + dir[0], y = c + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == 1) {
                    mat[x][y] = 2; 
                    freshOranges--; 
                    queue.add(new int[]{x, y, t + 1});
                }
            }
        }

        return freshOranges == 0 ? time : -1;
    }
}