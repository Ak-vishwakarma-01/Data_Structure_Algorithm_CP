class Solution {
    Map<String,Integer> mp;
    private int dfs(int a, int b, int cuts[], int len){
    int ans = Integer.MAX_VALUE;
    String key = a + "/" + b+ "/";
    if(mp.containsKey(key)) return mp.get(key);
    for(int i = 0; i < len; i++){
        if(cuts[i] == -1 || cuts[i] <= a || cuts[i] >= b) continue;

        int c = cuts[i];
        cuts[i] = -1;

        int left = dfs(a, c, cuts, len);
        int right = dfs(c, b, cuts, len);

        ans = Math.min(ans, left + right);

        cuts[i] = c;
    }

    if(ans == Integer.MAX_VALUE){
        mp.put(key,0);
        return 0;
    }
    mp.put(key, (b-a)+ans);
    return (b - a) + ans;
}

public int minCutCost(int n, int[] cuts) {
    mp = new HashMap<>();
    return dfs(0, n, cuts, cuts.length);
}

}
