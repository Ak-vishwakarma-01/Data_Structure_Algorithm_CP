class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int n  = arr.length;
        int l = 0,r=0;
        int count0 = 0;
        int ans = 0;
        int currans = 0;
        while(r<n){
            if(arr[r]==0)count0++;
            while(l<n && count0>k){
                currans--;
                if(arr[l]==0)count0--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}