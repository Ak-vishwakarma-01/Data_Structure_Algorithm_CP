//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    private void dfs(int r, int c, int[][] image, int originalColor, int newColor, int m, int n) {
       
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != originalColor || image[r][c] == newColor)
            return;

        image[r][c] = newColor;

        dfs(r + 1, c, image, originalColor, newColor, m, n);
        dfs(r - 1, c, image, originalColor, newColor, m, n);
        dfs(r, c + 1, image, originalColor, newColor, m, n);
        dfs(r, c - 1, image, originalColor, newColor, m, n);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];

        if (originalColor != newColor) {
            dfs(sr, sc, image, originalColor, newColor, m, n);
        }

        return image;
    }
}
