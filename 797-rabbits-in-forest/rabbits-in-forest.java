class Solution {
    public int numRabbits(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 1;
        int value = nums[0];
        int count = 0;
        int ans = 0;
        while(i<len){
            if(nums[i]==value && count<value){
                count++;
            }else{
                ans += value+1;
                value = nums[i];
                count = 0;
            }  
            i++;
        }
        ans+= value+1;
        return ans;
    }
}