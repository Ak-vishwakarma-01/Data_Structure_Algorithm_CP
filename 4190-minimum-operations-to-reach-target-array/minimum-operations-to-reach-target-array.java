class Solution {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> st = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=target[i]) st.add(nums[i]);
        }
        return st.size();
    }
}