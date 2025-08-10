class Solution {
    
    public int countPS(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n + 1][n + 1];
        
        int ans = 0;
        for(int l=1;l<=n;l++){
            for(int i=0;i+l-1<n ;i++){
                int j = i+l-1;
                if(i==j) dp[i][j] = true;
                else if(i+1==j){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                if(l>=2 && dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
