class Solution {
    int subsetXORSum(int arr[]) {
        // code here
        int n = arr.length;
        int ans = 0;
        for(int i: arr){
            ans |= i;
        }
        for(int i=0;i<n-1;i++){
            ans = ans<<1;
        }
        return ans;
    }
}