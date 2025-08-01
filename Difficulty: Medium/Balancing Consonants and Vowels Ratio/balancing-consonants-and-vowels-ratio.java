class Solution {
    private boolean vov(char c){
        if(c=='a' || c=='i' || c=='o' || c=='u' || c=='e') return true;
        return false;
    }
    public int countBalanced(String[] arr) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int score = 0;
        mp.put(0,1);
        int ans = 0;
        for(String s: arr){
            for(char c: s.toCharArray()){
                if(vov(c)) score++;
                else score--;
            }
            
            ans += mp.getOrDefault(score,0);
            mp.put(score,mp.getOrDefault(score,0)+1);
        }
        return ans;
    }
}