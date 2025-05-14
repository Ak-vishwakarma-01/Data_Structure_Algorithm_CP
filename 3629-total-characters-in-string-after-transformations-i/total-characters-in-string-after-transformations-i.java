class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] abc = new long[26];

        for (char c : s.toCharArray()) {
            abc[c - 'a']++;
        }

        while (t-- > 0) {
            long zCount = abc[25]; 
            for (int i = 25; i > 0; i--) {
                abc[i] = abc[i - 1]; 
            }
            abc[0] = zCount;                  
            abc[1] = (abc[1] + zCount) % MOD; 
        }

        long ans = 0;
        for (long val : abc) {
            ans = (ans + val) % MOD;
        }

        return (int) ans;
    }
}
