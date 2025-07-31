import java.util.*;

class Solution {
    public int powerfulInteger(int[][] inter, int k) {
        int n = inter.length;
        TreeMap<Integer, Integer> diff = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            int start = inter[i][0];
            int end = inter[i][1];

            diff.put(start, diff.getOrDefault(start, 0) + 1);
            diff.put(end + 1, diff.getOrDefault(end + 1, 0) - 1);
        }

        int count = 0;
        int lastPos = -1;
        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int currPos = entry.getKey();

            if (count >= k && lastPos != -1) {
                ans = Math.max(ans, currPos - 1);
            }

            count += entry.getValue();
            lastPos = currPos;
        }

        return ans == -1 ? -1 : ans;
    }
}
