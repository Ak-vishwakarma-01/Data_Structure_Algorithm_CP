class Solution {
    public int concatenatedBinary(int n) {
        int num = 1;
        int modulo = 1_000_000_007;
        for(int i=2;i<=n;i++){
            StringBuilder sb = new StringBuilder("");
            int curr_num = i;
            while(curr_num>0){
                int bit = curr_num&1;
                sb.append(Integer.toString(bit));
                curr_num = curr_num>>1;
            }
            sb = sb.reverse();
            for( char de: sb.toString().toCharArray()){
                num = num<<1;
                if(de=='1'){
                    num = num|1;
                }
                num = num%modulo;
            }
        } 
        return num;
    }
}