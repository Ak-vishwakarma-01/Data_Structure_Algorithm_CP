class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int max = 0;
        for(int i = 0;i<k;i++){
            max = max^arr[i];
        }
        ans = Math.max(max,ans);
        for(int i=k;i<n;i++){
            max = max^arr[i]^arr[i-k];
            ans = Math.max(max,ans);
        }
        return ans;
    }
}
