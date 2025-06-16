class Solution {

    private int cal(int[] he, int[] co, int mid, int n) {
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.abs(he[i] - mid) * co[i];
        }
        return cost;
    }

    public int minCost(int[] he, int[] co) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int n = he.length;

        for (int i : he) {
            l = Math.min(i, l);
            r = Math.max(i, r);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int cost1 = cal(he, co, mid, n);
            int cost2 = cal(he, co, mid + 1, n);

            if (cost1 < cost2) {
                r = mid; 
            } else {
                l = mid + 1; 
            }
        }

        return cal(he, co, l, n); 
    }
}
