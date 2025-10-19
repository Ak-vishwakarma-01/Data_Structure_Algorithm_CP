class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int j=0;j<n;j++){
            Set<Integer> eve = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            for(int k=j;k<n;k++){
                if(nums[k]%2==0) eve.add(nums[k]);
                else odd.add(nums[k]);
                if(eve.size()==odd.size()) ans = Math.max(ans,k-j+1);
            }
        }
    return ans==Integer.MIN_VALUE?0:ans;
    }
}