class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int lastmn = -1;
        int lastmx = -1;
        int startindex = 0;
        int lastindex = -1;
        long ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK){
                startindex = i+1;
                lastmn = -1;
                lastmx = -1;
                lastindex = -1;
            }else if(nums[i]==minK){
                if(minK==maxK)lastmx = i;
                lastmn = i;
                lastindex = lastmx;
            }else if(nums[i]==maxK){
                lastmx = i;
                if(lastmn!=-1) lastindex = lastmn;
            }else{
                if(lastmx!=-1 && lastmn != -1)lastindex = Math.min(lastmn, lastmx);
            }
            if(lastindex != -1) ans += lastindex - startindex + 1;
        }
        return ans;
    }
}