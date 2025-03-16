class Solution {
    int n;
    private boolean count(int mid, int[] nums, int k, int n){
        int house = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<=mid){
                house++;
                i++;
            }
            if(house==k) return true;
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
        n = nums.length;
        int l  = Integer.MAX_VALUE , r = Integer.MIN_VALUE;
        for(int i: nums){
            l = Math.min(l, i);
            r = Math.max(r,i);
        }
        int ans = 0;
        while(l<=r){
            int  mid = (l+r)/2;
            int houses = 0;

            for (int index = 0; index < n; ++index) {
                if (nums[index] <= mid) {
                    houses++;
                    index++;
                }
                if(houses>=k){
                    ans = mid;
                    r = mid-1;
                    break;
                }
            }
            if(houses<k){
                l = mid+1;
            }
        }
        return ans;
    }
}