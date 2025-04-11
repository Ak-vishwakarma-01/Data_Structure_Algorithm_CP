class Solution {
     private long solve(String str, String suffix, int limit) {
         if (str.length() < suffix.length()) {
             return 0;
         }
 
         long count = 0;
         String ramin = str.substring(str.length() - suffix.length());
         int remainlen = str.length() - suffix.length();
 
         for (int i = 0; i < remainlen; i++) {
             int digit = str.charAt(i) - '0';
 
             if (digit <= limit) {
                 count += digit * Math.pow(limit + 1, remainlen - i - 1);
             } else {
                 count += Math.pow(limit + 1, remainlen - i);
                 return count;
             }
         }
 
         if (ramin.compareTo(suffix) >= 0) {
             count++;
         }
 
         return count;
     }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long first = solve(Long.toString(start-1), s ,limit);
        long second = solve(Long.toString(finish) ,s, limit); 
        return second - first;   
    }
}