class Solution {
    public int smallestNumber(int n) {
        int count = 0, lastbit = 0;
        while(n>0){
            boolean flag = false;
            if( (n&1) == 1) flag = true;
            n = n>>1;
            count++;
            if(flag) lastbit = count;
        }
        int ans = 0;
        while(lastbit>0){
            ans = ans | 1;
            if(lastbit==1) break;
            ans = ans << 1;
            lastbit--;
        }
        return ans;
    }
}