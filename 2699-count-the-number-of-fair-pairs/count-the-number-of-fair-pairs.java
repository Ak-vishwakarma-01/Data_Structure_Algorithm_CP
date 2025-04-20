class Solution {
    private int lowerBound(int[] nums, int l, int r , int val){
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]<=val){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int low = lowerBound(nums, i + 1, n - 1, lower - nums[i]-1);
            int high = lowerBound(nums, i + 1, n - 1, upper - nums[i]);
            ans += (high - low);
        }

        return ans;
    }
}