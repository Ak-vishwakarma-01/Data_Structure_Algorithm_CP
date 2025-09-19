class Solution {
    public int minParentheses(String s) {
        // code here
        int num = 0;
        int ans = 0;
        for(char c: s.toCharArray()){
            if(c=='(') num++;
            else {
                if(num==0) ans++;
                else num--;
            }
        }
        return ans+num;
    }
}
