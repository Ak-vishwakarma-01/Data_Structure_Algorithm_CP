class Solution {
    public int binaryGap(int n) {
        int last = -1;
        int count = 0;
        int ans = 0;
        while(n>0){
            boolean dekh = (n&1)==1;
            if(dekh){
                if(last!=-1){
                    ans = Math.max(ans,count-last);
                }
                last = count;
            }
            count++;
            n = n>>1;
        }
        return ans;
    }
}