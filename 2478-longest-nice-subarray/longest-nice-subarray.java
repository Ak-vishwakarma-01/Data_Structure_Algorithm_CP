class Solution {
    public int longestNiceSubarray(int[] nums) {
        int subArray = 1;
        int i = 0, j = 1;
        int num = nums[i];
        int n = nums.length;
        while(i<=j && j<n){
            if((num&nums[j])==0){
                num |= nums[j];
                subArray = Math.max(subArray,j-i+1);
                j++;
            }else{
                num &= ~nums[i];
                i++;
            }
        }
        return subArray;
    }
}