class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int j=0;
        Arrays.sort(nums);
        int maxlen = 1;
        for(int i =0;i<n;i++){
            long mink = (long)nums[i]*k;
            while(j<n && (long)nums[j]<=mink){
                j++;
            }
            maxlen = Math.max(maxlen, (j-i));
        }
        return n-maxlen;
    }
}