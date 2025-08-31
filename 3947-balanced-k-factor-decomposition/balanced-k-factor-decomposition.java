import java.util.*;

class Solution {
    int ans[];
    int ansmin = Integer.MAX_VALUE; 

    private void solve(int idx, Set<Integer> valid, int r, int curr[], int k) {
        if (r <= 0) return;

        if (k == 1) {
            curr[idx] = r;
            int small = Integer.MAX_VALUE;
            int large = Integer.MIN_VALUE;

            for (int val : curr) {
                small = Math.min(small, val);
                large = Math.max(large, val);
            }

            if (ansmin > Math.abs(large - small)) {
                int i = 0;
                for (int de : curr) {
                    ans[i++] = de;
                }
                ansmin = Math.abs(large - small);
            }
            return;
        }

        for (int val : valid) {
            if (r % val == 0) {
                curr[idx] = val;
                solve(idx + 1, valid, r / val, curr, k - 1);
            }
        }
    }

    public int[] minDifference(int n, int k) {
        int sq = (int) Math.sqrt(n);
        Set<Integer> valid = new HashSet<>();
        for (int i = 1; i <= sq; i++) {
            if (n % i == 0) {
                valid.add(i);
                // valid.add(n / i); 
            }
        }

        ans = new int[k];
        int[] curr = new int[k];
        solve(0, valid, n, curr, k);
        return ans;
    }
}
