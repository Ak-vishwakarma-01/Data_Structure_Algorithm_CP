class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] normalpresum = new long[n];
        long[] calcpresum = new long[n];

        normalpresum[0] = prices[0];
        calcpresum[0] = (long) prices[0] * strategy[0];

        for (int i = 1; i < n; i++) {
            normalpresum[i] = prices[i] + normalpresum[i - 1];
            calcpresum[i] = (long) prices[i] * strategy[i] + calcpresum[i - 1];
        }

        long anssum = calcpresum[n - 1];
        long calcsum = anssum;
        long ans = anssum;

        for (int i = k - 1; i < n; i++) {
            long currsum;
            if (i - k >= 0) {
                currsum = calcsum - (calcpresum[i] - calcpresum[i - k]);
                currsum += normalpresum[i] - normalpresum[i - k / 2];
            } else {
                currsum = calcsum - calcpresum[i];
                currsum += normalpresum[i] - normalpresum[i - k / 2];
            }
            ans = Math.max(ans, currsum);
        }
        return ans;
    }
}
