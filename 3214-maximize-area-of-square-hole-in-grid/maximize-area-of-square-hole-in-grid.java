class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = 2;
        int v = 2;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int currh = 1;
        int currv = 1; 
        int nlen = hBars.length;
        int mlen = vBars.length;
        for(int i=1;i<nlen;i++){
            if(hBars[i]!=(hBars[i-1]+1)){
                h = Math.max(h,currh+1);
                currh = 1;
            }else{
                currh++;
            }
        }
        for(int i=1;i<mlen;i++){
            if(vBars[i]!=(vBars[i-1]+1)){
                v = Math.max(v,currv+1);
                currv = 1;
            }else{
                currv++;
            }
        }
        h = Math.max(h,currh+1);
        v = Math.max(v,currv+1);
        System.out.println(h+"     "+v);
        int de = Math.min(h,v);
        return de*de;
    }
}