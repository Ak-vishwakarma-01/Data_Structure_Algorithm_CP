class Solution {
    public int minOperations(String s) {
        int ans = Integer.MIN_VALUE;
        for(char c: s.toCharArray()){
            if(c!='a') ans = Math.max(ans,Math.abs(c-'z')+1);
        }
        return ans==Integer.MIN_VALUE? 0 : ans;
    }
}