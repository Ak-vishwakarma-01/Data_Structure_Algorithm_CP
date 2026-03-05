class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i =0,j=0;
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        int ans = -1;
        while(i<=j && j<n){
            char c = s.charAt(j);
            mp.put(c,mp.getOrDefault(c,0)+1);
            while(mp.size()>k){
                int num = mp.get(s.charAt(i));
                if(num==1) mp.remove(s.charAt(i));
                else mp.put(s.charAt(i),num-1);
                i++;
            }
            if(mp.size()==k)ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}