class Solution {
    
    private int calc(int low, int high, int seive[]){
        for(int i=2;i*i<=high;i++){
            if(seive[i]==0){
                for(int j=i*i;j<=high;j +=i){
                    seive[j] = 1;
                }
            }
        }
        int ans = 0;
        for(int i=Math.max(2,low);i<=high;i++){
            if(seive[i]==0) ans += i;
        }
        return ans;
    }

    public int sumOfPrimesInRange(int n) {
        String de = Integer.toString(n);
        int rev = Integer.parseInt(new StringBuilder(de).reverse().toString());
        
        int low = Math.min(n,rev);
        int high = Math.max(rev,n);
        int seive[] = new int[high+1];
        return calc(low,high, seive);
    }
}