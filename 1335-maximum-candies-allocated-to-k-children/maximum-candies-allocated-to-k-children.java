class Solution {
    long childrens;
    int n;
    private boolean check(int ind, int [] candies){
        long count = 0;
        for(int i = 0;i<n;i++){
            count += candies[i]/ind;
            if(count>=childrens){ 
              return true;  
            } 
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        childrens =  k;
        n  = candies.length;
        for(int i: candies) sum += i;
        if(sum<k)return 0;
        Arrays.sort(candies); 
        int left = 1, right = (int)(sum / k); ;
        int ans = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(check(mid, candies)){
                ans  = mid;
                left = mid+1;
            }else{
                right =  mid-1;
            }
        }
        return ans;
    }
}