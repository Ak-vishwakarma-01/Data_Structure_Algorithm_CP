class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int ans[] = new int[2];
        Set<Integer> st = new HashSet<>();
        int count  = 0;
        for(int i:nums){
            if(st.contains(i)){
                if(count==0){
                    ans[0]=i;
                    count++;
                }else{
                    ans[1] = i;
                    break;
                }
            }
            st.add(i);
        }
        return ans;
    }
}