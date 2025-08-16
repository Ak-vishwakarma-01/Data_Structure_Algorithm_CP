class Solution {
    public String findLargest(int[] arr) {
        // code here
        int n = arr.length;
        String st[] = new String[n];
        for(int i=0;i<n;i++){
            st[i] = Integer.toString(arr[i]);
        }
        Arrays.sort(st, (a,b)->{
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        StringBuilder sb = new StringBuilder("");
        for(String de: st){
            sb.append(de);
        }
        if(sb.length()>=2 && sb.charAt(0)=='0' && sb.charAt(1)=='0') return "0";
        return sb.toString();
    }
}