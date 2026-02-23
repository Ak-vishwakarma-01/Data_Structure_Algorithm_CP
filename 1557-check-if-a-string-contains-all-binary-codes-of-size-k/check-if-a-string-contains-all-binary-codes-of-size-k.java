class Solution {
    
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> st = new HashSet<>();
        for(int i=k;i<=n;i++){
            st.add(s.substring(i-k,i));
        }
        for(var de: st) System.out.println(de);
        if(st.size()==Math.pow(2,k)) return true;
        return false;
    }
}