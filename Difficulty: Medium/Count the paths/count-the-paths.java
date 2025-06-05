import java.util.*;

class Solution {
    boolean inre[];
    int dp[];
    private int dfs(int src, int dest, List<Integer> adj[]) {
        if (src == dest) {
            return 1;
        }
        if(dp[src] != -1) return dp[src];
        inre[src] = true;
        int ans = 0;
        for (int node : adj[src]) {
            if (inre[node]) continue;
            ans += dfs(node, dest, adj);
        }
        inre[src] = false;
        return dp[src] = ans;
    }

    public int countPaths(int[][] edges, int v, int src, int dest) {
        List<Integer> adj[] = new ArrayList[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();
        for (int[] edg : edges) {
            adj[edg[0]].add(edg[1]);
        }
        dp = new int[v];
        Arrays.fill(dp, -1);
        inre = new boolean[v];
        return dfs(src, dest, adj);
    }
}
