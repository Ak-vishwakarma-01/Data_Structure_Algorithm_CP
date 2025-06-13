class Solution {
    private int check(int [] arr, int num){
        int count = 0;
        for(int i:arr){
            count += i/num;
            count += i%num != 0 ? 1 : 0;
        }
        return count;
    }
    public int kokoEat(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int r = Integer.MIN_VALUE;
        for(int i:arr) {
            r = Math.max(i, r);
        }
        int l = 1;
        int ans = 0 ;
        while(l<=r){
            int mid = l+ (r-l)/2;
            int count = check(arr, mid);
            if(count>k){
                l = mid+1;
            }else{
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
}
