class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int i =0;
        int one = 0; 
        while(i<n && s.charAt(i)=='0'){
            i++;
        }
        while(i<n && s.charAt(i)=='1'){
            i++;
            one++;
        }
        while(i<n && s.charAt(i)=='0'){
            i++;
        }
        while(i<n && s.charAt(i)=='1'){
            i++;
            if(one>0) return false;
        }
        return true;
    }
}