class Solution {
    int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean check(int i, int j,int t, int []grid[], boolean visit[][], int n){
        if(i<0 || i>=n || j<0 || j>=n || visit[i][j] || grid[i][j]>t) return false;
        if(i==n-1 && j==n-1){
            return true;
        }
        visit[i][j] = true;
        for(int dirc[]:dir){
            int r = i+dirc[0];
            int c = j+dirc[1];
            if(check(r,c,t,grid,visit,n)) return true;
        }

        return false;
    }
    public int swimInWater(int[][] grid) {
        int n =  grid.length;
        int l = 0, r = n*n-1;
        int ans = r;
        while(l<=r){
            int mid = l + (r-l)/2;
            boolean visit[][] = new boolean[n+1][n+1];
            if(check(0,0,mid,grid,visit,n)){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return ans;
    }
}