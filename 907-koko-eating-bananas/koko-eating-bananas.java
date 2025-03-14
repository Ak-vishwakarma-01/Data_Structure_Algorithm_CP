class Solution {
    int hour;
    private boolean check(int val, int []piles){
        int count = 0;
        for(int i:piles){
            count += i/val + (i%val != 0 ? 1 : 0);
            if(count>hour)return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        int n = piles.length;
        hour = h;
        for(int i: piles) sum += i;
        Arrays.sort(piles);
        int left  = 1 , right = piles[n-1];
        int ans = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(check(mid, piles)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}