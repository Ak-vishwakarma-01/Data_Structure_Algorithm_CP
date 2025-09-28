class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        if(n==2) return (long)Math.abs(nums[0]-nums[1]);
        long left = nums[0];
        long right = nums[n-1];
        int i = 1,j=n-2;
        while(i<n && nums[i]>nums[i-1]){
            i++;
        }
        i--;
        while(j>=0 && nums[j]>nums[j+1]){
            j--;
        }
        j++;
        if(!(i+1>=j)) return -1;
        i=1;j=n-2;
        while(i<=j){
            if(left<right && (nums[i]>nums[i-1])){
                left += nums[i];
                i++;
            }else if(nums[j]>nums[j+1]){
                right += nums[j];
                j--;
            }else{
                while(i<=j){
                    left += nums[i];
                    i++;
                }
            }
        }
        return (long)Math.abs(left-right);
    }
}