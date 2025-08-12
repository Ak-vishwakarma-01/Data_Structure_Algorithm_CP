class Solution {
    int getLongestPrefix(String s) {
        // code here
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.substring(0,i+1).equals(s.substring(n-(i+1)))) return n-(i+1);
        }
        return -1;
    }
}