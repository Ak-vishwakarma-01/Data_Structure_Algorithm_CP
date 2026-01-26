class Solution {
    public String removeKdig(String s, int k) {
        // code here
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<n;i++){
            
            while(k!=0 && !st.isEmpty() && (s.charAt(i)-0)<(st.peek()-0)){
                st.pop();
                k--;
            }
            st.add(s.charAt(i));
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb = sb.reverse();
        n = sb.length();
        int i = 0;
        while(i<n && sb.charAt(i)=='0')i++;
        String ans = sb.toString().substring(i);
        return ans==""?"0":ans;
    }
}