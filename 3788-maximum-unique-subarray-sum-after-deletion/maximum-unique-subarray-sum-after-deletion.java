class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(max, i);
            if(i>0)st.add(i);
        }   
        int ans = 0;
        for(int ele: st){
            ans += ele;
        }
        return ans==0 ? max: ans;
    }
}