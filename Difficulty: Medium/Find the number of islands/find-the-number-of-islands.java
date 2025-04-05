//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    private void dfs(int i, int j, char []grid[], int m ,int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='W') return;
        
        grid[i][j] = 'W';
        dfs(i+1, j , grid, m, n);
        dfs(i, j+1 , grid, m, n);
        dfs(i, j-1 , grid, m, n);
        dfs(i-1, j , grid, m, n);
        dfs(i-1, j-1 , grid, m, n);
        dfs(i+1, j+1 , grid, m, n);
        dfs(i-1, j+1 , grid, m, n);
        dfs(i+1, j-1 , grid, m, n);
    }
    public int countIslands(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='L'){
                    count++;
                    dfs(i, j, grid, m , n);
                }
            }
        }
        return count;
    }
}