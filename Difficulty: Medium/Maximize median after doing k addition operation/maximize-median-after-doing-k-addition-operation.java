class Solution {
    private boolean check(int[] arr, int mid, int k, int n){
        if(n%2==1){
            for(int i=n/2;i<n;i++){
                if(arr[i]<mid){
                    k -= mid-arr[i];
                }
                if(k<0) break;
            }
        }else{
            k -= (2*mid - (arr[n/2]+arr[n/2-1]));
            for(int i=n/2+1;i<n;i++){
                if(arr[i]<mid){
                    k -= mid-arr[i];
                }
                if(k<0) break;
            }
        }
        return k>=0;
    }
    
    public int maximizeMedian(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int median = n%2 != 0 ? arr[n/2] : (arr[n/2] + arr[n/2-1])/2;
        int l = median, r = median+k;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(check(arr,mid,k,n)){
                l = mid+1;
                median = mid;
            }else{
                r = mid-1;
            }
        }
        return median;
    }
}
