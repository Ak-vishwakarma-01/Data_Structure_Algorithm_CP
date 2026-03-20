class Solution {
    public int countPrimes(int n) {
        boolean sieve[] = new boolean[n+1];
        Arrays.fill(sieve,true);
        for(int i=2;i*i<=n;i++){
            for(int j=2;j*i<=n;j++){
                if(sieve[i*j]==true){
                    sieve[i*j]=false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(sieve[i]==true)count++;
        }
        return count;
    }
}