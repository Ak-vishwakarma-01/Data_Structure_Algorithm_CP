import java.util.*;

class Solution {
    boolean isCircle = false;
    int len = 0;

    private void dfs(int node, int parent, List<Integer>[] adj, boolean[] visit) {
        visit[node] = true;
        len++;
        for (int child : adj[node]) {
            if (child != parent && visit[child]) {
                isCircle = true;
            }
            if (!visit[child]) {
                dfs(child, node, adj, visit);
            }
        }
    }

    public long maxScore(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edg : edges) {
            adj[edg[0]].add(edg[1]);
            adj[edg[1]].add(edg[0]);
        }

        List<Integer> paths = new ArrayList<>();
        List<Integer> circles = new ArrayList<>();
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, -1, adj, visit);
                if (len > 1) {
                    if (isCircle)
                        circles.add(len);
                    else
                        paths.add(len);
                }
                isCircle = false;
                len = 0;
            }
        }

        long ans = 0;
        Collections.sort(circles, (a, b) -> b - a);
        for (int i : circles) {
            ans += (long) n * (n - 1) + (long) n * (n - 2);
            n--;
            for (int j = 0; j < i - 3; j++) {
                ans += (long) n * (n - 2);
                n--;
            }
            ans += (long) n * (n - 1);
            n -= 2;
        }

        Collections.sort(paths, (a, b) -> b - a);
        for (int i : paths) {
            if (i == 2) {
                ans += (long) n * (n - 1);
                n -= 2;
                continue;
            }
            ans += (long) n * (n - 1) + (long) n * (n - 2);
            n--;
            for (int j = 0; j < i - 3; j++) {
                ans += (long) n * (n - 2);
                n--;
            }
            n -= 2;
        }
        return ans;
    }
}
