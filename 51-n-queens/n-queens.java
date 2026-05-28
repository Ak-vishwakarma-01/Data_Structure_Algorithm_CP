class Solution {
    private int count;
    private int n;
    private int col[];
    private int diag1[];
    private int diag2[];
    private List<List<String>> ans;
    private void solve(int y,List<String> currlist){
        if(y==n){
            count++;
            ans.add(new ArrayList<>(currlist));
            return;
        }
        StringBuilder now = new StringBuilder("");
        for(int i=0;i<n;i++) now.append('.');
        for(int x=0;x<n;x++){
            if(col[x]==1 || diag1[x+y]==1 || diag2[x-y+n-1]==1) continue;
            col[x] = diag1[x+y] = diag2[x-y+n-1] = 1;
            now.setCharAt(x,'Q');
            currlist.add(now.toString());
            solve(y+1,currlist);
            currlist.remove(y);
            now.setCharAt(x,'.');
            col[x] = diag1[x+y] = diag2[x-y+n-1] = 0;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        count = 0;
        this.n = n;
        ans = new ArrayList<>();
        col = new int[n+1];
        diag1 = new int[2*n+1];
        diag2 = new int[2*n+1];
        solve(0,new ArrayList<>());
        System.out.print(count);
        return ans;
    }
}