class Solution {
    int getLPSLength(String s) {
        // code here
        int n = s.length();
        int lps[] = new int[n];
        lps[0] = 0;
        int i = 1;
        int maxlen = 0;
        while(i<n){
            if(s.charAt(i)==s.charAt(maxlen)){
                maxlen++;
                lps[i] = maxlen;
                i++;
            }else{
                if(maxlen != 0){
                    maxlen = lps[maxlen-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return maxlen;
    }
}