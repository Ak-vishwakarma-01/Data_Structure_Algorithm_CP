class Solution {
    public int maximum69Number (int num) {
        String st = Integer.toString(num);
        String seco = "";
        boolean flag = true;
        for(char c: st.toCharArray()){
            if(c=='6' && flag){
                seco += '9';
                flag = false;
            }else{
                seco += c;
            }
        }
        return Integer.parseInt(seco);
    }
}