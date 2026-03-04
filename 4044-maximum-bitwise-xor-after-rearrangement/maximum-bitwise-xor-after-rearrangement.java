class Solution {
    public String maximumXor(String s, String t) {
        int n  = s.length();
        StringBuilder sb = new StringBuilder("");
        int one_zero[] = new int[2];
        for(char de:t.toCharArray()){
            if(de=='0') one_zero[0]++;
            else one_zero[1]++;
        }
        for(char de:s.toCharArray()){
            if(de=='1' && one_zero[0]>0){
                sb.append("1");
                one_zero[0]--;
            }else if(de=='0' && one_zero[1]>0){
                sb.append("1");
                one_zero[1]--;
            }else sb.append("0");
        }
        return sb.toString();
    }
}