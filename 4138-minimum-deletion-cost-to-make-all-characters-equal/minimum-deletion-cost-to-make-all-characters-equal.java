class Solution {
    public long minCost(String s, int[] cost) {
        Map<Character, Long> mp = new HashMap<>();
        int n = s.length();
        long sum = 0;
        for(int i=0;i<n;i++){
            mp.put(s.charAt(i),(long)((long)(mp.getOrDefault(s.charAt(i),(long)0))+cost[i]));
            sum = (long)(sum+cost[i]);
        }
        long currsum = Integer.MIN_VALUE;
        for(Map.Entry<Character,Long> it: mp.entrySet()){
            currsum = Math.max(currsum,it.getValue());
        }
        return (long)(sum-currsum);
    }
}

class Pair{
    char c;
    int num;
    public Pair(char c, int num){
        this.c = c;
        this.num = num;
    }
}